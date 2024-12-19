package org.codeforall.orange.controllers.rest;

import org.codeforall.orange.command.InstitutionDto;
import org.codeforall.orange.converters.InstitutionDtoToInstitution;
import org.codeforall.orange.converters.InstitutionToInstitutionDto;
import org.codeforall.orange.model.Institution;
import org.codeforall.orange.services.InstitutionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/institution")
public class RestInstitutionController {
    private InstitutionService institutionService;
    private InstitutionToInstitutionDto institutionToInstitutionDto;
    private InstitutionDtoToInstitution institutionDtoToInstitution;

    @Autowired
    public void setInstitutionService(InstitutionService institutionService) {
        this.institutionService = institutionService;
    }

    @Autowired
    public void setInstitutiontoInstitutionDto(InstitutionToInstitutionDto institutionToInstitutionDto) {
        this.institutionToInstitutionDto = institutionToInstitutionDto;
    }

    @Autowired
    public void setInstitutionDtotoInstitution(InstitutionDtoToInstitution institutionDtoToInstitution) {
        this.institutionDtoToInstitution = institutionDtoToInstitution;
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
}
