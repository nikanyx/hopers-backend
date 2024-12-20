package org.codeforall.orange.persistence;

import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.codeforall.orange.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDao {

    protected SessionManager sm;

    @Autowired
    public void setSm(SessionManager sm) {
        this.sm = sm;
    }

    public EntityManager getEm() {
        return sm.getCurrentSession();
    }

    public List<User> findAll() {
        EntityManager em = sm.getCurrentSession();
        CriteriaQuery<User> criteriaQuery = em.getCriteriaBuilder().createQuery(User.class);
        Root<User> root = criteriaQuery.from(User.class);
        return em.createQuery(criteriaQuery).getResultList();
    }

    public User findById(Integer id) {
        EntityManager em = sm.getCurrentSession();
        return em.find(User.class, id);
    }

    /*
    public User findByEmail(String email) {
        EntityManager em = sm.getCurrentSession();
        User user = em.createQuery("SELECT * FROM TABLE users where mail = :value1")
                .setParameter("value1", email).getSingleResult();
        return user;
    }
     */

    public User saveOrUpdate(User modelObject) {
        EntityManager em = sm.getCurrentSession();
        return em.merge(modelObject);
    }

}
