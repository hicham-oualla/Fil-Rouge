package com.project.Absence_gestion.Repository;

import com.project.Absence_gestion.Model.Apprenant;
import com.project.Absence_gestion.dto.ApprenantDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface ApprenantRepository extends JpaRepository<Apprenant, Long> {

    @Query(value = "SELECT * FROM personne WHERE classe_id =?1;", nativeQuery = true)
    List<Apprenant> findByClasseId(Long classId);

Optional<Apprenant> findApprenantByid(Long id);
//    Optional<Apprenant> findByApprenantId(Long apprenantId);

    @Override
    Optional<Apprenant> findById(Long id);
}
