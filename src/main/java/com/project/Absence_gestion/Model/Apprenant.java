package com.project.Absence_gestion.Model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.project.Absence_gestion.Model.enums.Role;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
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
    @OneToMany(mappedBy = "apprenant")
    @JsonIgnore

    private List<Absence> absences;

    @OneToMany(mappedBy = "apprenant")
    @JsonIgnore
    private List<Retard> retards;


    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "classe_id")
    private Classe classe;

    public Apprenant() {
        this.setRole(Role.apprenant);
    }
}
