package com.project.Absence_gestion.Conroller;

import com.project.Absence_gestion.Model.Retard;
import com.project.Absence_gestion.Service.RetardService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/api/retards")
public class RetardController {

    @Autowired
    private RetardService retardService;

    // Save a new Retard
    @PostMapping("/saveRetard&app/{apprenantId}")
    public ResponseEntity<Retard> saveRetard(@RequestBody Retard retard, @PathVariable Long apprenantId) {
        return retardService.saveRetard(retard, apprenantId);
    }

    // Get all Retards
    @GetMapping("/All")
    public List<Retard> getAllRetards() {
        return retardService.getAllRetards();
    }

    // Get Retard by ID
    @GetMapping("/getRetardById/{id}")
    public ResponseEntity<Retard> getRetardById(@PathVariable Long id) {
        Optional<Retard> retard = retardService.getRetardById(id);
        return retard.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Update a Retard
    @PutMapping("/updateRetard/{id}")
    public ResponseEntity<Retard> updateRetard(@PathVariable Long id, @RequestBody Retard retard) {
        Retard updatedRetard = retardService.updateRetard(id, retard);
        if (updatedRetard != null) {
            return ResponseEntity.ok(updatedRetard);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Delete a Retard
    @DeleteMapping("/deleteRetard/{id}")
    public ResponseEntity<Void> deleteRetard(@PathVariable Long id) {
        retardService.deleteRetard(id);
        return ResponseEntity.noContent().build();
    }

    // Count Retards by Apprenant
    @GetMapping("/countRetardsByApprenant/{apprenantId}")
    public ResponseEntity<Long> countRetardsByApprenant(@PathVariable Long apprenantId) {
        Optional<List<Retard>> retards = retardService.findByApprenant(apprenantId);
        if (retards.isPresent()) {
            long count = retards.get().size();
            return ResponseEntity.ok(count);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Get Retards by Apprenant ID
    @GetMapping("/getRetardsByApprenant/{apprenantId}")
    public ResponseEntity<List<Retard>> getRetardsByApprenant(@PathVariable Long apprenantId) {
        Optional<List<Retard>> retards = retardService.findByApprenant(apprenantId);
        return retards.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
//    @PutMapping("/{retardId}/change-status")
//    public ResponseEntity<Retard> changeStatutRetard(@PathVariable Long retardId, @RequestParam Etat_retard etat_retard) {
//        return retardService.changeStatutRetard(retardId, etat_retard);
//    }
}
