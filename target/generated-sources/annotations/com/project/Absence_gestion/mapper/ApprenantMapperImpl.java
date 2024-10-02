package com.project.Absence_gestion.mapper;

import com.project.Absence_gestion.Model.Apprenant;
import com.project.Absence_gestion.Model.Classe;
import com.project.Absence_gestion.dto.ApprenantDTO;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-10-02T11:35:35+0100",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.2 (Eclipse Adoptium)"
)
@Component
public class ApprenantMapperImpl implements ApprenantMapper {

    @Override
    public ApprenantDTO toDto(Apprenant apprenant) {
        if ( apprenant == null ) {
            return null;
        }

        ApprenantDTO apprenantDTO = new ApprenantDTO();

        apprenantDTO.setClasseId( apprenantClasseId( apprenant ) );
        apprenantDTO.setId( apprenant.getId() );
        apprenantDTO.setNom( apprenant.getNom() );
        apprenantDTO.setEmail( apprenant.getEmail() );
        apprenantDTO.setPassword( apprenant.getPassword() );
        apprenantDTO.setRole( apprenant.getRole() );
        apprenantDTO.setAddress( apprenant.getAddress() );
        apprenantDTO.setPhone( apprenant.getPhone() );
        apprenantDTO.setIdNational( apprenant.getIdNational() );

        return apprenantDTO;
    }

    @Override
    public Apprenant toEntity(ApprenantDTO apprenantDTO) {
        if ( apprenantDTO == null ) {
            return null;
        }

        Apprenant apprenant = new Apprenant();

        apprenant.setClasse( apprenantDTOToClasse( apprenantDTO ) );
        apprenant.setId( apprenantDTO.getId() );
        apprenant.setNom( apprenantDTO.getNom() );
        apprenant.setEmail( apprenantDTO.getEmail() );
        apprenant.setPassword( apprenantDTO.getPassword() );
        apprenant.setRole( apprenantDTO.getRole() );
        apprenant.setAddress( apprenantDTO.getAddress() );
        apprenant.setPhone( apprenantDTO.getPhone() );
        apprenant.setIdNational( apprenantDTO.getIdNational() );

        return apprenant;
    }

    private Long apprenantClasseId(Apprenant apprenant) {
        if ( apprenant == null ) {
            return null;
        }
        Classe classe = apprenant.getClasse();
        if ( classe == null ) {
            return null;
        }
        Long id = classe.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }

    protected Classe apprenantDTOToClasse(ApprenantDTO apprenantDTO) {
        if ( apprenantDTO == null ) {
            return null;
        }

        Classe classe = new Classe();

        classe.setId( apprenantDTO.getClasseId() );

        return classe;
    }
}
