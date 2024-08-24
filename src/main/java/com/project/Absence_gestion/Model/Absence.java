package com.project.Absence_gestion.Model;

import jakarta.persistence.*;

import java.util.Date;
@Entity
public class Absence {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Temporal(TemporalType.DATE)
    private Date date;

    private int duration;

    @ManyToOne
    @JoinColumn(name = "admin_id")
    private Admin admin;

    @ManyToOne
    @JoinColumn(name = "apprenant_id")
    private Apprenant apprenant;
}
