package com.project.Absence_gestion.Conroller;

import com.project.Absence_gestion.Model.Apprenant;
import com.project.Absence_gestion.Service.ApprenantsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/apprenants")
public class ApprenantController {
    @Autowired
    private  ApprenantsService apprenantsService;

    @Autowired
    public void ApprenantsController(ApprenantsService apprenantsService) {
        this.apprenantsService = apprenantsService;
    }

    // Create a new Apprenant
    @PostMapping("/ADD")
    public ResponseEntity<Apprenant> createApprenant(@RequestBody Apprenant apprenant) {
        Apprenant createdApprenant = apprenantsService.createApprenant(apprenant);
        return new ResponseEntity<>(createdApprenant, HttpStatus.CREATED);
    }

    // Get an Apprenant by ID
    @GetMapping("/getApprenants/{id}")
    public ResponseEntity<Apprenant> getApprenantById(@PathVariable Long id) {
        Apprenant apprenant = apprenantsService.getApprenantById(id);
        return new ResponseEntity<>(apprenant, HttpStatus.OK);
    }

    // Get all Apprenants
    @GetMapping("/GetALL")
    public ResponseEntity<List<Apprenant>> getAllApprenants() {
        List<Apprenant> apprenants = apprenantsService.getAllApprenants();
        return new ResponseEntity<>(apprenants, HttpStatus.OK);
    }

    // Update an Apprenant by ID
    @PutMapping("/edit/{id}")
    public ResponseEntity<Apprenant> updateApprenant(@PathVariable Long id, @RequestBody Apprenant apprenant) {
        Apprenant updatedApprenant = apprenantsService.updateApprenant(id, apprenant);
        return new ResponseEntity<>(updatedApprenant, HttpStatus.OK);
    }

    // Delete an Apprenant by ID
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteApprenant(@PathVariable Long id) {
        apprenantsService.deleteApprenant(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    // Find all Apprenants by Classe ID
    @GetMapping("/Allapprenants/byclasse/{classId}")
    public ResponseEntity<List<Apprenant>> findAllByClasseId(@PathVariable Long classId) {
        List<Apprenant> apprenants = apprenantsService.findAllByClasseId(classId);
        return new ResponseEntity<>(apprenants, HttpStatus.OK);
    }

    // Find Apprenant by ID with Optional handling
    @GetMapping("/FindAPPby/{id}")
    public ResponseEntity<Apprenant> findApprenantById(@PathVariable Long id) {
        Optional<Apprenant> apprenant = apprenantsService.findById(id);
        return apprenant.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}
