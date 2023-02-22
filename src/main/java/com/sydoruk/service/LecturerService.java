package com.sydoruk.service;

import com.sydoruk.model.Lecturer;
import com.sydoruk.repository.LecturerRepository;

import java.util.List;

public class LecturerService {

    private final LecturerRepository repository;
    private static LecturerService instance;

    private LecturerService() {
        this.repository = LecturerRepository.getInstance();
    }

    public static LecturerService getInstance() {
        if (instance == null) {
            instance = new LecturerService();
        }
        return instance;
    }

    public void findLecturerByName(final String name) {
        List<Lecturer> listLecturer = repository.searchLecturer(name.toLowerCase());
        System.out.println(" >> Result : ");
        if (!listLecturer.isEmpty()) {
            for (Lecturer lecturer : listLecturer) {
                System.out.println("\tFirst name : " + lecturer.getFirstName() +
                        "\n\t\tLast name : " + lecturer.getLastName() +
                        "\n\t\tAge : " + lecturer.getAge() +
                        "\n\t\tSubject : " + lecturer.getSubject().getNameSubject());
            }
        } else {
            System.out.println("\tSorry, the lecturer containing this sequence of characters ( " + name + " ) does not exist");
        }
    }
}