//package com.project.Absence_gestion.mapper;
//
//import com.project.Absence_gestion.dto.ApprenantDTO;
//import com.project.Absence_gestion.Model.Apprenant;
//import org.mapstruct.Mapper;
//import org.mapstruct.Mapping;
//import org.mapstruct.ReportingPolicy;
//
//import java.util.List;
//
//@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
//public interface ApprenantMapper {
//
//    // Mapping for a single Apprenant to ApprenantDTO
//    @Mapping(source = "classe.id", target = "classeId")
//    ApprenantDTO toDTO(Apprenant apprenant);
//
//    // Mapping for a single ApprenantDTO to Apprenant
//    @Mapping(source = "classeId", target = "classe.id")
//    Apprenant toEntity(ApprenantDTO apprenantDTO);
//
//    // No @Mapping annotations needed for collections
//    List<ApprenantDTO> toDTO(List<Apprenant> apprenants);
//
//    List<Apprenant> toEntity(List<ApprenantDTO> apprenantDTOs);
//}
