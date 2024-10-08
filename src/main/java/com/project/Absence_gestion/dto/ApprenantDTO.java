package com.project.Absence_gestion.dto;

import com.project.Absence_gestion.Model.Justification;
import com.project.Absence_gestion.Model.enums.Role;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class ApprenantDTO {
    private Long id;
    private String nom;
    private String email;
    private String password;
    private Role role;
    private Long classe;
    private String address;
    private String phone;
    private String idNational; // Updated to follow camel case

    // Adding the missing fields
    private List<AbsenceDTO> absences;
    private List<RetardDTO> retards;
    private List<Justification> justifications;
}
