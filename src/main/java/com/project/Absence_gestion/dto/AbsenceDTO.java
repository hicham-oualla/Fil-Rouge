package com.project.Absence_gestion.dto;

import com.project.Absence_gestion.Model.enums.Etat_absence;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AbsenceDTO {
    private Long id;
    private Date datedebut;
    private Date datedefin;
    private int duration;
    private Long apprenantId;
    @Enumerated(EnumType.STRING)
    private Etat_absence etat_absence;
}
