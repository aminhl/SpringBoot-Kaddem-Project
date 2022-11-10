package com.habngroup.springboot_kaddem.repositories;

import com.habngroup.springboot_kaddem.entities.Departement;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartementRepository extends JpaRepository<Departement, Long> {
}
