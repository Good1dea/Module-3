package com.sydoruk.config;

import org.flywaydb.core.Flyway;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class HibernateUtil {

    private static EntityManager entityManager;

    private HibernateUtil() {
    }

    public static EntityManager getEntityManager() {

        if (entityManager == null) {
            EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("persistence");
            entityManager = entityManagerFactory.createEntityManager();
        }
        return entityManager;
    }

    public static void migrationDB(){
        Flyway flyway = Flyway.configure()
                .dataSource("jdbc:postgresql://localhost:5432/module3", "postgres", "root")
                .baselineOnMigrate(true)
                .locations("db/migration")
                .load();
        flyway.migrate();
    }
}