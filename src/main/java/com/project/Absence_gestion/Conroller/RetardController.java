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

    @PostMapping
    public ResponseEntity<Retard> createRetard(@RequestBody Retard retard) {
        Retard createdRetard = retardService.saveRetard(retard);
        return ResponseEntity.ok(createdRetard);
    }

    @GetMapping
    public ResponseEntity<List<Retard>> getAllRetards() {
        List<Retard> retards = retardService.getAllRetards();
        return ResponseEntity.ok(retards);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Retard> getRetardById(@PathVariable Long id) {
        Optional<Retard> retard = retardService.getRetardById(id);
        return retard.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Retard> updateRetard(@PathVariable Long id, @RequestBody Retard retard) {
        Retard updatedRetard = retardService.updateRetard(id, retard);
        if (updatedRetard != null) {
            return ResponseEntity.ok(updatedRetard);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRetard(@PathVariable Long id) {
        retardService.deleteRetard(id);
        return ResponseEntity.noContent().build();
    }
}
