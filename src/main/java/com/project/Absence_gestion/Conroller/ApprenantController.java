package com.project.Absence_gestion.Conroller;

import com.project.Absence_gestion.dto.ApprenantDTO;
import com.project.Absence_gestion.Service.ApprenantsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/apprenants")
public class ApprenantController {

    private final ApprenantsService apprenantsService;

    @Autowired
    public ApprenantController(ApprenantsService apprenantsService) {
        this.apprenantsService = apprenantsService;
    }

    // Create a new Apprenant
    @PostMapping("/ADD")
    public ResponseEntity<ApprenantDTO> createApprenant(@RequestBody ApprenantDTO apprenantDTO) {
        ApprenantDTO createdApprenant = apprenantsService.createApprenant(apprenantDTO);
        return new ResponseEntity<>(createdApprenant, HttpStatus.CREATED);
    }

    // Get an Apprenant by ID
    @GetMapping("/getApprenants/{id}")
    public ResponseEntity<ApprenantDTO> getApprenantById(@PathVariable Long id) {
        ApprenantDTO apprenantDTO = apprenantsService.getApprenantById(id);
        return new ResponseEntity<>(apprenantDTO, HttpStatus.OK);
    }

    // Get all Apprenants
    @GetMapping("/GetALL")
    public ResponseEntity<List<ApprenantDTO>> getAllApprenants() {
        List<ApprenantDTO> apprenantsDTO = apprenantsService.getAllApprenants();
        return new ResponseEntity<>(apprenantsDTO, HttpStatus.OK);
    }

    // Update an Apprenant by ID
    @PutMapping("/edit/{id}")
    public ResponseEntity<ApprenantDTO> updateApprenant(@PathVariable Long id, @RequestBody ApprenantDTO apprenantDTO) {
        ApprenantDTO updatedApprenant = apprenantsService.updateApprenant(id, apprenantDTO);
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
    public ResponseEntity<List<ApprenantDTO>> findAllByClasseId(@PathVariable Long classId) {
        List<ApprenantDTO> apprenantsDTO = apprenantsService.findAllByClasseId(classId);
        return new ResponseEntity<>(apprenantsDTO, HttpStatus.OK);
    }

    // Find Apprenant by ID with Optional handling
    @GetMapping("/FindAPPby/{id}")
    public ResponseEntity<ApprenantDTO> findApprenantById(@PathVariable Long id) {
        Optional<ApprenantDTO> apprenantDTO = apprenantsService.findById(id);
        return apprenantDTO.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}
