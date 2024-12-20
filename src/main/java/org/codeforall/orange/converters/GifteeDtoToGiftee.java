package org.codeforall.orange.converters;

import org.codeforall.orange.command.GifteeDto;
import org.codeforall.orange.model.Giftee;
import org.codeforall.orange.services.GifteeService;
import org.codeforall.orange.services.InstitutionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

/**
 * DONE
 */
@Component
public class GifteeDtoToGiftee implements Converter<GifteeDto, Giftee> {


    private GifteeService gifteeService;
    private InstitutionService institutionService;

    @Autowired
    public void setGifteeService(GifteeService gifteeService) {
        this.gifteeService = gifteeService;
    }

    @Autowired
    public void setInstitutionService(InstitutionService institutionService) {
        this.institutionService = institutionService;
    }

    @Override
    public Giftee convert(GifteeDto gifteeDto) {

        Giftee giftee = null;

        try{
            giftee = (gifteeDto.getId() != 0 ? gifteeService.get(gifteeDto.getId()) : new Giftee());
            giftee.setName(gifteeDto.getName());
            giftee.setAge(gifteeDto.getAge());
            giftee.setDescription(gifteeDto.getDescription());
            giftee.setInstitution(institutionService.get(gifteeDto.getInstitutionId()));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return giftee;
    }
}
