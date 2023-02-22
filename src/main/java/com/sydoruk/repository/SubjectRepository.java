package com.sydoruk.repository;

import com.sydoruk.config.HibernateUtil;
import com.sydoruk.model.Subject;

import javax.persistence.EntityManager;
import java.util.List;

public class SubjectRepository implements Repository<Subject> {

    private static SubjectRepository instance;

    public static SubjectRepository getInstance() {
        if (instance == null) {
            instance = new SubjectRepository();
        }
        return instance;
    }

    @Override
    public void save(final Subject subject) {
        final EntityManager entityManager = HibernateUtil.getEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(subject);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public List getAvgPoints(){
        final EntityManager entityManager = HibernateUtil.getEntityManager();
        String hql = "SELECT s.nameSubject, AVG(r.points) as pointAvg FROM Rating r JOIN r.subject s " +
                "GROUP BY s.nameSubject ORDER BY pointAvg DESC";
        return entityManager.createQuery(hql).getResultList();
    }
}

