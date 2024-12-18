package org.codeforall.orange.controllers.rest;

import org.codeforall.orange.command.UserDto;
import org.codeforall.orange.converters.UserDtoToUser;
import org.codeforall.orange.converters.UserToUserDto;
import org.codeforall.orange.model.User;
import org.codeforall.orange.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/user")
public class RestUserController {

    private UserService userService;
    private UserToUserDto userToUserDto;
    private UserDtoToUser userDtoToUser;

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

    @RequestMapping(method = RequestMethod.GET, path = {"/", ""}, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<UserDto>> listUsers() {

        List<UserDto> users = userService.list().stream()
                .map(user -> userToUserDto.convert(user))
                .collect(Collectors.toList());

        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, path = {"/{id}"}, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserDto> getUser(@PathVariable Integer id) {
        UserDto userDto = userToUserDto.convert(userService.get(id));
        return new ResponseEntity<>(userDto, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST, path = {"/"}, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity addUser(@RequestBody UserDto userDto) {
        User user = userDtoToUser.convert(userDto);
        userService.save(user);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
