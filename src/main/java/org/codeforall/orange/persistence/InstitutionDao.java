package org.codeforall.orange.persistence;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.codeforall.orange.model.Institution;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class InstitutionDao {

    @PersistenceContext
    protected EntityManager em;

    public void setEm(EntityManager em) {
        this.em = em;
    }

    public EntityManager getEm() {
        return em;
    }

    public List<Institution> findAll() {
        CriteriaQuery<Institution> criteriaQuery = em.getCriteriaBuilder().createQuery(Institution.class);
        Root<Institution> root = criteriaQuery.from(Institution.class);
        return em.createQuery(criteriaQuery).getResultList();
    }

    public Institution findById(Integer id) {
        return em.find(Institution.class, id);
    }

    public Institution saveOrUpdate(Institution modelObject) {
        return em.merge(modelObject);
    }

    /*
    public void delete(Integer id) {
        em.remove(em.find(Institution.class, id));
    }
    */
}

