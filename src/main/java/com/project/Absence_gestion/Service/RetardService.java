package com.project.Absence_gestion.Service;

import com.project.Absence_gestion.Model.Retard;

import java.util.List;
import java.util.Optional;

public interface RetardService {
    Retard saveRetard(Retard retard);
    List<Retard> getAllRetards();
    Optional<Retard> getRetardById(Long id);
    Retard updateRetard(Long id, Retard retard);
    void deleteRetard(Long id);
}
