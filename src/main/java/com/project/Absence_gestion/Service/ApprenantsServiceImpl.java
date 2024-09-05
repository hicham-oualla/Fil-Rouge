package com.project.Absence_gestion.Service;

import com.project.Absence_gestion.Model.Apprenant;
import com.project.Absence_gestion.Repository.ApprenantRepository;
import com.project.Absence_gestion.Service.ApprenantsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ApprenantsServiceImpl implements ApprenantsService {


    private ApprenantRepository apprenantRepository;

    @Autowired
    public ApprenantsServiceImpl(ApprenantRepository apprenantRepository) {
        this.apprenantRepository = apprenantRepository;
    }

    @Override
    public Apprenant createApprenant(Apprenant apprenant) {
        return apprenantRepository.save(apprenant);
    }

    @Override
    public Apprenant getApprenantById(Long id) {
        return apprenantRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Apprenant not found with id: " + id));
    }

    @Override
    public List<Apprenant> getAllApprenants() {
        return apprenantRepository.findAll();
    }

    @Override
    public Apprenant updateApprenant(Long id, Apprenant apprenant) {
        Apprenant existingApprenant = getApprenantById(id);
        existingApprenant.setNom(apprenant.getNom());
        existingApprenant.setEmail(apprenant.getEmail());
        existingApprenant.setPassword(apprenant.getPassword());
        existingApprenant.setRole(apprenant.getRole());
        existingApprenant.setClasse(apprenant.getClasse());
        existingApprenant.setAbsences(apprenant.getAbsences());
        existingApprenant.setRetards(apprenant.getRetards());
        existingApprenant.setJustifications(apprenant.getJustifications());
        return apprenantRepository.save(existingApprenant);
    }

    @Override
    public void deleteApprenant(Long id) {
        apprenantRepository.deleteById(id);
    }


    @Override
    public Optional<Apprenant> findById(Long id) {
        return apprenantRepository.findById(id);
    }


@Override
public List<Apprenant> findAllByClasseId(Long classId) {
    return apprenantRepository.findByClasseId(classId);
}
}