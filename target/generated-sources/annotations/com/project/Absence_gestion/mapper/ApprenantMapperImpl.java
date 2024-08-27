package com.project.Absence_gestion.mapper;

import com.project.Absence_gestion.Model.Apprenant;
import com.project.Absence_gestion.Model.Classe;
import com.project.Absence_gestion.dto.ApprenantDTO;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-08-27T00:35:30+0100",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.2 (Eclipse Adoptium)"
)
@Component
public class ApprenantMapperImpl implements ApprenantMapper {

    @Override
    public ApprenantDTO toDTO(Apprenant apprenant) {
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

        return apprenant;
    }

    @Override
    public List<ApprenantDTO> toDTO(List<Apprenant> apprenant) {
        if ( apprenant == null ) {
            return null;
        }

        List<ApprenantDTO> list = new ArrayList<ApprenantDTO>( apprenant.size() );
        for ( Apprenant apprenant1 : apprenant ) {
            list.add( toDTO( apprenant1 ) );
        }

        return list;
    }

    @Override
    public List<Apprenant> toEntity(List<ApprenantDTO> apprenantDTO) {
        if ( apprenantDTO == null ) {
            return null;
        }

        List<Apprenant> list = new ArrayList<Apprenant>( apprenantDTO.size() );
        for ( ApprenantDTO apprenantDTO1 : apprenantDTO ) {
            list.add( toEntity( apprenantDTO1 ) );
        }

        return list;
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
