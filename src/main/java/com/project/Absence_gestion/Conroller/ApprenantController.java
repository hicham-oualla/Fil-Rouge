package com.project.Absence_gestion.Conroller;


import com.project.Absence_gestion.Model.Apprenant;
import com.project.Absence_gestion.Service.ApprenantsService;
import com.project.Absence_gestion.dto.ApprenantDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/apprenants")
public class ApprenantController {

    @Autowired
    private ApprenantsService apprenantsService;

    // Create a new Apprenant
    @PostMapping
    public ResponseEntity<ApprenantDTO> createApprenant(@RequestBody ApprenantDTO apprenantDTO) {
        ApprenantDTO createdApprenant = apprenantsService.createApprenant(apprenantDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdApprenant);
    }

    // Get an Apprenant by ID
    @GetMapping("/{id}")
    public ResponseEntity<ApprenantDTO> getApprenantById(@PathVariable Long id) {
        ApprenantDTO apprenantDTO = apprenantsService.getApprenantById(id);
        return ResponseEntity.ok(apprenantDTO);
    }

    // Get all Apprenants
    @GetMapping
    public ResponseEntity<List<ApprenantDTO>> getAllApprenants() {
        List<ApprenantDTO> apprenants = apprenantsService.getAllApprenants();
        return ResponseEntity.ok(apprenants);
    }

    // Update an Apprenant by ID
    @PutMapping("/{id}")
    public ResponseEntity<ApprenantDTO> updateApprenant(@PathVariable Long id, @RequestBody ApprenantDTO apprenantDTO) {
        ApprenantDTO updatedApprenant = apprenantsService.updateApprenant(id, apprenantDTO);
        return ResponseEntity.ok(updatedApprenant);
    }

    // Delete an Apprenant by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteApprenant(@PathVariable Long id) {
        apprenantsService.deleteApprenant(id);
        return ResponseEntity.noContent().build();
    }

    // Get all Apprenants by Classe ID
    @GetMapping("/classe/{classId}")
    public List<Apprenant> getAllApprenantByClasseId(@PathVariable("classId") Long classId) {
        List<Apprenant> apprenants = apprenantsService.findAllByClasseId(classId);
       return apprenants;
    }
}
