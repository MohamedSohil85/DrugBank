package com.drugs.drugsrepository.service;

import com.drugs.drugsrepository.dto.DrugsBankDTO;
import com.drugs.drugsrepository.dto.DrugsDataDTO;
import com.drugs.drugsrepository.dto.DrugsSideEffectsDTO;
import com.drugs.drugsrepository.dto.MedicalConditionDTO;
import com.drugs.drugsrepository.entity.DrugsBank;
import com.drugs.drugsrepository.exception.ResourceNotFoundException;
import com.drugs.drugsrepository.mapper.DrugsDataMapper;
import com.drugs.drugsrepository.mapper.DrugsMapper;
import com.drugs.drugsrepository.mapper.DrugsSideEffectsMapper;
import com.drugs.drugsrepository.mapper.MedicalConditionMapper;
import com.drugs.drugsrepository.persistence.DrugsBankRepository;
import com.opencsv.bean.CsvToBeanBuilder;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@Service
public class DrugService {

    private final DrugsBankRepository drugsBankRepository;
    private final DrugsMapper drugsMapper=new DrugsMapper();
    private final DrugsSideEffectsMapper sideEffectsMapper=new DrugsSideEffectsMapper();
    private final DrugsDataMapper drugsDataMapper=new DrugsDataMapper();
    private final MedicalConditionMapper medicalConditionMapper=new MedicalConditionMapper();
    public DrugService(DrugsBankRepository drugsBankRepository) {
        this.drugsBankRepository = drugsBankRepository;
    }

    public List<DrugsBankDTO>readCSVFile() throws FileNotFoundException {
        List<DrugsBankDTO>dtoList=new CsvToBeanBuilder(new FileReader("C:\\Users\\momi_\\IdeaProjects\\demo2\\DrugsRepository\\src\\main\\resources\\drugs_side_effects_drugs_com.csv"))
                .withType(DrugsBankDTO.class).build().parse();
        List<DrugsBank>drugsBanks=drugsMapper.convertToEntity(dtoList);
        drugsBankRepository.saveAll(drugsBanks);
        return dtoList;
    }

  public List<DrugsSideEffectsDTO>fetchDrugsByMedicalCondition(String name) throws ResourceNotFoundException {
        List<DrugsBank>drugsBanks=drugsBankRepository.findAll().stream().filter(drugsBank -> drugsBank.getMedical_condition().equalsIgnoreCase(name)).collect(Collectors.toList());

        return sideEffectsMapper.convertToDto(drugsBanks);
  }
public List<DrugsDataDTO>findDrugsName(String drugsName) throws ResourceNotFoundException {
        List<DrugsBank>drugsBanks= drugsBankRepository
                .findAll()
                .stream().filter(drugsBank -> drugsBank.getDrug_name().equalsIgnoreCase(drugsName)).toList();
        if (drugsBanks.isEmpty()){
            throw new ResourceNotFoundException("Drug with Name:"+drugsName+" not found!");
        }
        return drugsDataMapper.convertToDto(drugsBanks);
}

public Map<String, Object> findAllDrugs(int pageNo, int pageSize) throws ResourceNotFoundException {
    Pageable paging = PageRequest.of(pageNo, pageSize);
    Page<DrugsBank>drugsBankPage=drugsBankRepository.findAll(paging);

        List<String>drugs= drugsBankPage.getContent().stream().map(DrugsBank::getDrug_name).toList();
      long totalElements=  drugsBankPage.getTotalElements();
        drugsBankPage.getNumber();
        if (drugs.isEmpty()){
            throw new ResourceNotFoundException("List is Empty");
        }
    Map<String,Object>objectMap=new HashMap<>();
        objectMap.put("Drugs :",drugs);
        objectMap.put("total Elements :",totalElements);
        objectMap.put("current Page: ",drugsBankPage.getNumber());
        objectMap.put("total pages :",drugsBankPage.getTotalPages());
        objectMap.put("elements pro Page :",drugsBankPage.getSize());
return objectMap;
   /* Pageable paging = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));

    Page<EmployeeEntity> pagedResult = repository.findAll(paging);

    if(pagedResult.hasContent()) {
        return pagedResult.getContent();
    } else {
        return new ArrayList<EmployeeEntity>();
    }*/
}

public List<DrugsDataDTO>findAllDrugsStartWith(String keyword) throws ResourceNotFoundException {


        List<DrugsBank>drugsBanks=drugsBankRepository.findAll(Sort.by("drug_name")).stream().filter(drugsBank -> drugsBank.getDrug_name().startsWith(keyword)).collect(Collectors.toList());

        if (drugsBanks.isEmpty()){
            throw new ResourceNotFoundException("List is Empty!");

        }
        return drugsDataMapper.convertToDto(drugsBanks);
}
public String saveNewDrug(DrugsBankDTO dto) {

 List<DrugsBank>drugsBanks=drugsBankRepository.findAll();
 for (DrugsBank drugsBank:drugsBanks){
     if (drugsBank.getDrug_name().equalsIgnoreCase(dto.getDrug_name())){
         return "Drug with Name :"+drugsBank.getDrug_name()+ " already stored !";
     }
 }
DrugsBank drugsBank=drugsMapper.convertToEntity(dto);
drugsBankRepository.save(drugsBank);
return "stored in Database";

}


}
