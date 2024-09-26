package com.project.Absence_gestion.mapper;


import com.project.Absence_gestion.Model.Classe;
import com.project.Absence_gestion.dto.Classedto;
import org.mapstruct.*;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ClassMapper {

    Classe toEntity(Classedto classedto);
    Classedto toDto(Classe classe);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Classe partialUpdate(Classedto classedto, @MappingTarget Classe classe);


}
