package com.project.Absence_gestion.Model;

import jakarta.persistence.Entity;
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

    private int classe;  // Changed from String to int

    @OneToMany(mappedBy = "apprenant")
    private List<Absence> absences;

    @OneToMany(mappedBy = "apprenant")
    private List<Retard> retards;

    @OneToMany(mappedBy = "apprenant")
    private List<Justification> justifications;
}
