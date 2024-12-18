package org.codeforall.orange.converters;

import org.codeforall.orange.command.InstitutionDto;
import org.codeforall.orange.model.Institution;

/**
 * DONE
 */
public class InstitutionToInstitutionDto extends AbstractConverter<Institution, InstitutionDto> {

    public InstitutionDto convert(Institution institution) {

        InstitutionDto institutionDto = new InstitutionDto();

        institutionDto.setId(institution.getId());
        institutionDto.setName(institution.getName());
        institutionDto.setMail(institution.getMail());
        institutionDto.setSchedule(institution.getSchedule());
        institutionDto.setAdrress(institution.getAddress());

        return institutionDto;
    }
}