package org.codeforall.orange.controllers.rest;

import org.codeforall.orange.command.GifteeDto;
import org.codeforall.orange.command.UserDto;
import org.codeforall.orange.converters.GifteeToGifteeDto;
import org.codeforall.orange.converters.UserDtoToUser;
import org.codeforall.orange.converters.UserToUserDto;
import org.codeforall.orange.model.User;
import org.codeforall.orange.services.GifteeService;
import org.codeforall.orange.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/user")
public class RestUserController {

    private UserService userService;
    private UserToUserDto userToUserDto;
    private UserDtoToUser userDtoToUser;
    private GifteeToGifteeDto gifteeToGifteeDto;
    private GifteeService gifteeService;
    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @Autowired
    public void setUserToUserDto(UserToUserDto userToUserDto) {
        this.userToUserDto = userToUserDto;
    }

    @Autowired
    public void setUserDtoToUser(UserDtoToUser userDtoToUser) {
        this.userDtoToUser = userDtoToUser;
    }

    @Autowired
    public void setGifteeToGifteeDto(GifteeToGifteeDto gifteeToGifteeDto) {
        this.gifteeToGifteeDto = gifteeToGifteeDto;
    }

    @Autowired
    public void setGifteeService(GifteeService gifteeService) {
        this.gifteeService = gifteeService;
    }

    @RequestMapping(method = RequestMethod.GET, path = {"/{id}"}, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserDto> getUserById(@PathVariable Integer id) {
        UserDto userDto = userToUserDto.convert(userService.get(id));
        return new ResponseEntity<>(userDto, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST, path = {"/", ""})
    public ResponseEntity<UserDto> addUser(@RequestBody UserDto userDto) {
        User savedUser = userService.save(userDtoToUser.convert(userDto));
        return new ResponseEntity<>(userToUserDto.convert(savedUser),HttpStatus.CREATED);
    }

    @RequestMapping(method = RequestMethod.GET, path = {"/", ""}, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<UserDto>> listUsers() {

        List<UserDto> users = userService.list().stream()
                .map(user -> userToUserDto.convert(user))
                .collect(Collectors.toList());

        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, path = "/{id}/giftees", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<GifteeDto>> listGifteesByUserId(@PathVariable Integer id) {

        List<GifteeDto> giftees = userService.get(id).getGiftees().stream()
                .filter(giftee -> giftee.getStatus() != true)
                .map(giftee -> gifteeToGifteeDto.convert(giftee))
                .collect(Collectors.toList());

        /*List<GifteeDto> giftees = gifteeService.list().stream()
                .filter(giftee -> giftee.getUsers().getId() == id)
                .map(giftee -> gifteeToGifteeDto.convert(giftee))
                .collect(Collectors.toList());*/

        return new ResponseEntity<>(giftees, HttpStatus.OK);
    }
}
