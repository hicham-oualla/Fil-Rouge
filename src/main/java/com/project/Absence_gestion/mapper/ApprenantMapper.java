package com.project.Absence_gestion.mapper;

import com.project.Absence_gestion.dto.ApprenantDTO;
import com.project.Absence_gestion.Model.Apprenant;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ApprenantMapper {

    ApprenantMapper INSTANCE = Mappers.getMapper(ApprenantMapper.class);

    @Mappings({
            @Mapping(source = "classe.id", target = "classe"),
            @Mapping(target = "absences", ignore = true),
            @Mapping(target = "retards", ignore = true),

    })
    ApprenantDTO toDto(Apprenant apprenant);

    @Mappings({
            @Mapping(source = "classe", target = "classe.id"),
            @Mapping(target = "absences", ignore = true),
            @Mapping(target = "retards", ignore = true),

    })
    Apprenant toEntity(ApprenantDTO apprenantDTO);

//    ApprenantDTO toDto(Apprenant apprenant);
//    Apprenant toEntity(ApprenantDTO apprenantDTO);
}
