package com.habngroup.springboot_kaddem.repositories;

import com.habngroup.springboot_kaddem.entities.Professor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProfessorRepo extends JpaRepository<Professor, Long> {
      List<Professor> findProfessorsByDepartmentIdDepart(Long idDepart) ;


}
