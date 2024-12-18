package org.codeforall.orange.services;

import org.codeforall.orange.model.Giftee;
import org.codeforall.orange.persistence.GifteeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GifteeService {
    private GifteeDao gifteeDao;

    @Autowired
    private void setGifteeDao(GifteeDao gifteeDao) {
        this.gifteeDao = gifteeDao;
    }

    public Giftee get(Integer id) {
        return gifteeDao.findById(id);
    }


    public Giftee save(Giftee giftee) {
        gifteeDao.getEm().getTransaction().begin();
        Giftee savedGiftee = gifteeDao.saveOrUpdate(giftee);
        gifteeDao.getEm().getTransaction().commit();
        return savedGiftee;
    }

    public List<Giftee> list() {
        return gifteeDao.findAll();
    }
}
