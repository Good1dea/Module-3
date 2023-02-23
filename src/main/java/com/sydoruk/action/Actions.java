package com.sydoruk.action;

import com.sydoruk.service.GroupService;
import com.sydoruk.service.LecturerService;
import com.sydoruk.service.StudentService;
import com.sydoruk.service.SubjectService;

public class Actions {

    private static Actions instance;

    public static Actions getInstance() {
        if (instance == null) {
            instance = new Actions();
        }
        return instance;
    }

    public void findGroupByName() {
        GroupService.getInstance().groupByName(UserInput.getInstance().inputGroupName());
    }

    public void findStudentCountInGroups() {
        GroupService.getInstance().numberOfStudentInEachGroup();
    }

    public void findGroupAveragePoints() {
        GroupService.getInstance().averagePointEachGroup();
    }

    public void findLecturer() {
        LecturerService.getInstance().findLecturerByName(UserInput.getInstance().inputLecturerName());
    }

    public void findSubjectMinMax() {
        SubjectService.getInstance().findWorstAndBestAvgPoints();
    }

    public void findStudentWithAverage() {
        StudentService.getInstance().findStudentsWithAvgHigher(UserInput.getInstance().inputAvgPoints());
    }

}