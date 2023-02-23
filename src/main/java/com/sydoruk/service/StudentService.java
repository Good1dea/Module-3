package com.sydoruk.service;

import com.sydoruk.model.Rating;
import com.sydoruk.model.Student;
import com.sydoruk.model.StudentBuilder;
import com.sydoruk.model.StudentGroup;
import com.sydoruk.repository.StudentRepository;

import java.sql.Timestamp;
import java.util.List;

public class StudentService {

    private final StudentRepository repository;
    private static StudentService instance;

    private StudentService() {
        this.repository = StudentRepository.getInstance();
    }

    public static StudentService getInstance() {
        if (instance == null) {
            instance = new StudentService();
        }
        return instance;
    }

    public void findStudentsWithAvgHigher(final double average) {
        List<Object[]> listResult = repository.getStudentWithAvgPoints(average);
        System.out.println(" >> Result : ");
        if (!listResult.isEmpty()) {
            for (Object[] obj : listResult) {
                System.out.println("\tStudent : " + obj[0].toString() + " " + obj[1].toString() + " " +
                        obj[2].toString() +"\n\t\tAverage points : " + (Double) obj[3]);
            }
        } else {
            System.out.println("\tSorry, there are no students with an average score higher than " + average);
        }
    }

    public Student createStudent(final StudentGroup group, List<Rating> ratings) {
        return new StudentBuilder()
                .withFirstName("Logen")
                .withLastName("Ninefingers")
                .withEnrollmentDate(new Timestamp(System.currentTimeMillis()))
                .withAge(36)
                .withStudentGroup(group)
                .withRatings(ratings)
                .build();
    }
}