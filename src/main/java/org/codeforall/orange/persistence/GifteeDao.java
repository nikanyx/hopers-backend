package org.codeforall.orange.persistence;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.codeforall.orange.model.Giftee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class GifteeDao {

    protected SessionManager sm;

    @Autowired
    public void setSm(SessionManager sm) {
        this.sm = sm;
    }

    public EntityManager getEm() {
        return sm.getCurrentSession();
    }

    public List<Giftee> findAll() {
        EntityManager em = sm.getCurrentSession();
        CriteriaQuery<Giftee> criteriaQuery = em.getCriteriaBuilder().createQuery(Giftee.class);
        Root<Giftee> root = criteriaQuery.from(Giftee.class);
        return em.createQuery(criteriaQuery).getResultList();
    }

    public Giftee findById(Integer id) {
        EntityManager em = sm.getCurrentSession();
        return em.find(Giftee.class, id);
    }

    public Giftee saveOrUpdate(Giftee modelObject) {
        EntityManager em = sm.getCurrentSession();
        return em.merge(modelObject);
    }


    /*
    public void delete(Integer id) {
        em.remove(em.find(Giftee.class, id));
    }
    */
}
