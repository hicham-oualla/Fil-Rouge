package com.project.Absence_gestion.Service;

import com.project.Absence_gestion.Model.JustificationRetard;
import com.project.Absence_gestion.Model.Retard;
import com.project.Absence_gestion.Repository.JustificationRetardRepository;
import com.project.Absence_gestion.Repository.RetardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public class JustificationRetardService {

    @Autowired
    private JustificationRetardRepository justificationRetardRepository;

    @Autowired
    private RetardRepository retardRepository;

    public void saveJustificationRetard(Long retardId, MultipartFile file) throws IOException {
        JustificationRetard justificationRetard = new JustificationRetard();

        // Set the retard entity
        Retard retard = retardRepository.findById(retardId)
                .orElseThrow(() -> new RuntimeException("Retard not found"));
        justificationRetard.setRetard(retard);

        // Set the name and type from file
        justificationRetard.setName(file.getOriginalFilename());
        justificationRetard.setType(file.getContentType());

        // Convert the file into a byte array and set it in the justificationRetard entity
        justificationRetard.setPdfData(file.getBytes());

        // Save the justificationRetard entity to the database
        justificationRetardRepository.save(justificationRetard);
    }

    public JustificationRetard getJustificationRetardByRetardId(Long retardId) {
        // Retrieve the justificationRetard by retard ID
        return justificationRetardRepository.findByRetardId(retardId)
                .orElseThrow(() -> new RuntimeException("JustificationRetard not found for the given retard ID"));
    }
}
