package com.project.Absence_gestion.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.project.Absence_gestion.Model.enums.Etat_absence;
import com.project.Absence_gestion.Model.enums.Role;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Absence {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private Date datedebut;

    private Date datedefin;

    private int duration;



    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "apprenant_id")
    private Apprenant apprenant;

    @Enumerated(EnumType.STRING)
    private Etat_absence etat_absence;

    @OneToMany(mappedBy = "absence", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Justification> justification;

}

