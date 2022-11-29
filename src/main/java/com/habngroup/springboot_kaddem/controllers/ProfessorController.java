package com.habngroup.springboot_kaddem.controllers;

import com.habngroup.springboot_kaddem.entities.Professor;
import com.habngroup.springboot_kaddem.services.ContratService;
import com.habngroup.springboot_kaddem.services.DepartementService;
import com.habngroup.springboot_kaddem.services.ProfessorService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@AllArgsConstructor

public class ProfessorController {
    private ProfessorService professorService;
    private ContratService contratService;
    private DepartementService departementService;
    @PostMapping("addProfessor")
    public void addProfessor(Professor professor) {
        professorService.addProfessor(professor);
    }

    @PutMapping("updateProfessor")
    public void updateProfessor( Professor professor) {
        professorService.updateProfessor(professor);
    }

    @DeleteMapping("deleteProfessor")
    public void deleteProfessor(Professor professor) {
        professorService.deleteProfessor(professor);
    }

    @PostMapping("assignProfessorToContrat")
    public void assignProfessorToContrat(Long professorId, Long CntratId) {
        professorService.assignProfessorToContrat(professorId, CntratId);
    }
    @PostMapping("assignProfessorToDepartment")
    public void assignProfessorToDepartement(Long professorId, Long departementId) {
        professorService.assignProfessorToDepartement(professorId, departementId);
    }
    @GetMapping("getProfessorsByDepartmentId")
    public List<Professor> getProfessorsByDepartementId(Long idDepartement) {

      return professorService.getProfessorsByDepartement(idDepartement);
    }

    @GetMapping("getProfessors")
    public List<Professor> getAllProfessors() {
        return   professorService.getAllProfessors();
    }

    @GetMapping("getProfessorById")
    public Professor getProfessorById(Long professorId) {
        return professorService.getProfessorById(professorId);
    }

    public Professor addAndAssignProfessorToEquipeAndContract(Professor Professor, Long idContrat, Long idEquipe) {
        return null;
    }
    public void deleteProfessorById(Long professorId) {

    }
}
