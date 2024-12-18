package org.codeforall.orange.services;

import jakarta.transaction.Transactional;
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

    @Transactional
    public Giftee save(Giftee giftee) {
        return gifteeDao.saveOrUpdate(giftee);
    }

    public List<Giftee> list() {
        return gifteeDao.findAll();
    }
}
