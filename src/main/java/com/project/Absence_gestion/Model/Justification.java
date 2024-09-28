package com.project.Absence_gestion.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Justification {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate date;



    private String name;
    private String type;
    @Lob
    @Column(name = "pdfabsence ", length = 1000)
    private byte[] pdfData;



    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "absence_id")
    private Absence absence;

}
