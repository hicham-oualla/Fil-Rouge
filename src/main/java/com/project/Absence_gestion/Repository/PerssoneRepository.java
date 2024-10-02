package com.project.Absence_gestion.Repository;

import com.project.Absence_gestion.Model.Personne;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PerssoneRepository extends JpaRepository<Personne, Long> {
//    Optional<Personne> findByUsername(String nom);
      Optional<Personne> findByEmail(String email);
}
