package org.codeforall.orange.persistence;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.codeforall.orange.model.Giftee;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class GifteeDao {

    @PersistenceContext
    protected EntityManager em;

    public void setEm(EntityManager em) {
        this.em = em;
    }

    public EntityManager getEm() {
        return em;
    }

    public List<Giftee> findAll() {
        CriteriaQuery<Giftee> criteriaQuery = em.getCriteriaBuilder().createQuery(Giftee.class);
        Root<Giftee> root = criteriaQuery.from(Giftee.class);
        return em.createQuery(criteriaQuery).getResultList();
    }

    public Giftee findById(Integer id) {
        return em.find(Giftee.class, id);
    }

    public Giftee saveOrUpdate(Giftee modelObject) {
        return em.merge(modelObject);
    }


    /*
    public void delete(Integer id) {
        em.remove(em.find(Giftee.class, id));
    }
    */
}
