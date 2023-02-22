package com.sydoruk.repository;

import com.sydoruk.config.HibernateUtil;
import com.sydoruk.model.Rating;

import javax.persistence.EntityManager;

public class RatingRepository implements Repository<Rating> {

    private static RatingRepository instance;

    public static RatingRepository getInstance() {
        if (instance == null) {
            instance = new RatingRepository();
        }
        return instance;
    }

    @Override
    public void save(final Rating rating) {
        final EntityManager entityManager = HibernateUtil.getEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(rating);
        entityManager.getTransaction().commit();
        entityManager.close();
    }
}
