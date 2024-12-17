package org.codeforall.orange.persistence;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.codeforall.orange.model.Giftees;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class GifteeDao {

    @PersistenceContext
    protected EntityManager em;

    public void setEm(EntityManager em) {
        this.em = em;
    }

    public List<Giftees> findAll() {
        CriteriaQuery<Giftees> criteriaQuery = em.getCriteriaBuilder().createQuery(Giftees.class);
        Root<Giftees> root = criteriaQuery.from(Giftees.class);
        return em.createQuery(criteriaQuery).getResultList();
    }

    public Giftees findById(Integer id) {
        return em.find(Giftees.class, id);
    }

    public Giftees saveOrUpdate(Giftees modelObject) {
        return em.merge(modelObject);
    }

    /*
    public void delete(Integer id) {
        em.remove(em.find(modelType, id));
    }
    */
}
