package com.project.Absence_gestion.Repository;

import com.project.Absence_gestion.Model.Apprenant;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ApprenantRepository extends JpaRepository<Apprenant, Long> {
    List<Apprenant>GetAllApprenantByClasseId(Long classId);
}
