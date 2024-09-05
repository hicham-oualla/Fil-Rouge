package com.project.Absence_gestion.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.project.Absence_gestion.Model.enums.Etat_retard;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Retard {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private Date date;

    private int durationDeRetard;

    @Enumerated(EnumType.STRING)
    private Etat_retard etat_retard;


    @ManyToOne
    @JoinColumn(name = "apprenant_id")
    private Apprenant apprenant;



}
