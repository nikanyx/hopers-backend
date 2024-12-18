package org.codeforall.orange.converters;

import org.codeforall.orange.model.Giftee;
import org.codeforall.orange.services.InstitutionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.codeforall.orange.command.InstitutionDto;
import org.codeforall.orange.model.Institution;
import org.springframework.stereotype.Component;

/**
 * DONE
 */
@Component
public class InstitutionDtoToInstitution implements Converter<InstitutionDto, Institution> {

    private InstitutionService institutionService;

    @Autowired
    public void setInstitutionService(InstitutionService institutionService) {
        this.institutionService = institutionService;
    }

    @Override
    public Institution convert(InstitutionDto institutionDto) {

        Institution institution = null;

        try{
            institution = (institutionDto.getId() != 0 ? institutionService.get(institutionDto.getId()) : new Institution());
            institution.setName(institutionDto.getName());
            institution.setMail(institutionDto.getMail());
            institution.setSchedule(institutionDto.getSchedule());
            institution.setAddress(institutionDto.getAdrress());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return institution;
    }
}
