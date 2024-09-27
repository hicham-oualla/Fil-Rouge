package com.project.Absence_gestion.mapper;

import com.project.Absence_gestion.Model.Classe;
import com.project.Absence_gestion.dto.Classedto;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-09-26T17:34:33+0100",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.2 (Eclipse Adoptium)"
)
@Component
public class ClassMapperImpl implements ClassMapper {

    @Override
    public Classe toEntity(Classedto classedto) {
        if ( classedto == null ) {
            return null;
        }

        Classe classe = new Classe();

        classe.setNom( classedto.getNom() );

        return classe;
    }

    @Override
    public Classedto toDto(Classe classe) {
        if ( classe == null ) {
            return null;
        }

        Classedto classedto = new Classedto();

        classedto.setNom( classe.getNom() );

        return classedto;
    }

    @Override
    public Classe partialUpdate(Classedto classedto, Classe classe) {
        if ( classedto == null ) {
            return classe;
        }

        if ( classedto.getNom() != null ) {
            classe.setNom( classedto.getNom() );
        }

        return classe;
    }
}
