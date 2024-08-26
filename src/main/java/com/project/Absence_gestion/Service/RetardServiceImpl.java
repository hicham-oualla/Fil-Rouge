package com.project.Absence_gestion.Service;

import com.project.Absence_gestion.Model.Apprenant;
import com.project.Absence_gestion.Model.Retard;
import com.project.Absence_gestion.Repository.RetardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RetardServiceImpl implements  RetardService{

    @Autowired
    private RetardRepository retardRepository;

    @Override
    public Retard saveRetard(Retard retard) {
        return retardRepository.save(retard);
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
        Optional<Retard> existingRetardOpt = retardRepository.findById(id);
        if (existingRetardOpt.isPresent()) {
            Retard existingRetard = existingRetardOpt.get();
            existingRetard.setDate(retard.getDate());
            existingRetard.setDurationDeRetard(retard.getDurationDeRetard());
            existingRetard.setApprenant(retard.getApprenant());
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
}

