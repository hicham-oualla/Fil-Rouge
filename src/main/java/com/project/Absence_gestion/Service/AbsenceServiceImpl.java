package com.project.Absence_gestion.Service;
import com.project.Absence_gestion.Model.enums.Etat_absence;
import com.project.Absence_gestion.Model.enums.Etat_retard;
import com.project.Absence_gestion.Repository.ApprenantRepository;
import com.project.Absence_gestion.dto.AbsenceDTO;
import com.project.Absence_gestion.mapper.AbsenceMapper;
import com.project.Absence_gestion.Model.Absence;
import com.project.Absence_gestion.Model.Apprenant;
import com.project.Absence_gestion.Repository.AbesenceRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AbsenceServiceImpl implements AbsenceService {
    @Autowired
    private AbesenceRepository absenceRepository;

    @Autowired
    private ApprenantRepository apprenantRepository;

    @Override
    public ResponseEntity<Absence> saveAbsence(AbsenceDTO absenceDTO) {
        Optional<Apprenant> apprenantOptional = apprenantRepository.findById(absenceDTO.getApprenantId());
        if (apprenantOptional.isPresent()) {
            Absence absence = new Absence();
            absence.setDatedebut(absenceDTO.getDatedebut());
            absence.setDatedefin(absenceDTO.getDatedefin());
            absence.setDuration(absenceDTO.getDuration());
            absence.setEtat_absence(Etat_absence.NONJUSITIFIER);
            absence.setApprenant(apprenantOptional.get());
            Absence savedAbsence = absenceRepository.save(absence);
            return ResponseEntity.ok(savedAbsence);
        } else {
            return ResponseEntity.badRequest().build();
        }
    }

    @Override
    public List<Absence> getAllAbsences() {
        return absenceRepository.findAll();
    }

    @Override
    public Optional<Absence> getAbsenceById(Long id) {
        return absenceRepository.findById(id);
    }

    @Override
    public Absence updateAbsence(Long id, AbsenceDTO absenceDTO) {
        Optional<Absence> absenceOptional = absenceRepository.findById(id);
        Optional<Apprenant> apprenantOptional = apprenantRepository.findById(absenceDTO.getApprenantId());
        if (absenceOptional.isPresent() && apprenantOptional.isPresent()) {
            Absence absence = absenceOptional.get();
            absence.setDatedebut(absenceDTO.getDatedebut());
            absence.setDatedefin(absenceDTO.getDatedefin());
            absence.setDuration(absenceDTO.getDuration());
            absence.setEtat_absence(absenceDTO.getEtat_absence());
            absence.setApprenant(apprenantOptional.get());
            return absenceRepository.save(absence);
        }
        return null;
    }

    @Override
    public void deleteAbsence(Long id) {
        absenceRepository.deleteById(id);
    }

    @Override
    public long countAbsencesByApprenant(Long apprenantId) {
        return absenceRepository.findByApprenantId(apprenantId).size();
    }

    @Override
    public Optional<List<Absence>> findByApprenant(Long apprenantId) {
        return Optional.ofNullable(absenceRepository.findByApprenantId(apprenantId));
    }


}
