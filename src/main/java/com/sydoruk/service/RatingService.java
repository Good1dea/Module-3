package com.sydoruk.service;

import com.sydoruk.repository.RatingRepository;

public class RatingService {

    private final RatingRepository repository;
    private static RatingService instance;

    private RatingService() {
        this.repository = RatingRepository.getInstance();
    }

    public static RatingService getInstance() {
        if (instance == null) {
            instance = new RatingService();
        }
        return instance;
    }
}