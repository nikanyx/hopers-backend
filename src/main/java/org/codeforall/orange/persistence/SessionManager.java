package org.codeforall.orange.persistence;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.PersistenceUnit;
import org.springframework.stereotype.Component;

/**
 * A Session Manger implementation to use in a sesssion-per-request pattern with JPA
 */
@Component
public class SessionManager {

    private EntityManagerFactory emf;

    private EntityManager em;

    @PersistenceUnit
    public void setEmf(EntityManagerFactory emf) {
        this.emf = emf;
    }

    public void startSession() {

        if(em == null){
            em = emf.createEntityManager();
        }
    }

    public void stopSession() {
        if(em != null){
            em.close();
        }

        em = null;
    }

    public EntityManager getCurrentSession() {
        startSession();
        return em;
    }
}
