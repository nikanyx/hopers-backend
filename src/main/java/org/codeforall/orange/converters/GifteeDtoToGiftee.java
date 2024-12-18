package org.codeforall.orange.converters;

import org.codeforall.orange.command.GifteeDto;
import org.codeforall.orange.model.Giftee;
import org.codeforall.orange.services.GifteeService;
import org.springframework.core.convert.converter.Converter;

/**
 * DONE
 */
public class GifteeDtoToGiftee implements Converter<GifteeDto, Giftee> {


    private GifteeService gifteeService;

    public void setGifteeService(GifteeService gifteeService) {
        this.gifteeService = gifteeService;
    }

    @Override
    public Giftee convert(GifteeDto gifteeDto) {

        Giftee giftee = null;

        try{
            giftee = (gifteeDto.getId() != 0 ? gifteeService.get(gifteeDto.getId()) : new Giftee());
            giftee.setName(gifteeDto.getName());
            giftee.setAge(gifteeDto.getAge());
            giftee.setDescription(gifteeDto.getDescription());
            giftee.setInstitution(gifteeDto.getInstitution());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return giftee;
    }
}
