package com.project.Absence_gestion.Repository;

import com.project.Absence_gestion.Model.Justification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface JustificationRepository extends JpaRepository<Justification, Long> {
    Optional<Justification> findByAbsenceId(Long absenceId);
}
