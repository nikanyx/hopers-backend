package org.codeforall.orange.services;

import org.codeforall.orange.command.InstitutionDto;
import org.codeforall.orange.model.Institution;
import org.codeforall.orange.persistence.InstitutionDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

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
    
    public Institution save(Institution institution) {
        institutionDao.getEm().getTransaction().begin();
        Institution savedInstitution = institutionDao.saveOrUpdate(institution);
        institutionDao.getEm().getTransaction().commit();
        return savedInstitution;
    }

    public List<Institution> list() {
        return institutionDao.findAll();
    }
}
