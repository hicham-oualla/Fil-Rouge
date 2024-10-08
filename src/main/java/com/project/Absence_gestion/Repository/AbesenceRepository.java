package com.project.Absence_gestion.Repository;

import com.project.Absence_gestion.Model.Absence;

import com.project.Absence_gestion.Model.Apprenant;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface AbesenceRepository extends JpaRepository<Absence, Long>  {
    long countByApprenant(Apprenant apprenant);
    List<Absence> findByApprenantId(Long apprenantId);
}
