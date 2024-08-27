package com.project.Absence_gestion.Service;

import com.project.Absence_gestion.Model.Apprenant;
import com.project.Absence_gestion.dto.ApprenantDTO;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ApprenantsService {

    ApprenantDTO createApprenant(ApprenantDTO apprenantDTO);

    ApprenantDTO getApprenantById(Long id);

    List<ApprenantDTO> getAllApprenants();

    ApprenantDTO updateApprenant(Long id, ApprenantDTO apprenantDTO);

    void deleteApprenant(Long id);

    List<Apprenant> findAllByClasseId(Long classId);
}
