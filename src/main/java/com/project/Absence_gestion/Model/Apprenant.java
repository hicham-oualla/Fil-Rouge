package com.project.Absence_gestion.Model;


import com.fasterxml.jackson.annotation.JsonIgnore;
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
@NoArgsConstructor
public class Apprenant extends Personne {


    @OneToMany(mappedBy = "apprenant")
    @JsonIgnore

    private List<Absence> absences;

    @OneToMany(mappedBy = "apprenant")
    @JsonIgnore
    private List<Retard> retards;

    @OneToMany(mappedBy = "apprenant")
    @JsonIgnore
    private List<Justification> justifications;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "classe_id")
    private Classe classe;

}
