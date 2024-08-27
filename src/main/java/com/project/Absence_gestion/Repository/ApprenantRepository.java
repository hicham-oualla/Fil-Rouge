package com.project.Absence_gestion.Repository;

import com.project.Absence_gestion.Model.Apprenant;
import com.project.Absence_gestion.dto.ApprenantDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ApprenantRepository extends JpaRepository<Apprenant, Long> {
    @Query(value = "SELECT * FROM personne WHERE classe_id =?1;", nativeQuery = true)
    List<Apprenant> findByClasseId(Long classId);
}
