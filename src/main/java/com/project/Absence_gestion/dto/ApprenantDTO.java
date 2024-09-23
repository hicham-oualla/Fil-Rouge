package com.project.Absence_gestion.dto;


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
    private Long classeId;
    private String address;
    private String phone;
    private String IdNational;
    // Add this field

    // Optionally include other fields if needed
    private List<Long> absences; // Example, adjust according to your requirements
    private List<Long> retards;   // Example, adjust according to your requirements
    private List<Long> justifications; // Example, adjust according to your requirements


}
