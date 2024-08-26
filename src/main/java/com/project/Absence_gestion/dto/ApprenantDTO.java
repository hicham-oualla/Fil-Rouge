
package com.project.Absence_gestion.dto;

import com.project.Absence_gestion.Model.enums.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ApprenantDTO {
    private Long id;
    private String nom;
    private String email;
    private String password;
    private Role role;
    private Long classeId;
}