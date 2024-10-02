package com.project.Absence_gestion.Service;

import com.project.Absence_gestion.Model.Admin;
import com.project.Absence_gestion.Model.Apprenant;
import com.project.Absence_gestion.Model.AuthenticationResponse;
import com.project.Absence_gestion.Model.Personne;
import com.project.Absence_gestion.Model.enums.Role;
import com.project.Absence_gestion.Repository.AdminRepository;
import com.project.Absence_gestion.Repository.ApprenantRepository;
import com.project.Absence_gestion.Repository.PerssoneRepository;
import com.project.Absence_gestion.Service.security.JwtService;
import com.project.Absence_gestion.exeption.PersonNotFoundException;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.security.authentication.AuthenticationManager;


@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final AdminRepository adminRepository;
    private  final ApprenantRepository apprenentRepository;
    private final PasswordEncoder passwordEncoder;
    private final ApprenantRepository apprenantRepository;
    private final JwtService jwtService;
    private final PerssoneRepository perssoneRepository;
    private final AuthenticationManager authenticationManager;




    public AuthenticationResponse registerAdmin(Admin admin) {
        //check if admin  already  exist
        if(adminRepository.findByEmail(admin.getEmail()).isPresent())
        {
            return new AuthenticationResponse("null","Admin already exist",admin.getId());
        }

        Admin newAdmin = new Admin();
        newAdmin.setEmail(admin.getEmail());
        newAdmin.setPassword(passwordEncoder.encode(admin.getPassword()));
        newAdmin.setNom(admin.getNom());
        newAdmin.setRole(admin.getRole());
        newAdmin.setRole(Role.admin);
        adminRepository.save(newAdmin);
        String token = jwtService.generateToken(newAdmin);
        return new AuthenticationResponse(token,"Admin successfully registered",newAdmin.getId());
    }


public AuthenticationResponse registerApprenant(Apprenant apprenant) {
        if (apprenantRepository.findByEmail(apprenant.getEmail()).isPresent()){
            return new AuthenticationResponse("null","Apprentant already exist",apprenant.getId());
        }
        Apprenant newApprenant = new Apprenant();
        newApprenant.setEmail(apprenant.getEmail());
        newApprenant.setNom(apprenant.getNom());
        newApprenant.setRole(Role.apprenant);
        newApprenant.setPassword(passwordEncoder.encode(apprenant.getPassword()));
        newApprenant.setAddress(apprenant.getAddress());
        newApprenant.setClasse(apprenant.getClasse());
        newApprenant.setPhone(apprenant.getPhone());
        newApprenant.setIdNational(apprenant.getIdNational());
        apprenentRepository.save(newApprenant);
        String token = jwtService.generateToken(newApprenant);
    return new AuthenticationResponse(token,"Apprenant successfully registered",newApprenant.getId());
}


    public AuthenticationResponse authenticate(Personne request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getUsername(),
                        request.getPassword()
                )
        );
        Personne character = perssoneRepository.findByEmail(request.getUsername()).orElseThrow(()->(new PersonNotFoundException("no character found with "+request.getUsername()+" username")));
        String jwt = jwtService.generateToken(character);

        return new AuthenticationResponse(jwt,"login was successful",character.getId());
    }

}
