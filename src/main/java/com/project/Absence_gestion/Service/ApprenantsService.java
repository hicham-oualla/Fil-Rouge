package com.project.Absence_gestion.Service;

import com.project.Absence_gestion.Model.Apprenant;
import java.util.List;
import java.util.Optional;

public interface ApprenantsService {

    Apprenant createApprenant(Apprenant apprenant);

    Apprenant getApprenantById(Long id);

    List<Apprenant> getAllApprenants();

    Apprenant updateApprenant(Long id, Apprenant apprenant);

    void deleteApprenant(Long id);

    List<Apprenant> findAllByClasseId(Long classId);

    Optional<Apprenant> findById(Long id);
}
