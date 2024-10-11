package com.project.Absence_gestion.Conroller;

import com.project.Absence_gestion.Model.JustificationRetard;
import com.project.Absence_gestion.Service.JustificationRetardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/justificationsRetard")
public class JustificationRetardController {

    @Autowired
    private JustificationRetardService justificationRetardService;

    /**
     * Endpoint to upload a justification for a retard.
     *
     * @param retardId the ID of the retard to which the justification is related
     * @param file     the PDF file containing the justification
     * @return a response indicating success or failure
     */
    @PostMapping("/upload")
    public ResponseEntity<String> uploadJustificationRetard(
            @RequestParam("retardId") Long retardId,
            @RequestParam("pdf") MultipartFile file) {
        try {
            // Save the justification with the provided retardId and file
            justificationRetardService.saveJustificationRetard(retardId, file);
            return ResponseEntity.ok("JustificationRetard uploaded successfully");
        } catch (IOException e) {
            // Return a response with an error message if file handling fails
            return ResponseEntity.badRequest().body("Failed to upload justificationRetard: " + e.getMessage());
        } catch (RuntimeException e) {
            // Handle any runtime exceptions, such as retard not found
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/pdf/{retardId}")
    public ResponseEntity<byte[]> getJustificationRetardPdfByRetardId(@PathVariable Long retardId) {
        try {
            JustificationRetard justificationRetard = justificationRetardService.getJustificationRetardByRetardId(retardId);

            // Set the response with PDF data and appropriate headers
            return ResponseEntity.ok()
                    .header("Content-Disposition", "attachment; filename=\"" + justificationRetard.getName() + "\"")
                    .header("Content-Type", justificationRetard.getType())
                    .body(justificationRetard.getPdfData());
        } catch (RuntimeException e) {
            // Handle cases where justificationRetard is not found
            return ResponseEntity.badRequest().body(null);
        }
    }
}
