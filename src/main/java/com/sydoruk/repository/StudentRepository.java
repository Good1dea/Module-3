package com.sydoruk.repository;

import com.sydoruk.config.HibernateUtil;
import com.sydoruk.model.Student;

import javax.persistence.EntityManager;
import java.util.List;

public class StudentRepository implements Repository<Student>{

    private static StudentRepository instance;

    public static StudentRepository getInstance() {
        if (instance == null) {
            instance = new StudentRepository();
        }
        return instance;
    }

    @Override
    public void save(final Student student) {
        final EntityManager entityManager = HibernateUtil.getEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(student);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public List getStudentWithAvgPoints(final double averagePoints){
        final EntityManager entityManager = HibernateUtil.getEntityManager();

        String hql = "SELECT s.id, s.firstName, s.lastName, AVG(r.points) as avg_point " +
                "FROM Student s JOIN s.ratings r GROUP BY s.id HAVING AVG(r.points) > : averagePoints " +
                "ORDER BY avg_point ASC";

        return  entityManager
                .createQuery(hql)
                .setParameter("averagePoints", averagePoints )
                .getResultList();
    }

}
