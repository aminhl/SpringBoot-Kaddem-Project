package com.habngroup.springboot_kaddem.services;

import com.habngroup.springboot_kaddem.entities.Contrat;
import com.habngroup.springboot_kaddem.entities.Departement;
import com.habngroup.springboot_kaddem.entities.Equipe;
import com.habngroup.springboot_kaddem.entities.Etudiant;
import java.util.List;

public interface IEtudiantService {
    void addEtudiant(Etudiant etudiant);
    void updateEtudiant(Long etudiantId, Etudiant etudiant);
    void deleteEtudiant(Etudiant etudiant);
    void deleteEtudiantById(Long etudiantId);
    List<Etudiant> getAllEtudiants();
    Etudiant getEtudiantById(Long etudiantId);
     void assignEtudiantToDepartement (Long etudiantId, Long departementId) ;
    Etudiant addAndAssignEtudiantToEquipeAndContract(Etudiant etudiant, Long idContrat, Long
            idEquipe);
    List<Etudiant> getEtudiantsByDepartement (Long idDepartement);

    Departement ShowDepartementEtudiantDetails(Long departementId);

    List<Contrat> getAllContratByIdEtudiant(Long idEtudiant);

    void AssignEtudiantToClub(Long etudiantId, Long clubId);

}
