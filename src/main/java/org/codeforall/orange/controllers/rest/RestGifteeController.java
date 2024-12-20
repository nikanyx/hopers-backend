package org.codeforall.orange.controllers.rest;

import org.codeforall.orange.command.GifteeDto;
import org.codeforall.orange.converters.GifteeDtoToGiftee;
import org.codeforall.orange.converters.GifteeToGifteeDto;
import org.codeforall.orange.model.Giftee;
import org.codeforall.orange.model.User;
import org.codeforall.orange.services.GifteeService;
import org.codeforall.orange.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/giftee")
public class RestGifteeController {
    private GifteeService gifteeService;
    private GifteeToGifteeDto gifteeToGifteeDto;
    private GifteeDtoToGiftee gifteeDtoToGiftee;
    private UserService userService;

    @Autowired
    public void setGifteeService(GifteeService gifteeService){
        this.gifteeService = gifteeService;
    }

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @Autowired
    public void setGifteeToGifteeDto(GifteeToGifteeDto gifteeToGifteeDto) {
        this.gifteeToGifteeDto = gifteeToGifteeDto;
    }

    @Autowired
    public void setGifteeDtoToGiftee(GifteeDtoToGiftee gifteeDtoToGiftee) {
        this.gifteeDtoToGiftee = gifteeDtoToGiftee;
    }

    @RequestMapping(method = RequestMethod.GET, path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<GifteeDto> getGifteeById(@PathVariable Integer id) {
        return new ResponseEntity<>(gifteeToGifteeDto.convert(gifteeService.get(id)), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST, path = {"/", ""}, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<GifteeDto> addGiftee(@RequestBody GifteeDto gifteeDto) {
        Giftee savedGiftee = gifteeService.save(gifteeDtoToGiftee.convert(gifteeDto));
        return new ResponseEntity<>(gifteeToGifteeDto.convert(savedGiftee), HttpStatus.CREATED);
    }

    @RequestMapping(method = RequestMethod.PUT, path = "/{gid}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<GifteeDto> claimGiftee(@PathVariable Integer gid, @RequestParam(name = "user") Integer uid){
        Giftee giftee = gifteeService.get(gid);
        giftee.setUsers(userService.get(uid));
        giftee.setStatus(false);
        Giftee savedGiftee = gifteeService.save(giftee);
        User user = userService.get(uid);
        user.getGiftees().add(giftee);
        userService.save(user);
        return new ResponseEntity<>(gifteeToGifteeDto.convert(savedGiftee), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, path = "/available", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<GifteeDto>> listAvailableGiftees() {
        List<GifteeDto> giftees = gifteeService.list().stream()
                .filter(giftee -> giftee.getStatus() == null)
                .map(giftee -> gifteeToGifteeDto.convert(giftee))
                .collect(Collectors.toList());

        return new ResponseEntity<>(giftees, HttpStatus.OK);
    }
}
