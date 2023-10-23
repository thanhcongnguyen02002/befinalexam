package com.example.befinalexam.controller;

import com.example.befinalexam.model.Type;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring", uses = {ProductMapper.class})
public interface TypeMapper {
    TypeResp toTypeResp (Type type);
    Type toType(TypeReq typeReq);
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void update(TypeUpdateReq req, @MappingTarget Type type);
}
