package com.drugs.drugsrepository.mapper;

import com.drugs.drugsrepository.dto.DrugsSideEffectsDTO;
import com.drugs.drugsrepository.entity.DrugsBank;
import org.modelmapper.ModelMapper;

import java.util.ArrayList;
import java.util.List;

public class DrugsSideEffectsMapper implements EntityMapper<DrugsSideEffectsDTO, DrugsBank> {

    ModelMapper mapper=new ModelMapper();
    @Override
    public DrugsSideEffectsDTO convertToDto(DrugsBank entity) {
        return mapper.map(entity,DrugsSideEffectsDTO.class);
    }

    @Override
    public DrugsBank convertToEntity(DrugsSideEffectsDTO dto) {
        return mapper.map(dto,DrugsBank.class);
    }

    @Override
    public List<DrugsBank> convertToEntity(List<DrugsSideEffectsDTO> dtoList) {
        List<DrugsBank>drugsBanks=new ArrayList<>();
        dtoList.forEach(drugsSideEffectsDTO -> {
            drugsBanks.add(mapper.map(drugsSideEffectsDTO,DrugsBank.class));
        });
        return drugsBanks;
    }

    @Override
    public List<DrugsSideEffectsDTO> convertToDto(List<DrugsBank> entityList) {
        List<DrugsSideEffectsDTO>dtoList=new ArrayList<>();
        entityList.forEach(drugsBank -> {
            dtoList.add(mapper.map(drugsBank,DrugsSideEffectsDTO.class));
        });
        return dtoList;
    }
}
