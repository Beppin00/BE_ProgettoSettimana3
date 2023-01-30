package it.epicode.utils;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JpaUtil {
	private static final EntityManagerFactory entityManagerFactory;

    static {
        try {
            entityManagerFactory = Persistence
                    .createEntityManagerFactory("WEEK3-PROJ");
        } catch (Throwable ex) {
            System.err.println("Initial EntityManagerFactory creation failed."
                    + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static EntityManagerFactory getEntityManagerFactory() {
        return entityManagerFactory;
    }

    public static final EntityManager em = entityManagerFactory.createEntityManager();
    public static final EntityTransaction t = em.getTransaction();
}
