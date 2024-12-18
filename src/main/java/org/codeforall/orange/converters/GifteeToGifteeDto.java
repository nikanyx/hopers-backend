package org.codeforall.orange.converters;

import org.codeforall.orange.command.GifteeDto;
import org.codeforall.orange.model.Giftee;
import org.springframework.stereotype.Component;

/**
 * DONE
 */
@Component
public class GifteeToGifteeDto extends AbstractConverter<Giftee, GifteeDto>{

    public GifteeDto convert(Giftee giftee) {

        GifteeDto gifteeDto = new GifteeDto();

        gifteeDto.setId(giftee.getId());
        gifteeDto.setName(giftee.getName());
        gifteeDto.setAge(giftee.getAge());
        gifteeDto.setDescription(giftee.getDescription());
        gifteeDto.setInstitutionId(giftee.getInstitution().getId());

        return gifteeDto;
    }
}
