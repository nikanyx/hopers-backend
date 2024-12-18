package org.codeforall.orange.controllers.rest;

import org.codeforall.orange.command.GifteeDto;
import org.codeforall.orange.converters.GifteeDtoToGiftee;
import org.codeforall.orange.converters.GifteeToGifteeDto;
import org.codeforall.orange.model.Giftee;
import org.codeforall.orange.services.GifteeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/giftee")
public class RestGifteeController {
    private GifteeService gifteeService;
    private GifteeToGifteeDto gifteeToGifteeDto;
    private GifteeDtoToGiftee gifteeDtoToGiftee;

    @Autowired
    public void setGifteeService(GifteeService gifteeService){
        this.gifteeService = gifteeService;
    }

    @RequestMapping(method = RequestMethod.GET, path = {"/", ""}, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<GifteeDto>> listGiftees() {

        List<GifteeDto> giftees = gifteeService.list().stream()
                .map(giftee -> gifteeToGifteeDto.convert(giftee))
                .collect(Collectors.toList());

        return new ResponseEntity<>(giftees, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, path = {"/{id}"}, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Giftee> getGiftee(@PathVariable Integer id) {
        return new ResponseEntity<>(gifteeService.get(id), HttpStatus.OK);
    }


    @RequestMapping(method = RequestMethod.POST, path = {"/"}, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Giftee> addGiftee(@RequestBody Giftee giftee) {
        Giftee savedGiftee = gifteeService.save(giftee);
        return new ResponseEntity<>(savedGiftee, HttpStatus.CREATED);
    }
    /*
    public ResponseEntity addGiftee(@RequestBody Giftee giftee) {

        gifteeService.save(giftee);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }*/

    @Autowired
    public void setGifteeToGifteeDto(GifteeToGifteeDto gifteeToGifteeDto) {
        this.gifteeToGifteeDto = gifteeToGifteeDto;
    }

    @Autowired
    public void setGifteeDtoToGiftee(GifteeDtoToGiftee gifteeDtoToGiftee) {
        this.gifteeDtoToGiftee = gifteeDtoToGiftee;
    }



}
