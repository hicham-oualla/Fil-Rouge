package com.project.Absence_gestion.Conroller;

import com.project.Absence_gestion.Model.Justification;
import com.project.Absence_gestion.Service.JustificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.LocalDate;

@RestController
@RequestMapping("/api/justifications")
public class JustificationController {

    @Autowired
    private JustificationService justificationService;

    @PostMapping("/upload")
    public ResponseEntity<String> uploadJustification(
            @RequestParam("absenceId") Long absenceId,
            @RequestParam("pdf") MultipartFile file) {
        try {
            // Save the justification with the provided absenceId and file
            justificationService.saveJustification(absenceId, file);
            return ResponseEntity.ok("Justification uploaded successfully");
        } catch (IOException e) {
            // Return a response with an error message if file handling fails
            return ResponseEntity.badRequest().body("Failed to upload justification: " + e.getMessage());
        } catch (RuntimeException e) {
            // Handle any runtime exceptions, such as absence not found
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/pdf/{absenceId}")
    public ResponseEntity<byte[]> getJustificationPdfByAbsenceId(@PathVariable Long absenceId) {
        try {
            Justification justification = justificationService.getJustificationByAbsenceId(absenceId);

            // Set the response with PDF data and appropriate headers
            return ResponseEntity.ok()
                    .header("Content-Disposition", "attachment; filename=\"" + justification.getName() + "\"")
                    .header("Content-Type", justification.getType())
                    .body(justification.getPdfData());
        } catch (RuntimeException e) {
            // Handle cases where justification is not found
            return ResponseEntity.badRequest().body(null);
        }
    }
}
