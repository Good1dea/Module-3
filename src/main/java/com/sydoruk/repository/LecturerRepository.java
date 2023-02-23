package com.sydoruk.repository;

import com.sydoruk.config.HibernateUtil;
import com.sydoruk.model.Lecturer;

import javax.persistence.EntityManager;
import java.util.List;

public class LecturerRepository implements Repository<Lecturer> {

    private static LecturerRepository instance;

    public static LecturerRepository getInstance() {
        if (instance == null) {
            instance = new LecturerRepository();
        }
        return instance;
    }

    @Override
    public void save(final Lecturer lecturer) {
        final EntityManager entityManager = HibernateUtil.getEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(lecturer);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public List getLecturerByName(String template){
        final EntityManager entityManager = HibernateUtil.getEntityManager();
        String hql = "FROM Lecturer WHERE LOWER(firstName) LIKE : template OR LOWER(lastName) LIKE : template";
        return entityManager.createQuery(hql)
                .setParameter("template",  template)
                .getResultList();
    }

}
