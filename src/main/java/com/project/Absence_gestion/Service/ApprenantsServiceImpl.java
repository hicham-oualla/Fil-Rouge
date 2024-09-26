package com.project.Absence_gestion.Service;

import com.project.Absence_gestion.Model.Classe;
import com.project.Absence_gestion.Model.enums.Role;
import com.project.Absence_gestion.Repository.ClasseRepository;
import com.project.Absence_gestion.dto.ApprenantDTO;
import com.project.Absence_gestion.Model.Apprenant;
import com.project.Absence_gestion.Repository.ApprenantRepository;
import com.project.Absence_gestion.mapper.ApprenantMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ApprenantsServiceImpl implements ApprenantsService {

    private final ApprenantRepository apprenantRepository;
    private final ApprenantMapper apprenantMapper;
    @Autowired
    private ClasseRepository classeRepository;

    @Autowired
    public ApprenantsServiceImpl(ApprenantRepository apprenantRepository, ApprenantMapper apprenantMapper) {
        this.apprenantRepository = apprenantRepository;
        this.apprenantMapper = apprenantMapper;
    }


@Override
public ApprenantDTO createApprenant(ApprenantDTO apprenantDTO) {
    Apprenant apprenant = apprenantMapper.toEntity(apprenantDTO);


    Classe classe = classeRepository.findById(apprenantDTO.getClasseId()).orElse(null);


    apprenant.setClasse(classe);
    apprenant.setRole(Role.apprenant);
    Apprenant savedApprenant = apprenantRepository.save(apprenant);
    return apprenantMapper.toDto(savedApprenant);
}



    @Override
    public ApprenantDTO getApprenantById(Long id) {
        Apprenant apprenant = apprenantRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Apprenant not found with id: " + id));
        return apprenantMapper.toDto(apprenant);
    }

    @Override
    public List<ApprenantDTO> getAllApprenants() {
        return apprenantRepository.findAll()
                .stream()
                .map(apprenantMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public ApprenantDTO updateApprenant(Long id, ApprenantDTO apprenantDTO) {
        Apprenant existingApprenant = apprenantRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Apprenant not found with id: " + id));
        Apprenant apprenant = apprenantMapper.toEntity(apprenantDTO);
        apprenant.setId(existingApprenant.getId());
        apprenant.setClasse(new Classe(apprenantDTO.getClasseId())); // Update the classe field
        Apprenant updatedApprenant = apprenantRepository.save(apprenant);
        return apprenantMapper.toDto(updatedApprenant);
    }

    @Override
    public void deleteApprenant(Long id) {
        if (!apprenantRepository.existsById(id)) {
            throw new RuntimeException("Apprenant not found with id: " + id);
        }
        apprenantRepository.deleteById(id);
    }

    @Override
    public List<ApprenantDTO> findAllByClasseId(Long classId) {
        return apprenantRepository.findByClasseId(classId)
                .stream()
                .map(apprenantMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<ApprenantDTO> findById(Long id) {
        return apprenantRepository.findById(id)
                .map(apprenantMapper::toDto);
    }}


