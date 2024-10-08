package com.project.Absence_gestion.Model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.project.Absence_gestion.Model.enums.Role;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
public class Apprenant extends Personne {

    private String address;
    private String phone;
    private String IdNational;



    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "classe_id")
    private Classe classe;



    @OneToMany(mappedBy = "apprenant", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Absence> absences;

    @OneToMany(mappedBy = "apprenant", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Retard> retards;

    public Apprenant() {
        this.setRole(Role.apprenant);
    }
}
