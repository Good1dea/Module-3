package com.sydoruk.service;

import com.sydoruk.model.StudentGroup;
import com.sydoruk.repository.GroupRepository;

import java.util.List;

public class GroupService {

    private final GroupRepository repository;
    private static GroupService instance;

    private GroupService() {
        this.repository = GroupRepository.getInstance();
    }

    public static GroupService getInstance() {
        if (instance == null) {
            instance = new GroupService();
        }
        return instance;
    }

    public void groupByName(final String template) {
        List<StudentGroup> listGroup = repository.getGroupByName(template.toLowerCase());
        System.out.println(" >> Result : ");
        if (!listGroup.isEmpty()) {
            for (StudentGroup group : listGroup) {
                System.out.println("\t" + group.getNameGroup());
            }
        } else {
            System.out.println("\tSorry, the group containing this sequence of characters ( " + template + " ) does not exist");
        }
    }

    public void numberOfStudentInEachGroup() {
        List<Object[]> listResult = repository.getStudentsCount();
        System.out.println(" >> Result : ");
        if (!listResult.isEmpty()) {
            for (Object[] result : listResult) {
                String group = (String) result[0];
                long count = (Long) result[1];
                System.out.println("\t Group " + group + " has " + count + " students.");
            }
        } else {
            System.out.println("There are no data");
        }
    }

    public void averagePointEachGroup() {
        List<Object[]> listResult = repository.getAveragePoints();
        System.out.println(" >> Result : ");
        if (!listResult.isEmpty()) {
            for (Object[] result : listResult) {
                String groupName = (String) result[0];
                Double avgPoint = (Double) result[1];
                System.out.println("\tGroup " + groupName + " has average points of " + avgPoint);
            }
        }
    }

}