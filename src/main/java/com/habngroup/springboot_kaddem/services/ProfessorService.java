package com.habngroup.springboot_kaddem.services;

import com.habngroup.springboot_kaddem.entities.Contrat;
import com.habngroup.springboot_kaddem.entities.Departement;
import com.habngroup.springboot_kaddem.entities.Professor;
import com.habngroup.springboot_kaddem.repositories.ContratRepository;
import com.habngroup.springboot_kaddem.repositories.DepartementRepository;
import com.habngroup.springboot_kaddem.repositories.ProfessorRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
@Service
@AllArgsConstructor
public class ProfessorService implements IProfessor{

    ProfessorRepo professorRepo ;
    ContratRepository contratRepository;
    DepartementRepository departementRepository;
    @Override
    public void addProfessor(@RequestBody Professor professor) {
        professorRepo.save(professor);
    }

    @Override
    public void updateProfessor( @RequestBody Professor professor) {
        professorRepo.save(professor);
    }

    @Override
    public void deleteProfessor(Professor professor) {
        professorRepo.delete(professor);
    }

    @Override
    public void deleteProfessorById(Long professorId) {

    }
    @Override
    public List<Professor> getAllProfessors() {
      return   professorRepo.findAll();
    }

    @Override
    public Professor getProfessorById(Long professorId) {
        return professorRepo.findById(professorId).orElse(null);
    }

    @Override
    public void assignProfessorToDepartement(Long professorId, Long departementId) {
        Professor professor = professorRepo.findById(professorId).orElse(null);
        Departement departement = departementRepository.findById(departementId).orElse(null);
        professor.setDepartment(departement);
        professorRepo.save(professor);
    }

    @Override
    public void assignProfessorToContrat(Long professorId, Long contratId) {
        Professor professor = professorRepo.findById(professorId).orElse(null);
        Contrat contrat = contratRepository.findById(contratId).orElse(null);
        professor.setContrat(contrat);
        professorRepo.save(professor);
    }



    @Override
    public List<Professor> getProfessorsByDepartement(Long idDepartement) {
        return professorRepo.findProfessorsByDepartmentIdDepart(idDepartement);
    }
    @Override
    public Professor addAndAssignProfessorToEquipeAndContract(Professor Professor, Long idContrat, Long idEquipe) {
        return null;
    }
}
