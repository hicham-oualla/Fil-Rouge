package com.project.Absence_gestion.mapper;

import com.project.Absence_gestion.dto.ApprenantDTO;
import com.project.Absence_gestion.Model.Apprenant;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ApprenantMapper {
    ApprenantMapper INSTANCE = Mappers.getMapper(ApprenantMapper.class);

    @Mapping(source = "classe.id", target = "classeId")
    ApprenantDTO toDTO(Apprenant apprenant);

    @Mapping(source = "classeId", target = "classe.id")
    Apprenant toEntity(ApprenantDTO apprenantDTO);

    @Mapping(source = "classe.id", target = "classeId")
   List<ApprenantDTO> toDTO(List<Apprenant> apprenant);

    @Mapping(source = "classeId", target = "classe.id")
   List<Apprenant> toEntity(List<ApprenantDTO> apprenantDTO);
}