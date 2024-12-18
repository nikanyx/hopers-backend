package org.codeforall.orange.converters;

import org.codeforall.orange.command.UserDto;
import org.codeforall.orange.model.Giftee;
import org.codeforall.orange.model.User;

public class UserDtoToUser implements Converter<UserDto, User> {

    private UserService userService;

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @Override
    public User convert(UserDto userDto) {
        User user = null;

        try{
            user = (userDto.getId() != 0 ? userService.get(userDto.getId()) : new User());
            user.setName(userDto.getName());
            user.setPhone(userDto.getPhone());
            user.setMail(userDto.getMail());
            user.setDonations(userDto.getDonations());

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return user;
    }
}
