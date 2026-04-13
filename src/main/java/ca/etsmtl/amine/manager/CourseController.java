package ca.etsmtl.amine.manager;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController // This tells Spring: "I am an entry point for the web!"
public class CourseController {

    private final CourseRepository repository;

    // We "Inject" the repository here so the controller can use it
    public CourseController(CourseRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/courses") // This maps the URL "localhost:8080/courses" to this method
    public List<Course> getAllCourses() {
        return repository.findAll();
    }

    @GetMapping("/add-test")
    public String addTestCourse(){
        repository.save(new Course("TUTORIAL-101", 100.0));

        return "Course added successfully!";
    }

    @PostMapping("/courses") // Note: This is @PostMapping, not @GetMapping!
    public Course createCourse(@RequestBody Course newCourse) {
        // @RequestBody tells Spring: "Look at the JSON package the user sent,
        // and try to turn it into a Course object automatically."
        return repository.save(newCourse);
    }

    @PutMapping("/courses/{id}")
    public Course updateCourse(@PathVariable Long id, @RequestBody Course updatedCourse) {
        //"Try to find the course by ID. If you find it, update its name and grade. Else, if it's missing, just create a new one."
        return repository.findById(id)
                .map(course -> {
                    course.setName(updatedCourse.getName());
                    course.setGrade(updatedCourse.getGrade());
                    return repository.save(course);
                })
                .orElseGet(() -> {
                    // If the ID doesn't exist, we just save it as a new entry
                    return repository.save(updatedCourse);
                });
    }

    @DeleteMapping("/courses/{id}") // The {id} is a placeholder!
    public void deleteCourse(@PathVariable Long id) {
        // @PathVariable tells Spring: "Grab the number from the URL and put it in this 'id' variable"
        repository.deleteById(id);
    }

}