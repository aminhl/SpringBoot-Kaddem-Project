package com.habngroup.springboot_kaddem.services;

import com.habngroup.springboot_kaddem.entities.Contrat;
import com.habngroup.springboot_kaddem.entities.Etudiant;
import java.util.List;

public interface IEtudiantService {
    void addEtudiant(Etudiant etudiant);
    void updateEtudiant(Long etudiantId, Etudiant etudiant);
    void deleteEtudiant(Etudiant etudiant);
    void deleteEtudiantById(Long etudiantId);
    List<Etudiant> getAllEtudiants();
    Etudiant getEtudiantById(Long etudiantId);
    Etudiant addAndAssignEtudiantToEquipeAndContract(Etudiant etudiant, Long idContrat, Long
            idEquipe);
    Contrat affectContratToEtudiant(Contrat contrat, String nomEtudiant, String prenomEtudiant);
    List<Etudiant> getEtudiantsByDepartement (Long idDepartement);
}
