package com.project.Absence_gestion.Service;

import com.project.Absence_gestion.Model.Absence;
import com.project.Absence_gestion.dto.AbsenceDTO;
import com.project.Absence_gestion.Model.Apprenant;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface AbsenceService {

        ResponseEntity<Absence> saveAbsence(AbsenceDTO absenceDTO);
        List<Absence> getAllAbsences();
        Optional<Absence> getAbsenceById(Long id);
        Absence updateAbsence(Long id, AbsenceDTO absenceDTO);
        void deleteAbsence(Long id);
        long countAbsencesByApprenant(Long apprenantId);
        Optional<List<Absence>> findByApprenant(Long apprenantId);
    }

