package com.project.Absence_gestion.Conroller;


import com.project.Absence_gestion.Model.Absence;
import com.project.Absence_gestion.Service.AbsenceService;
import com.project.Absence_gestion.dto.AbsenceDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/absences")
public class AbsenceController {

    @Autowired
    private AbsenceService absenceService;

    // Save a new Absence
    @PostMapping("/Add")
    public ResponseEntity<Absence> saveAbsence(@RequestBody AbsenceDTO absenceDTO) {
        return absenceService.saveAbsence(absenceDTO);
    }

    // Get all Absences
    @GetMapping("/getALL")
    public List<Absence> getAllAbsences() {
        return absenceService.getAllAbsences();
    }

    // Get Absence by ID
    @GetMapping("/AbsencebyID/{id}")
    public ResponseEntity<Absence> getAbsenceById(@PathVariable Long id) {
        Optional<Absence> absence = absenceService.getAbsenceById(id);
        return absence.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Update an Absence
    @PutMapping("/Edit/{id}")
    public ResponseEntity<Absence> updateAbsence(@PathVariable Long id, @RequestBody AbsenceDTO absenceDTO) {
        Absence updatedAbsence = absenceService.updateAbsence(id, absenceDTO);
        if (updatedAbsence != null) {
            return ResponseEntity.ok(updatedAbsence);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Delete an Absence
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteAbsence(@PathVariable Long id) {
        absenceService.deleteAbsence(id);
        return ResponseEntity.noContent().build();
    }

    // Count Absences by Apprenant
    @GetMapping("/countABS/apprenant/{apprenantId}")
    public ResponseEntity<Long> countAbsencesByApprenant(@PathVariable Long apprenantId) {
        long count = absenceService.countAbsencesByApprenant(apprenantId);
        return ResponseEntity.ok(count);
    }

    // Get Absences by Apprenant ID
    @GetMapping("/GetAbsenceBYapprenant/{apprenantId}")
    public ResponseEntity<List<Absence>> getAbsencesByApprenant(@PathVariable Long apprenantId) {
        Optional<List<Absence>> absences = absenceService.findByApprenant(apprenantId);
        return absences.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}
