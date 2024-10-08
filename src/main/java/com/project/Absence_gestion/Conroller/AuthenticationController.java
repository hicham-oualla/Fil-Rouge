package com.project.Absence_gestion.Conroller;



import com.project.Absence_gestion.Model.Admin;
import com.project.Absence_gestion.Model.Apprenant;
import com.project.Absence_gestion.Model.AuthenticationResponse;
import com.project.Absence_gestion.Model.Personne;
import com.project.Absence_gestion.Service.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;




@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthenticationController {

    private final AuthenticationService authenticationService;

    // Endpoint for registering an Admin
    @PostMapping("/register-admin")
    public ResponseEntity<AuthenticationResponse> registerAdmin(@RequestBody Admin admin) {
        AuthenticationResponse response = authenticationService.registerAdmin(admin);
        if ("Admin already exist".equals(response.getMessage())) {
            return ResponseEntity.badRequest().body(response);
        }
        return ResponseEntity.ok(response);
    }

    @PostMapping("/login")
    public ResponseEntity<AuthenticationResponse> login(@RequestBody Personne personne) {
        return ResponseEntity.ok(authenticationService.authenticate(personne));
    }

}
