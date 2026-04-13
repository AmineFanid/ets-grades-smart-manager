package ca.etsmtl.amine.manager;

import org.springframework.data.jpa.repository.JpaRepository;

// We extend JpaRepository.
// The <Course, Long> tells it: "I manage Courses, and their ID is a Long."
public interface CourseRepository extends JpaRepository<Course, Long> {
}