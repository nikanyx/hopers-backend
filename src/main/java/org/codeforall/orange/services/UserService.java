package org.codeforall.orange.services;

import org.codeforall.orange.model.User;
import org.codeforall.orange.persistence.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private UserDao userDao;

    @Autowired
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public User get(Integer id) {
        return userDao.findById(id);
    }


    public User save(User user) {
        userDao.getEm().getTransaction().begin();
        User savedUser = userDao.saveOrUpdate(user);
        userDao.getEm().getTransaction().commit();
        return savedUser;
    }

    public List<User> list() {
        return userDao.findAll();
    }
}
