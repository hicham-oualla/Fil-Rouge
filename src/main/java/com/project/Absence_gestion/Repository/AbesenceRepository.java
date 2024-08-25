package com.project.Absence_gestion.Repository;

import com.project.Absence_gestion.Model.Absence;

import org.springframework.data.jpa.repository.JpaRepository;



public interface AbesenceRepository extends JpaRepository<Absence, Long>  {
}
