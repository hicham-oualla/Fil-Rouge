package com.project.Absence_gestion.Service;

import com.project.Absence_gestion.Model.Apprenant;
import com.project.Absence_gestion.Model.Retard;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface RetardService {
    ResponseEntity<Retard> saveRetard(Retard retard, Long apprenantId);
    List<Retard> getAllRetards();
    Optional<Retard> getRetardById(Long id);
    Retard updateRetard(Long id, Retard retard);
    void deleteRetard(Long id);
    long countRetardsByApprenant(Apprenant apprenant);
    Optional<List<Retard>> findByApprenant(Long apprenantId);
}
