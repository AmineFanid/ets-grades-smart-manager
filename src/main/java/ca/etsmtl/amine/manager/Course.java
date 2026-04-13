package ca.etsmtl.amine.manager;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity // This tells Spring: "Hey, save this into the database!"
//@Entity is a "Decorator." It’s magic that tells the H2 database to create a table for you automatically.

public class Course {

    @Id // This is the unique ID (like a student ID) for this specific course
    @GeneratedValue
    private Long id;

    private String name;
    private double grade;

    // Intern: You need a "Default Constructor" (an empty one)
    // for the database to work.
    public Course() {}

    public Course(String name, double grade) {
        this.name = name;
        this.grade = grade;
    }

    // Getters and Setters go here...
    // (Hint: In IntelliJ, press Alt+Insert to generate them automatically!)

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getGrade() {
        return grade;
    }

    public void setGrade(double grade) {
        this.grade = grade;
    }
}
