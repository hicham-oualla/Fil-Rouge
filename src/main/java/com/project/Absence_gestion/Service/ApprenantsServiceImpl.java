package com.project.Absence_gestion.Service;

import com.project.Absence_gestion.Model.Apprenant;
import com.project.Absence_gestion.Repository.ApprenantRepository;
import com.project.Absence_gestion.Repository.ClasseRepository;
import com.project.Absence_gestion.dto.ApprenantDTO;
import com.project.Absence_gestion.mapper.ApprenantMapper;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
@Service
public class ApprenantsServiceImpl implements  ApprenantsService{

    @Autowired
    private ApprenantRepository apprenantRepository;

    @Autowired
    private ClasseRepository classeRepository;

    @Autowired
    private ApprenantMapper apprenantMapper;

    @Override
    public ApprenantDTO createApprenant(ApprenantDTO apprenantDTO) {
        Apprenant apprenant = apprenantMapper.toEntity(apprenantDTO);
        return apprenantMapper.toDTO(apprenantRepository.save(apprenant));
    }

    @Override
    public ApprenantDTO getApprenantById(Long id) {
        Apprenant apprenant = apprenantRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Apprenant not found"));
        return apprenantMapper.toDTO(apprenant);
    }

    @Override
    public List<ApprenantDTO> getAllApprenants() {
        return apprenantRepository.findAll().stream()
                .map(apprenantMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public ApprenantDTO updateApprenant(Long id, ApprenantDTO apprenantDTO) {
        Apprenant existingApprenant = apprenantRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Apprenant not found"));
        Apprenant updatedApprenant = apprenantMapper.toEntity(apprenantDTO);
        updatedApprenant.setId(existingApprenant.getId());  // Preserve the ID
        return apprenantMapper.toDTO(apprenantRepository.save(updatedApprenant));
    }

    @Override
    public void deleteApprenant(Long id) {
        apprenantRepository.deleteById(id);
    }

    @Override
    public List<Apprenant> findAllByClasseId(Long classId) {
     return apprenantRepository.findByClasseId(classId);
    }



}

