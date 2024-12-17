package org.codeforall.orange.controllers;

import org.codeforall.orange.command.GifteeDTO;
import org.codeforall.orange.model.Giftees;
import org.codeforall.orange.services.GifteeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/giftee")
public class RestGifteeController {
    private GifteeService gifteeService;

    @Autowired
    public void setGifteeService(GifteeService gifteeService){
        this.gifteeService = gifteeService;
    }

    @RequestMapping(method = RequestMethod.GET, path = {"/", ""})
    public ResponseEntity<List<GifteeDTO>> listGiftees() {

        List<GifteeDTO> giftees = gifteeService.list().stream()
                .map(giftee -> convert(giftee))
                .collect(Collectors.toList());

        return new ResponseEntity<>(giftees, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, path = {"/{id}"})
    public ResponseEntity<Giftees> getGiftee(@PathVariable Integer id) {
        return new ResponseEntity<>(gifteeService.get(id), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST, path = {"/{id}"})
    public ResponseEntity<Giftees> addGiftee(@RequestBody Giftees giftee) {

        gifteeService.save(giftee);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    private GifteeDTO convert(Giftees giftee) {
        GifteeDTO gifteeDto = new GifteeDTO();
        gifteeDto.setId(giftee.getId());
        gifteeDto.setName(giftee.getName());
        gifteeDto.setAge(giftee.getAge());
        gifteeDto.setDescription(giftee.getDescription());
        gifteeDto.setInstitution(giftee.getInstitution());
        return gifteeDto;
    }
}
