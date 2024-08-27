package com.project.Absence_gestion.Conroller;
import com.project.Absence_gestion.Model.Absence;
import com.project.Absence_gestion.Model.Apprenant;
import com.project.Absence_gestion.Service.AbsenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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


    @PostMapping("/addAbsence")
    public ResponseEntity<Absence> addAbsence(@RequestBody Absence absence) {
        Absence createdAbsence = absenceService.addAbsence(absence);
        return new ResponseEntity<>(createdAbsence, HttpStatus.CREATED);
    }


    @PutMapping("/{id}")
    public ResponseEntity<Absence> editAbsence(@PathVariable Long id, @RequestBody Absence absenceDetails) {
        try {
            Absence updatedAbsence = absenceService.editAbsence(id, absenceDetails);
            return new ResponseEntity<>(updatedAbsence, HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


    @GetMapping("/allabsence")
    public ResponseEntity<List<Absence>> getAllAbsences() {
        List<Absence> absences = absenceService.getAllAbsence();
        return new ResponseEntity<>(absences, HttpStatus.OK);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAbsence(@PathVariable Long id) {
        try {
            absenceService.deleteAbsence(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @GetMapping("/count/{apprenantId}")
    public ResponseEntity<Long> countRetardsByApprenant(@PathVariable Long apprenantId) {
        Apprenant apprenant = new Apprenant(); // Assuming you have a way to retrieve an apprenant
        apprenant.setId(apprenantId);
        long count = absenceService.countRetardsByApprenant(apprenant);
        return ResponseEntity.ok(count);
    }
}
