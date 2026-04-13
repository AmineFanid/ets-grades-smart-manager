package ca.etsmtl.amine.manager;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ManagerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ManagerApplication.class, args);
	}

	@Bean
	CommandLineRunner start(CourseRepository repository) {
		//CommandLineRunner: This is a special tool that runs code immediately after the app starts. It's great for testing if your database connection is working.
		return args -> {
			// Intern: We are saving a course to the database here!
			repository.save(new Course("LOG210", 85.0));
			repository.save(new Course("GPE450", 92.5));

			System.out.println("Courses have been saved to the database!");
			repository.findAll().forEach(c -> System.out.println(c.getName() + ": " + c.getGrade()));
		};
	}

}
