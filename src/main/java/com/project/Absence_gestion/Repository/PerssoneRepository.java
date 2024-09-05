package com.project.Absence_gestion.Repository;

import com.project.Absence_gestion.Model.Personne;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PerssoneRepository extends JpaRepository<Personne, Long> {
}
