package com.habngroup.springboot_kaddem.services;

import com.habngroup.springboot_kaddem.entities.Etudiant;
import java.util.List;

public interface IEtudiantService {
    void addEtudiant(Etudiant etudiant);
    void updateEtudiant(Etudiant etudiant);
    void deleteEtudiant(Etudiant etudiant);
    void deleteEtudiantById(Long id);
    List<Etudiant> getAllEtudiants();
    Etudiant getEtudiantById(Long id);
}
