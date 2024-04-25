package com.drugs.drugsrepository.mapper;

import com.drugs.drugsrepository.dto.DrugsBankDTO;
import com.drugs.drugsrepository.entity.DrugsBank;
import org.modelmapper.ModelMapper;

import java.util.ArrayList;
import java.util.List;

public class DrugsMapper implements EntityMapper<DrugsBankDTO, DrugsBank> {

    ModelMapper mapper=new ModelMapper();
    @Override
    public DrugsBankDTO convertToDto(DrugsBank entity) {

        return mapper.map(entity,DrugsBankDTO.class);
    }

    @Override
    public DrugsBank convertToEntity(DrugsBankDTO dto) {

        return mapper.map(dto,DrugsBank.class);
    }

    @Override
    public List<DrugsBank> convertToEntity(List<DrugsBankDTO> dtoList) {
        List<DrugsBank>drugsBankList=new ArrayList<>();
        dtoList.forEach(drugsBankDTO -> {
            drugsBankList.add(mapper.map(drugsBankDTO,DrugsBank.class));
        });


        return drugsBankList;
    }

    @Override
    public List<DrugsBankDTO> convertToDto(List<DrugsBank> entityList) {
        List<DrugsBankDTO>dtoList=new ArrayList<>();
        entityList.forEach(drugsBank -> {
            dtoList.add(mapper.map(drugsBank,DrugsBankDTO.class));
        });

        return dtoList;
    }
}
