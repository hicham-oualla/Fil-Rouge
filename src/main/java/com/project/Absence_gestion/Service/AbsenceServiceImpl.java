package com.project.Absence_gestion.Service;

import com.project.Absence_gestion.Model.Absence;
import com.project.Absence_gestion.Repository.AbesenceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AbsenceServiceImpl implements AbsenceService {

    private final AbesenceRepository absenceRepository;

    @Autowired
    public AbsenceServiceImpl(AbesenceRepository absenceRepository) {
        this.absenceRepository = absenceRepository;
    }

    @Override
    public Absence addAbsence(Absence absence) {
        return absenceRepository.save(absence);
    }

    @Override
    public Absence editAbsence(Long id, Absence absenceDetails) {
        Optional<Absence> optionalAbsence = absenceRepository.findById(id);

        if (optionalAbsence.isPresent()) {
            Absence existingAbsence = optionalAbsence.get();
            existingAbsence.setDatedebut(absenceDetails.getDatedebut());
            existingAbsence.setDatedefin(absenceDetails.getDatedefin());
            existingAbsence.setDuration(absenceDetails.getDuration());

            existingAbsence.setApprenant(absenceDetails.getApprenant());

            return absenceRepository.save(existingAbsence);
        } else {
            throw new RuntimeException("Absence not found with id: " + id);
        }
    }

    @Override
    public List<Absence> getAllAbsence() {
        return absenceRepository.findAll();
    }

    @Override
    public void deleteAbsence(Long id) {
        absenceRepository.deleteById(id);
    }
}
