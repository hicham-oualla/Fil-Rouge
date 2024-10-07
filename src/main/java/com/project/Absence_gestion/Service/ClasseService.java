package com.project.Absence_gestion.Service;

import com.project.Absence_gestion.Model.Apprenant;
import com.project.Absence_gestion.Model.Classe;
import com.project.Absence_gestion.dto.Classedto;

import java.util.List;

public interface ClasseService {
    Classedto saveClasse(Classedto classe);
    List<Classe> getAllClasses();
    Classe getClasseById(Long id);
    Classedto updateClasse(Long id, Classedto classe);
    void deleteClasse(Long id);
    Long getNumberOfClasses();
    long count();

}
