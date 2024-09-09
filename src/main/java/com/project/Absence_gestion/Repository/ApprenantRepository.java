package com.project.Absence_gestion.Repository;

import com.project.Absence_gestion.Model.Apprenant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface ApprenantRepository extends JpaRepository<Apprenant, Long> {

    // Using JPQL instead of a native query
    @Query("SELECT a FROM Apprenant a WHERE a.classe.id = :classId")
    List<Apprenant> findByClasseId(@Param("classId") Long classId);

    // findById method already inherited from JpaRepository, no need to redefine it
    Optional<Apprenant> findById(Long id);

    // Uncomment this if you want to query by a specific field related to Apprenant ID
    // Optional<Apprenant> findByApprenantId(Long apprenantId);
}
