package com.habngroup.springboot_kaddem.controllers;

import com.habngroup.springboot_kaddem.entities.Professor;
import com.habngroup.springboot_kaddem.services.ContratService;
import com.habngroup.springboot_kaddem.services.DepartementService;
import com.habngroup.springboot_kaddem.services.ProfessorService;
import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@AllArgsConstructor

public class ProfessorController {
    private ProfessorService professorService;
    //TODO REMOVE UNUSED ATTRIBUTE LIKE THESE TWO BELLOW
    private ContratService contratService;
    private DepartementService departementService;
    @PostMapping("addProfessor/")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public void addProfessor(Professor professor) {
        professorService.addProfessor(professor);
    }

    @PutMapping("updateProfessor")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public void updateProfessor( Professor professor) {
        professorService.updateProfessor(professor);
    }

    @DeleteMapping("deleteProfessor")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public void deleteProfessor(Professor professor) {
        professorService.deleteProfessor(professor);
    }

    @PostMapping("assignProfessorToContrat")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public void assignProfessorToContrat(Long professorId, Long CntratId) {
        professorService.assignProfessorToContrat(professorId, CntratId);
    }
    @PostMapping("assignProfessorToDepartment")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public void assignProfessorToDepartement(Long professorId, Long departementId) {
        professorService.assignProfessorToDepartement(professorId, departementId);
    }
    @GetMapping("getProfessorsByDepartmentId")
    @PreAuthorize("hasAnyRole('ROLE_USER','ROLE_ADMIN')")
    public List<Professor> getProfessorsByDepartementId(Long idDepartement) {

      return professorService.getProfessorsByDepartement(idDepartement);
    }

    @GetMapping("getProfessors")
    @PreAuthorize("hasAnyRole('ROLE_USER','ROLE_ADMIN')")
    public List<Professor> getAllProfessors() {
        return   professorService.getAllProfessors();
    }

    @GetMapping("getProfessorById")
    @PreAuthorize("hasAnyRole('ROLE_USER','ROLE_ADMIN')")
    public Professor getProfessorById(Long professorId) {
        return professorService.getProfessorById(professorId);
    }


    @PreAuthorize("hasRole('ROLE_ADMIN')")
    //TODO ADD EXPOSING METHOD LIKE @PostMapping ...
    public Professor addAndAssignProfessorToEquipeAndContract(Professor Professor, Long idContrat, Long idEquipe) {
        return null;
    }
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    //TODO ADD EXPOSING METHOD LIKE @PostMapping ..
    public void deleteProfessorById(Long professorId) {
        //TODO ADD THE METHOD BEHAVIOR

    }
}
