package com.sydoruk.model;

import java.sql.Timestamp;
import java.util.List;

public class StudentBuilder {

    private String firstName;
    private String lastName;
    private Timestamp ts;
    private int age;
    private StudentGroup group;
    private List<Rating> ratings;

    public StudentBuilder withFirstName(String name) {
        this.firstName = name;
        return this;
    }

    public StudentBuilder withLastName(String name) {
        this.lastName = name;
        return this;
    }

    public StudentBuilder withAge(int age) {
        this.age = age;
        return this;
    }

    public StudentBuilder withEnrollmentDate(Timestamp ts) {
        this.ts = ts;
        return this;
    }

    public StudentBuilder withStudentGroup(StudentGroup group) {
        this.group = group;
        return this;
    }

    public StudentBuilder withRatings(List<Rating> ratings) {
        this.ratings = ratings;
        return this;
    }

    public Student build() {
        return new Student(firstName, lastName, age, ts, group, ratings);
    }
}