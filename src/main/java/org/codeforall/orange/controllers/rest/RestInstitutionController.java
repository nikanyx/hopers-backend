package org.codeforall.orange.controllers.rest;

import org.codeforall.orange.command.GifteeDto;
import org.codeforall.orange.command.InstitutionDto;
import org.codeforall.orange.converters.GifteeToGifteeDto;
import org.codeforall.orange.converters.InstitutionDtoToInstitution;
import org.codeforall.orange.converters.InstitutionToInstitutionDto;
import org.codeforall.orange.model.Giftee;
import org.codeforall.orange.model.Institution;
import org.codeforall.orange.services.GifteeService;
import org.codeforall.orange.services.InstitutionService;
import org.codeforall.orange.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.awt.*;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/institution")
public class RestInstitutionController {

    private InstitutionService institutionService;
    private InstitutionToInstitutionDto institutionToInstitutionDto;
    private InstitutionDtoToInstitution institutionDtoToInstitution;
    private GifteeToGifteeDto gifteeToGifteeDto;
    private GifteeService gifteeService;

    @Autowired
    public void setInstitutionService(InstitutionService institutionService) {
        this.institutionService = institutionService;
    }

    @Autowired
    public void setInstitutionToInstitutionDto(InstitutionToInstitutionDto institutionToInstitutionDto) {
        this.institutionToInstitutionDto = institutionToInstitutionDto;
    }

    @Autowired
    public void setInstitutionDtoToInstitution(InstitutionDtoToInstitution institutionDtoToInstitution) {
        this.institutionDtoToInstitution = institutionDtoToInstitution;
    }

    @Autowired
    public void setGifteeToGifteeDto(GifteeToGifteeDto gifteeToGifteeDto) {
        this.gifteeToGifteeDto = gifteeToGifteeDto;
    }

    @Autowired
    public void setGifteeService(GifteeService gifteeService) {
        this.gifteeService = gifteeService;
    }

    @RequestMapping(method = RequestMethod.GET, path = {"/", ""}, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<InstitutionDto>> listInstitutions() {

        List<InstitutionDto> institutions = institutionService.list().stream()
                .map(institution -> institutionToInstitutionDto.convert(institution))
                .collect(Collectors.toList());

        return new ResponseEntity<>(institutions, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, path = {"/{id}"}, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<InstitutionDto> getInstitution(@PathVariable Integer id) {
        InstitutionDto institutionDto = institutionToInstitutionDto.convert(institutionService.get(id));
        return new ResponseEntity<>(institutionDto, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST, path = {"/"}, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity addInstitution(@RequestBody InstitutionDto institutionDto) {
        Institution institution = institutionDtoToInstitution.convert(institutionDto);
        institutionService.save(institution);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    /**
     * List Institutions Available to receive donations :P pls donate whatever u want
     */
    @RequestMapping(method = RequestMethod.GET, path = {"/institutions-available"}, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<InstitutionDto>> listAvailableInstitutionsWithSchedule() {
        List<InstitutionDto> availableInstitutions = institutionService.list().stream()
                .filter(Institution::isAvailable)
                .map(institutionToInstitutionDto::convert)
                .collect(Collectors.toList());
        return new ResponseEntity<>(availableInstitutions, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, path = "/{id}/giftees-non-completed", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<GifteeDto>> listGifteesByUserId(@PathVariable Integer id) {

        List<GifteeDto> giftees = institutionService.get(id).getGiftees().stream()
                .filter(giftee -> giftee.getStatus() != true)
                .map(giftee -> gifteeToGifteeDto.convert(giftee))
                .collect(Collectors.toList());

        return new ResponseEntity<>(giftees, HttpStatus.OK);
    }

    /**
     *mark giftee as available -> Status = null
     */
    @RequestMapping(method = RequestMethod.PUT, path = "/{id}/mark-as-available", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<GifteeDto> markGifteeAsAvailable(@PathVariable Integer id) {
        Giftee giftee = gifteeService.get(id);
        giftee.setUsers(null);
        updateGifteeStatus(giftee, null);

        return new ResponseEntity<>( HttpStatus.OK);
    }

    /**
     *mark giftee as completed -> Status = true
     */
    @RequestMapping(method = RequestMethod.PUT, path = "/{id}/mark-as-completed", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<GifteeDto> markGifteeAsCompleted(@PathVariable Integer id) {
        Giftee giftee = gifteeService.get(id);
        updateGifteeStatus(giftee, true);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    
    private void updateGifteeStatus(Giftee giftee, Boolean status) {
        giftee.setStatus(status);
        gifteeService.save(giftee);
    }
}
