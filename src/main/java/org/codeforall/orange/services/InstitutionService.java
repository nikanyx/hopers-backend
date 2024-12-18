package org.codeforall.orange.services;

import jakarta.transaction.Transactional;
import org.codeforall.orange.model.Institution;
import org.codeforall.orange.persistence.InstitutionDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InstitutionService {

    private InstitutionDao institutionDao;

    @Autowired
    public void setInstitutionDao(InstitutionDao institutionDao) {
        this.institutionDao = institutionDao;
    }

    public Institution get(Integer id) {
        return institutionDao.findById(id);
    }

}
