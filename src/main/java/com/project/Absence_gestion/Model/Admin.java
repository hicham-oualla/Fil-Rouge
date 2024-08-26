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
public class Admin extends Personne {



    @OneToMany(mappedBy = "admin")
    private List<Justification> justifications;

}
