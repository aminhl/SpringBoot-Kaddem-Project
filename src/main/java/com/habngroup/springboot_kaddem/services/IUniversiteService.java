package com.habngroup.springboot_kaddem.services;

import com.habngroup.springboot_kaddem.entities.Departement;
import com.habngroup.springboot_kaddem.entities.Etudiant;
import com.habngroup.springboot_kaddem.entities.Professor;
import com.habngroup.springboot_kaddem.entities.Universite;
import java.util.List;

public interface IUniversiteService {
    void addUniversite(Universite universite);
    void updateUniversite(Long universiteId, Universite universite);
    void deleteUniversite(Universite universite);
    void deleteUniversiteById(Long universiteId);
    List<Universite> getAllUniversites();
    Universite getUniversiteById(Long universiteId);
    void assignUniversiteToDepartement(Long idUniversite, Long idDepartement);
    List<Departement> retrieveDepartementsByUniversite(Long idUniversite);
    void assignUniversiteToEtudiant(Long idUniversite, Long idEtudiant);
    List<Etudiant> retrieveEtudiantByUniversite(Long idUniversite);
    void assignUniversiteToProfessor(Long idUniversite,Long idProfessor);
    List<Professor> retrieveProfessorByUniversite(Long idUniversite);
}
