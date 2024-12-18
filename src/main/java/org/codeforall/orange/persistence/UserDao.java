package org.codeforall.orange.persistence;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.codeforall.orange.model.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDao {

    @PersistenceContext
    protected EntityManager em;

    public void setEm(EntityManager em) {
        this.em = em;
    }

    public EntityManager getEm() {
        return em;
    }

    public List<User> findAll() {
        CriteriaQuery<User> criteriaQuery = em.getCriteriaBuilder().createQuery(User.class);
        Root<User> root = criteriaQuery.from(User.class);
        return em.createQuery(criteriaQuery).getResultList();
    }

    public User findById(Integer id) {
        return em.find(User.class, id);
    }

    public User saveOrUpdate(User modelObject) {
        return em.merge(modelObject);
    }

    /*
    public void delete(Integer id) {
        em.remove(em.find(User.class, id));
    }
    */
}
