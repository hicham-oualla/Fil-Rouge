package com.project.Absence_gestion.Service;

import com.project.Absence_gestion.dto.ApprenantDTO;
import java.util.List;
import java.util.Optional;

public interface ApprenantsService {


    ApprenantDTO createApprenant(ApprenantDTO apprenantDTO);

    ApprenantDTO getApprenantById(Long id);

    List<ApprenantDTO> getAllApprenants();

    ApprenantDTO updateApprenant(Long id, ApprenantDTO apprenantDTO);

    void deleteApprenant(Long id);

    List<ApprenantDTO> findAllByClasseId(Long classId);

    Optional<ApprenantDTO> findById(Long id);
}

