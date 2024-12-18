package org.codeforall.orange.converters;

import org.codeforall.orange.command.UserDto;
import org.codeforall.orange.model.User;
import org.springframework.stereotype.Component;

/**
 * DONE
 */

@Component
public class UserToUserDto {

    public UserDto convert(User user) {
        UserDto userDto = new UserDto();

        userDto.setId(user.getId());
        userDto.setName(user.getName());
        userDto.setPhone(user.getPhone());
        userDto.setMail(user.getMail());
        userDto.setDonations(user.getDonations());

        return userDto;
    }
}
