package com.project.Absence_gestion.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class JustificationRetard {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String type;

    @Lob
    @Column(name = "pdfdata", length = 1000)
    private byte[] pdfData;

    @ManyToOne
    @JoinColumn(name = "retard_id")
    private Retard retard;
}
