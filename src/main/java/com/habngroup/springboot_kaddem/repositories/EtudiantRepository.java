package com.habngroup.springboot_kaddem.repositories;

import com.habngroup.springboot_kaddem.entities.Etudiant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EtudiantRepository extends JpaRepository<Etudiant, Long> {
}
