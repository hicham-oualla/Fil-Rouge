package com.project.Absence_gestion.mapper;

import com.project.Absence_gestion.Model.Absence;
import com.project.Absence_gestion.Model.Apprenant;
import com.project.Absence_gestion.dto.AbsenceDTO;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-09-26T17:34:33+0100",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.2 (Eclipse Adoptium)"
)
@Component
public class AbsenceMapperImpl implements AbsenceMapper {

    @Override
    public AbsenceDTO toDTO(Absence absence) {
        if ( absence == null ) {
            return null;
        }

        AbsenceDTO absenceDTO = new AbsenceDTO();

        absenceDTO.setApprenantId( absenceApprenantId( absence ) );
        absenceDTO.setId( absence.getId() );
        absenceDTO.setDatedebut( absence.getDatedebut() );
        absenceDTO.setDatedefin( absence.getDatedefin() );
        absenceDTO.setDuration( absence.getDuration() );
        absenceDTO.setEtat_absence( absence.getEtat_absence() );

        return absenceDTO;
    }

    @Override
    public Absence toEntity(AbsenceDTO absenceDTO) {
        if ( absenceDTO == null ) {
            return null;
        }

        Absence absence = new Absence();

        absence.setApprenant( absenceDTOToApprenant( absenceDTO ) );
        absence.setId( absenceDTO.getId() );
        absence.setDatedebut( absenceDTO.getDatedebut() );
        absence.setDatedefin( absenceDTO.getDatedefin() );
        absence.setDuration( absenceDTO.getDuration() );
        absence.setEtat_absence( absenceDTO.getEtat_absence() );

        return absence;
    }

    private Long absenceApprenantId(Absence absence) {
        if ( absence == null ) {
            return null;
        }
        Apprenant apprenant = absence.getApprenant();
        if ( apprenant == null ) {
            return null;
        }
        Long id = apprenant.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }

    protected Apprenant absenceDTOToApprenant(AbsenceDTO absenceDTO) {
        if ( absenceDTO == null ) {
            return null;
        }

        Apprenant apprenant = new Apprenant();

        apprenant.setId( absenceDTO.getApprenantId() );

        return apprenant;
    }
}
