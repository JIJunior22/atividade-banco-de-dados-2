package br.edu.fescfafic.primeira.atividade.bd2.entities;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class JpaUtil {
    public static final EntityManagerFactory emf = Persistence
            .createEntityManagerFactory("supersales");

    public static EntityManager entityManager() {
        return emf.createEntityManager();
    }
}

