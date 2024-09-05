package com.project.Absence_gestion.Conroller;
import com.project.Absence_gestion.Model.Classe;
import com.project.Absence_gestion.Model.Apprenant;
import com.project.Absence_gestion.Service.ClasseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/classes")
public class ClasseController {

    @Autowired
    private ClasseService classeService;


    @PostMapping("/Add")
    public ResponseEntity<Classe> createClasse(@RequestBody Classe classe) {
        Classe savedClasse = classeService.saveClasse(classe);
        return ResponseEntity.ok(savedClasse);
    }


    @GetMapping("/getAllClasses")
    public ResponseEntity<List<Classe>> getAllClasses() {
        List<Classe> classes = classeService.getAllClasses();
        return ResponseEntity.ok(classes);
    }


    @GetMapping("/getClasseById/{id}")
    public ResponseEntity<Classe> getClasseById(@PathVariable Long id) {
        Classe classe = classeService.getClasseById(id);
        if (classe != null) {
            return ResponseEntity.ok(classe);
        }
        return ResponseEntity.notFound().build();
    }


    @PutMapping("/updateClasse/{id}")
    public ResponseEntity<Classe> updateClasse(@PathVariable Long id, @RequestBody Classe classe) {
        Classe updatedClasse = classeService.updateClasse(id, classe);
        if (updatedClasse != null) {
            return ResponseEntity.ok(updatedClasse);
        }
        return ResponseEntity.notFound().build();
    }


    @DeleteMapping("/deleteClasse/{id}")
    public ResponseEntity<Void> deleteClasse(@PathVariable Long id) {
        classeService.deleteClasse(id);
        return ResponseEntity.noContent().build();
    }



}
