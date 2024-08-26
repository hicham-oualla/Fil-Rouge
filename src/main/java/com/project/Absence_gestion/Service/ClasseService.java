package com.project.Absence_gestion.Service;

import com.project.Absence_gestion.Model.Apprenant;
import com.project.Absence_gestion.Model.Classe;

import java.util.List;

public interface ClasseService {
    Classe saveClasse(Classe classe);
    List<Classe> getAllClasses();
    Classe getClasseById(Long id);
    Classe updateClasse(Long id, Classe classe);
    void deleteClasse(Long id);
    List<Apprenant> getApprenantsByClasse(Long classeId);
}
