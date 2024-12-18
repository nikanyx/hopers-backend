package org.codeforall.orange.persistence;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.codeforall.orange.model.Institution;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class InstitutionDao {

    protected SessionManager sm;

    @Autowired
    public void setSm(SessionManager sm) {
        this.sm = sm;
    }

    public EntityManager getEm() {
        return sm.getCurrentSession();
    }

    public List<Institution> findAll() {
        EntityManager em = sm.getCurrentSession();
        CriteriaQuery<Institution> criteriaQuery = em.getCriteriaBuilder().createQuery(Institution.class);
        Root<Institution> root = criteriaQuery.from(Institution.class);
        return em.createQuery(criteriaQuery).getResultList();
    }

    public Institution findById(Integer id) {
        EntityManager em = sm.getCurrentSession();
        return em.find(Institution.class, id);
    }

    public Institution saveOrUpdate(Institution modelObject) {
        EntityManager em = sm.getCurrentSession();
        return em.merge(modelObject);
    }

    /*
    public void delete(Integer id) {
        em.remove(em.find(Institution.class, id));
    }
    */
}

