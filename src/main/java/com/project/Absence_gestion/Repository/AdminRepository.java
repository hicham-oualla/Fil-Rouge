package com.project.Absence_gestion.Repository;

import com.project.Absence_gestion.Model.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AdminRepository  extends JpaRepository<Admin, Integer> {
    Optional<Admin> findByEmail(String email);
}
