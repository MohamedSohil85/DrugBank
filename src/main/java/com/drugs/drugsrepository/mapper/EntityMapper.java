package com.drugs.drugsrepository.mapper;

import java.util.List;

public interface EntityMapper <D,E>{

    public D convertToDto(E entity);
    public E convertToEntity(D dto);
    public List<E> convertToEntity(List<D>dtoList);
    public List<D>convertToDto(List<E> entityList);
}
