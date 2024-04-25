package com.drugs.drugsrepository.mapper;

import com.drugs.drugsrepository.dto.DrugsDataDTO;
import com.drugs.drugsrepository.entity.DrugsBank;
import org.modelmapper.ModelMapper;

import java.util.ArrayList;
import java.util.List;

public class DrugsDataMapper implements EntityMapper<DrugsDataDTO, DrugsBank> {
    ModelMapper mapper=new ModelMapper();
    @Override
    public DrugsDataDTO convertToDto(DrugsBank entity) {
        return mapper.map(entity,DrugsDataDTO.class);
    }

    @Override
    public DrugsBank convertToEntity(DrugsDataDTO dto) {
        return mapper.map(dto,DrugsBank.class);
    }

    @Override
    public List<DrugsBank> convertToEntity(List<DrugsDataDTO> dtoList) {
        return null;
    }

    @Override
    public List<DrugsDataDTO> convertToDto(List<DrugsBank> entityList) {
        List<DrugsDataDTO>dtoList=new ArrayList<>();
        entityList.forEach(drugsBank -> {
            dtoList.add(mapper.map(drugsBank,DrugsDataDTO.class));
        });
        return dtoList;
    }
}
