package com.project.Absence_gestion.Service;

import com.project.Absence_gestion.Model.enums.Etat_absence;
import com.project.Absence_gestion.dto.AbsenceDTO;
import com.project.Absence_gestion.dto.ApprenantDTO;
import com.project.Absence_gestion.mapper.AbsenceMapper;
import com.project.Absence_gestion.Model.Absence;
import com.project.Absence_gestion.Model.Apprenant;
import com.project.Absence_gestion.Repository.AbesenceRepository;
import com.project.Absence_gestion.mapper.ApprenantMapper;
import com.project.Absence_gestion.mapper.ApprenantMapperImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AbsenceServiceImpl implements AbsenceService {

    private final AbesenceRepository absenceRepository;
    private final AbsenceMapper absenceMapper;
    @Autowired
    private ApprenantsService apprenantsService;

    @Autowired
    private ApprenantMapper apprenantMapper;

    @Autowired
    public AbsenceServiceImpl(AbesenceRepository absenceRepository, AbsenceMapper absenceMapper) {
        this.absenceRepository = absenceRepository;
        this.absenceMapper = absenceMapper;
    }
    @Override
    public AbsenceDTO addAbsence(AbsenceDTO absenceDTO) {
        Absence absence = absenceMapper.toEntity(absenceDTO);
        Absence savedAbsence = absenceRepository.save(absence);
        return absenceMapper.toDTO(savedAbsence);
    }

    //    @Override
//    public AbsenceDTO addAbsence(AbsenceDTO absenceDTO) {
//        Absence absence = absenceMapper.toEntity(absenceDTO);
//        ApprenantDTO apprenantDTO = new ApprenantDTO();
//        Absence test = new Absence();
//        test.setId(absenceDTO.getId());
//        test.setDatedebut(absenceDTO.getDatedebut());
//        test.setDatedefin(absenceDTO.getDatedefin());
//        test.setDuration(absenceDTO.getDuration());
//        apprenantDTO=apprenantsService.getApprenantById(absenceDTO.getApprenantId());
//        test.setApprenant(apprenantMapper.toEntity(apprenantDTO));
//        test.setEtat_absence(absenceDTO.getEtat_absence());
//
//        Absence savedAbsence = absenceRepository.save(test);
//        return absenceMapper.toDTO(savedAbsence);
//    }
@Override
    public Absence newabsence(Absence absence) {
        return absenceRepository.save(absence);
    }



    @Override
    public AbsenceDTO editAbsence(Long id, AbsenceDTO absenceDetails) {
        Optional<Absence> optionalAbsence = absenceRepository.findById(id);

        if (optionalAbsence.isPresent()) {
            Absence existingAbsence = optionalAbsence.get();
            existingAbsence.setDatedebut(absenceDetails.getDatedebut());
            existingAbsence.setDatedefin(absenceDetails.getDatedefin());
            existingAbsence.setDuration(absenceDetails.getDuration());
            existingAbsence.setEtat_absence(absenceDetails.getEtat_absence());

            // Assuming apprenant is fetched and set properly
            Absence updatedAbsence = absenceRepository.save(existingAbsence);
            return absenceMapper.toDTO(updatedAbsence);
        } else {
            throw new RuntimeException("Absence not found with id: " + id);
        }
    }

    @Override
    public List<AbsenceDTO> getAllAbsence() {
        return absenceRepository.findAll().stream()
                .map(absenceMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteAbsence(Long id) {
        absenceRepository.deleteById(id);
    }

    @Override
    public long countRetardsByApprenant(Apprenant apprenant) {
        return absenceRepository.countByApprenant(apprenant);
    }
}
