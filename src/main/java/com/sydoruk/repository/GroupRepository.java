package com.sydoruk.repository;

import com.sydoruk.config.HibernateUtil;
import com.sydoruk.model.StudentGroup;
import javax.persistence.EntityManager;
import java.util.List;

public class GroupRepository implements Repository<StudentGroup> {

    private static GroupRepository instance;

    public static GroupRepository getInstance() {
        if (instance == null) {
            instance = new GroupRepository();
        }
        return instance;
    }
    @Override
    public void save(final StudentGroup group) {
        final EntityManager entityManager = HibernateUtil.getEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(group);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public List getGroupByName(final String input) {
        final EntityManager entityManager = HibernateUtil.getEntityManager();
        return entityManager.createQuery("FROM StudentGroup WHERE LOWER(namegroup) LIKE : input")
                .setParameter("input", "%" + input + "%")
                .getResultList();
    }

    public List getStudentsCount() {
        final EntityManager entityManager = HibernateUtil.getEntityManager();
        String hql = "SELECT g.nameGroup, COUNT(s.id) FROM Student s JOIN s.group g GROUP BY g.id";
        return entityManager.createQuery(hql).getResultList();
    }

    public List getAveragePoints(){
        final EntityManager entityManager = HibernateUtil.getEntityManager();
        String hql = "SELECT g.nameGroup, AVG(r.points) AS avg_point FROM Student s JOIN s.ratings r JOIN s.group g " +
                "GROUP BY g.nameGroup";
        return entityManager.createQuery(hql).getResultList();
    }

}
