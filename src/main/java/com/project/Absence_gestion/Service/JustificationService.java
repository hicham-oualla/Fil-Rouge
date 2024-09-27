package com.project.Absence_gestion.Service;

import com.project.Absence_gestion.Model.Absence;
import com.project.Absence_gestion.Model.Justification;
import com.project.Absence_gestion.Repository.AbesenceRepository;
import com.project.Absence_gestion.Repository.JustificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.LocalDate;

@Service
public class JustificationService {

    @Autowired
    private JustificationRepository JustificationRepository;

    @Autowired
    private AbesenceRepository absenceRepository;

    public void saveJustification(Long absenceId, MultipartFile file) throws IOException {
        Justification justification = new Justification();

        // Set the date and absence entity
        justification.setDate(LocalDate.now());

        Absence absence = absenceRepository.findById(absenceId)
                .orElseThrow(() -> new RuntimeException("Absence not found"));
        justification.setAbsence(absence);

        // Set the name and type from file or other logic if needed
        justification.setName(file.getOriginalFilename());
        justification.setType(file.getContentType());

        // Convert the file into a byte array and set it in the justification entity
        justification.setPdfData(file.getBytes());

        // Save the justification entity to the database
        JustificationRepository.save(justification);
    }

    public Justification getJustificationByAbsenceId(Long absenceId) {
        // Retrieve the justification by absence ID
        return JustificationRepository.findByAbsenceId(absenceId)
                .orElseThrow(() -> new RuntimeException("Justification not found for the given absence ID"));
    }
}
