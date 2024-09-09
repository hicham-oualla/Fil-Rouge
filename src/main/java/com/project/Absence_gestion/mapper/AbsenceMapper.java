package com.project.Absence_gestion.mapper;
import com.project.Absence_gestion.dto.AbsenceDTO;
import com.project.Absence_gestion.Model.Absence;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;


@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface AbsenceMapper {

    @Mapping(source = "apprenant.id", target = "apprenantId")
    AbsenceDTO toDTO(Absence absence);

    @Mapping(source = "apprenantId", target = "apprenant.id")
    Absence toEntity(AbsenceDTO absenceDTO);
}
