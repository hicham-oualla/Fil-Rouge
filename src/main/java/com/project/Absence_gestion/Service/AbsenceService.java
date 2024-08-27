package com.project.Absence_gestion.Service;

import com.project.Absence_gestion.Model.Absence;
import com.project.Absence_gestion.Model.Apprenant;

import java.util.List;

public interface AbsenceService {
    Absence addAbsence(Absence absence);
    Absence editAbsence(Long id, Absence absenceDetails);
    List<Absence> getAllAbsence();
    void deleteAbsence(Long id);
    long countRetardsByApprenant(Apprenant apprenant);
}


