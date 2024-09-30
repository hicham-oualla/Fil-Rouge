package com.project.Absence_gestion.Service;

import com.project.Absence_gestion.Model.Apprenant;
import com.project.Absence_gestion.Model.Retard;
import com.project.Absence_gestion.Model.enums.Etat_retard;
import com.project.Absence_gestion.Repository.ApprenantRepository;
import com.project.Absence_gestion.Repository.RetardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RetardServiceImpl implements RetardService {

    @Autowired
    private RetardRepository retardRepository;

    @Autowired
    private ApprenantRepository apprenantRepository;

    @Override
    public ResponseEntity<Retard> saveRetard(Retard retard, Long apprenantId) {
        Optional<Apprenant> apprenantOptional = apprenantRepository.findById(apprenantId);
        if (apprenantOptional.isPresent()) {
            Apprenant apprenant = apprenantOptional.get();
            retard.setEtat_retard(Etat_retard.NONJUSITIFIER);
            retard.setApprenant(apprenant);
            Retard savedRetard = retardRepository.save(retard);
            return ResponseEntity.ok(savedRetard);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @Override
    public List<Retard> getAllRetards() {
        return retardRepository.findAll();
    }

    @Override
    public Optional<Retard> getRetardById(Long id) {
        return retardRepository.findById(id);
    }

    @Override
    public Retard updateRetard(Long id, Retard retard) {
        Optional<Retard> existingRetardOptional = retardRepository.findById(id);
        if (existingRetardOptional.isPresent()) {
            Retard existingRetard = existingRetardOptional.get();
            // Update fields of existingRetard with new values from retard
            existingRetard.setDate(retard.getDate());
            existingRetard.setDurationDeRetard(retard.getDurationDeRetard());
            existingRetard.setEtat_retard(retard.getEtat_retard());
            return retardRepository.save(existingRetard);
        }
        return null;
    }

    @Override
    public void deleteRetard(Long id) {
        retardRepository.deleteById(id);
    }

    @Override
    public long countRetardsByApprenant(Apprenant apprenant) {
        return retardRepository.countByApprenant(apprenant);
    }

    @Override
    public Optional<List<Retard>> findByApprenant(Long apprenantId) {
        Optional<Apprenant> apprenantOptional = apprenantRepository.findById(apprenantId);
        if (apprenantOptional.isPresent()) {
            return Optional.of(retardRepository.findByApprenant(apprenantOptional.get()));
        } else {
            return Optional.empty();
        }
    }
    @Override
    public ResponseEntity<Retard> changeStatutRetard(Long retardId, Etat_retard etat_retard) {
        Optional<Retard> retardOptional = retardRepository.findById(retardId);
        if (retardOptional.isPresent()) {
            Retard retard = retardOptional.get();
            retard.setEtat_retard(etat_retard);  // Set new status
            retardRepository.save(retard);      // Save the updated retard
            return ResponseEntity.ok(retard);
        } else {
            return ResponseEntity.notFound().build();  // Return 404 if retard not found
        }
}}
