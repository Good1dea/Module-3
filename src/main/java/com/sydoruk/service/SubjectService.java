package com.sydoruk.service;

import com.sydoruk.repository.SubjectRepository;

import java.util.List;

public class SubjectService {

    private final SubjectRepository repository;
    private static SubjectService instance;

    private SubjectService() {
        this.repository = SubjectRepository.getInstance();
    }

    public static SubjectService getInstance() {
        if (instance == null) {
            instance = new SubjectService();
        }
        return instance;
    }

    public void findWorstAndBestAvgPoints() {
        List <Object[]> results = repository.getAvgPoints();
        System.out.println(" >> Result : ");
        Object[] max = results.get(0);
        String nameSubject = (String) max[0];
        Double avgPoints = (Double) max[1];
        System.out.println("\t Subject " + nameSubject + " has MAX average points " + avgPoints);

        Object[] min = results.get(results.size() - 1);
        nameSubject = (String) min[0];
        avgPoints = (Double) min[1];
        System.out.println("\t Subject " + nameSubject + " has MIN average points " + avgPoints);
    }

}

