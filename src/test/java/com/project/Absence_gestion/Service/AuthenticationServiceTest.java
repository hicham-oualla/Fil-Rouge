package com.project.Absence_gestion.Service;

import com.project.Absence_gestion.Model.*;
import com.project.Absence_gestion.Model.enums.Role;
import com.project.Absence_gestion.Repository.*;
import com.project.Absence_gestion.Service.AuthenticationService;
import com.project.Absence_gestion.Service.security.JwtService;
import com.project.Absence_gestion.dto.ApprenantDTO;
import com.project.Absence_gestion.exeption.PersonNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class AuthenticationServiceTest {

    @Mock
    private AdminRepository adminRepository;

    @Mock
    private ApprenantRepository apprenantRepository;

    @Mock
    private PasswordEncoder passwordEncoder;

    @Mock
    private JwtService jwtService;

    @Mock
    private PerssoneRepository perssoneRepository;

    @Mock
    private AuthenticationManager authenticationManager;

    @Mock
    private ClasseRepository classeRepository;

    @InjectMocks
    private AuthenticationService authenticationService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this); // Initialize mocks
    }

    @Test
    void testRegisterAdmin_Success() {
        Admin admin = new Admin();
        admin.setEmail("admin@example.com");
        admin.setPassword("password");
        admin.setNom("Admin User");
        admin.setRole(Role.admin);

        when(adminRepository.findByEmail(admin.getEmail())).thenReturn(Optional.empty());
        when(passwordEncoder.encode(any(String.class))).thenReturn("encodedPassword");
        when(jwtService.generateToken(any(Admin.class))).thenReturn("jwtToken");

        AuthenticationResponse response = authenticationService.registerAdmin(admin);

        assertNotNull(response);
        assertEquals("Admin successfully registered", response.getMessage());
        assertEquals("jwtToken", response.getAccessToken());
        verify(adminRepository).save(any(Admin.class));
    }



    @Test
    void testRegisterApprenant_Success() {
        ApprenantDTO apprenantDTO = new ApprenantDTO();
        apprenantDTO.setEmail("apprenant@example.com");
        apprenantDTO.setPassword("password");
        apprenantDTO.setNom("Apprenant User");
        apprenantDTO.setClasse(1L);

        Classe classe = new Classe();
        classe.setId(1L);

        when(apprenantRepository.findByEmail(apprenantDTO.getEmail())).thenReturn(Optional.empty());
        when(classeRepository.findById(apprenantDTO.getClasse())).thenReturn(Optional.of(classe));
        when(passwordEncoder.encode(any(String.class))).thenReturn("encodedPassword");
        when(jwtService.generateToken(any(Apprenant.class))).thenReturn("jwtToken");

        AuthenticationResponse response = authenticationService.registerApprenant(apprenantDTO);

        assertNotNull(response);
        assertEquals("Apprenant successfully registered", response.getMessage());
        assertEquals("jwtToken", response.getAccessToken());
        verify(apprenantRepository).save(any(Apprenant.class));
    }

    @Test
    void testRegisterApprenant_Failure_EmailExists() {
        ApprenantDTO apprenantDTO = new ApprenantDTO();
        apprenantDTO.setEmail("apprenant@example.com");

        Apprenant existingApprenant = new Apprenant();
        existingApprenant.setEmail("apprenant@example.com");

        when(apprenantRepository.findByEmail(apprenantDTO.getEmail())).thenReturn(Optional.of(existingApprenant));

        AuthenticationResponse response = authenticationService.registerApprenant(apprenantDTO);

        assertNull(response);
        verify(apprenantRepository, never()).save(any(Apprenant.class));
    }

    @Test
    void testAuthenticate_Success() {
        // Create the Admin object and set its fields, including role
        Personne personne = new Admin();
        personne.setEmail("personne@example.com");
        personne.setPassword("password");
        personne.setRole(Role.admin); // Set the role to avoid NullPointerException

        // Mock the repository call to return a Personne object
        when(perssoneRepository.findByEmail(personne.getEmail())).thenReturn(Optional.of(personne));

        // Mock the JWT service to return a JWT token
        when(jwtService.generateToken(any(Personne.class))).thenReturn("jwtToken");

        // Call the authentication service method
        AuthenticationResponse response = authenticationService.authenticate(personne);

        // Assertions to verify the result
        assertNotNull(response);
        assertEquals("login was successful", response.getMessage());

        // Check the accessToken field
        assertEquals("jwtToken", response.getAccessToken());
    }


    @Test
    void testAuthenticate_Failure_PersonNotFound() {
        Personne personne = new Admin();
        personne.setEmail("personne@example.com");
        personne.setPassword("password");

        when(perssoneRepository.findByEmail(personne.getEmail())).thenReturn(Optional.empty());

        assertThrows(PersonNotFoundException.class, () -> authenticationService.authenticate(personne));
    }
}
