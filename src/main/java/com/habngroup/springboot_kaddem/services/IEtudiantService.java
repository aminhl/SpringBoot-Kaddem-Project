package com.habngroup.springboot_kaddem.services;

import com.habngroup.springboot_kaddem.entities.*;

import java.text.ParseException;
import java.util.List;
import java.util.TreeSet;

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
    String retrieveAndUpdateStatusContratbyEtudiant() throws ParseException;
    List<Etudiant> findetudiantByNameOrLastName(String nomE,String prenomE);
    List<Etudiant> ShowStudentbyOption(Option option);

    List<Etudiant> ShowStudentbyNomClub(String nomClub);

    TreeSet<Etudiant> TriEtudiantbyName();

}
