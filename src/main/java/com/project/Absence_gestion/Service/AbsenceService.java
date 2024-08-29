package com.project.Absence_gestion.Service;

import com.project.Absence_gestion.Model.Absence;
import com.project.Absence_gestion.dto.AbsenceDTO;
import com.project.Absence_gestion.Model.Apprenant;

import java.util.List;

public interface AbsenceService {
    AbsenceDTO addAbsence(AbsenceDTO absenceDTO);
    AbsenceDTO editAbsence(Long id, AbsenceDTO absenceDetails);
    List<AbsenceDTO> getAllAbsence();
    void deleteAbsence(Long id);
    long countRetardsByApprenant(Apprenant apprenant);
    Absence newabsence(Absence absence);
}
