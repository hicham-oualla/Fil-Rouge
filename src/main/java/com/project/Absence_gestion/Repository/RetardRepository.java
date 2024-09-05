package com.project.Absence_gestion.Repository;

import com.project.Absence_gestion.Model.Apprenant;
import com.project.Absence_gestion.Model.Retard;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface RetardRepository  extends JpaRepository<Retard,Long> {
    long countByApprenant(Apprenant apprenant);
    List<Retard> findByApprenant(Apprenant apprenant);
}
