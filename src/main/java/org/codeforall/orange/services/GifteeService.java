package org.codeforall.orange.services;

import jakarta.transaction.Transactional;
import org.codeforall.orange.model.Giftees;
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

    public Giftees get(Integer id) {
        return gifteeDao.findById(id);
    }

    @Transactional
    public Giftees save(Giftees giftee) {
        return gifteeDao.saveOrUpdate(giftee);
    }

    public List<Giftees> list() {
        return gifteeDao.findAll();
    }
}
