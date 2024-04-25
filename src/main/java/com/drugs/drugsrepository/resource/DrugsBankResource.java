package com.drugs.drugsrepository.resource;

import com.drugs.drugsrepository.dto.DrugsBankDTO;
import com.drugs.drugsrepository.entity.DrugsBank;
import com.drugs.drugsrepository.exception.ResourceNotFoundException;
import com.drugs.drugsrepository.service.DrugService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.FileNotFoundException;
import java.util.List;

@RestController
public class DrugsBankResource {

    private final DrugService service;

    public DrugsBankResource(DrugService service) {
        this.service = service;
    }
    @RequestMapping(value = "/readFile",produces = MediaType.APPLICATION_JSON_VALUE,method = RequestMethod.POST)
    public ResponseEntity readCSVFile() throws FileNotFoundException {
        return new ResponseEntity<>(service.readCSVFile(), HttpStatus.CREATED);
    }
    @RequestMapping(value = "/condition",produces = MediaType.APPLICATION_JSON_VALUE,method = RequestMethod.GET)
    public ResponseEntity findByMedicalCondition(@RequestParam("medical_condition")String medical_condition) throws ResourceNotFoundException {
        return new ResponseEntity(service.fetchDrugsByMedicalCondition(medical_condition),HttpStatus.OK);
    }
    @RequestMapping(value = "/name",produces = MediaType.APPLICATION_JSON_VALUE,method = RequestMethod.GET)
    public ResponseEntity findByDrugsName(@RequestParam("drug_name")String name) throws ResourceNotFoundException {
        return new ResponseEntity(service.findDrugsName(name),HttpStatus.OK);
    }
    @RequestMapping(value = "/drugs",produces = MediaType.APPLICATION_JSON_VALUE,method = RequestMethod.GET)
    public ResponseEntity fetchAllDrugs(@RequestParam("pageNo")int pageNo,@RequestParam("pageSize")int pageSize) throws ResourceNotFoundException {
        return new ResponseEntity(service.findAllDrugs(pageNo, pageSize),HttpStatus.OK);
    }
    @PostMapping(value = "/drug",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity addNewDrug(@RequestBody DrugsBankDTO dto){
        return new ResponseEntity<>(service.saveNewDrug(dto),HttpStatus.CREATED);
    }

}
