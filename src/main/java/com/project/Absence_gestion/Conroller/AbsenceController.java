package com.project.Absence_gestion.Conroller;
import com.project.Absence_gestion.Model.Absence;
import com.project.Absence_gestion.dto.AbsenceDTO;
import com.project.Absence_gestion.Service.AbsenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/absences")
public class AbsenceController {

    private final AbsenceService absenceService;

    @Autowired
    public AbsenceController(AbsenceService absenceService) {
        this.absenceService = absenceService;
    }


    @PostMapping
    public ResponseEntity<AbsenceDTO> addAbsence(@RequestBody AbsenceDTO absenceDTO) {
        AbsenceDTO createdAbsence = absenceService.addAbsence(absenceDTO);
        return ResponseEntity.ok(createdAbsence);
    }


    @GetMapping
    public ResponseEntity<List<AbsenceDTO>> getAllAbsences() {
        List<AbsenceDTO> absences = absenceService.getAllAbsence();
        return ResponseEntity.ok(absences);
    }


    @GetMapping("/{id}")
    public ResponseEntity<AbsenceDTO> getAbsenceById(@PathVariable Long id) {
        List<AbsenceDTO> absences = absenceService.getAllAbsence();
        AbsenceDTO absence = absences.stream()
                .filter(absenceDTO -> absenceDTO.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Absence not found with id: " + id));
        return ResponseEntity.ok(absence);
    }


    @PutMapping("/{id}")
    public ResponseEntity<AbsenceDTO> editAbsence(@PathVariable Long id, @RequestBody AbsenceDTO absenceDetails) {
        AbsenceDTO updatedAbsence = absenceService.editAbsence(id, absenceDetails);
        return ResponseEntity.ok(updatedAbsence);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAbsence(@PathVariable Long id) {
        absenceService.deleteAbsence(id);
        return ResponseEntity.noContent().build();
    }


    @PostMapping("/add")
    public Absence newabsence(@RequestBody Absence absence) {

        return absenceService.newabsence(absence);
    }
}
