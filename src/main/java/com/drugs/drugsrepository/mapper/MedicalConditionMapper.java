package com.drugs.drugsrepository.mapper;

import com.drugs.drugsrepository.dto.MedicalConditionDTO;
import com.drugs.drugsrepository.entity.DrugsBank;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;

import java.util.ArrayList;
import java.util.List;

public class MedicalConditionMapper implements EntityMapper<MedicalConditionDTO,DrugsBank>{
    ModelMapper mapper=new ModelMapper();
    @Override
    public MedicalConditionDTO convertToDto(DrugsBank entity) {
        return null;
    }

    @Override
    public DrugsBank convertToEntity(MedicalConditionDTO dto) {
        return null;
    }

    @Override
    public List<DrugsBank> convertToEntity(List<MedicalConditionDTO> dtoList) {
        return null;
    }

    @Override
    public List<MedicalConditionDTO> convertToDto(List<DrugsBank> entityList) {
        List<MedicalConditionDTO>dtoList=new ArrayList<>();
        mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
        entityList.forEach(drugsBank -> {
            dtoList.add(mapper.map(drugsBank,MedicalConditionDTO.class));
        });
        return dtoList;
    }
}
