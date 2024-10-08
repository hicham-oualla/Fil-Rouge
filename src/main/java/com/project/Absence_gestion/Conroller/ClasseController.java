package com.project.Absence_gestion.Conroller;
import com.project.Absence_gestion.Model.Classe;
import com.project.Absence_gestion.Model.Apprenant;
import com.project.Absence_gestion.Service.ClasseService;
import com.project.Absence_gestion.dto.Classedto;
import com.project.Absence_gestion.mapper.ClassMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/classes")
public class ClasseController {

    @Autowired
    private ClasseService classeService;

    @Autowired
    private ClassMapper classMapper;


    @PostMapping("/Add")
    public ResponseEntity<Classedto> createClasse(@RequestBody Classedto classe) {
        Classedto savedClasse = classeService.saveClasse(classe);
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
    public ResponseEntity<Classedto> updateClasse(@PathVariable Long id, @RequestBody Classedto classe) {
        Classedto updatedClasse = classeService.updateClasse(id, classe);
        return new ResponseEntity<>(updatedClasse, HttpStatus.OK);
    }


    @DeleteMapping("/deleteClasse/{id}")
    public ResponseEntity<Void> deleteClasse(@PathVariable Long id) {
        classeService.deleteClasse(id);
        return ResponseEntity.noContent().build();
    }
    @GetMapping("/count")
    public ResponseEntity<Long> count() {
        Long count = classeService.count();
        return ResponseEntity.ok(count);
    }



}
