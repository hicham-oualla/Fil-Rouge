package com.project.Absence_gestion.Repository;

import com.project.Absence_gestion.Model.Classe;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ClasseRepository extends JpaRepository<Classe, Long> { @Override
    long count();
}
