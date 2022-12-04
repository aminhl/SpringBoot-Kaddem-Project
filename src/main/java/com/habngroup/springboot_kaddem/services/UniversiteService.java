package com.habngroup.springboot_kaddem.services;

import com.habngroup.springboot_kaddem.entities.Departement;
import com.habngroup.springboot_kaddem.entities.Etudiant;
import com.habngroup.springboot_kaddem.entities.Professor;
import com.habngroup.springboot_kaddem.entities.Universite;
import com.habngroup.springboot_kaddem.repositories.DepartementRepository;
import com.habngroup.springboot_kaddem.repositories.EtudiantRepository;
import com.habngroup.springboot_kaddem.repositories.ProfessorRepo;
import com.habngroup.springboot_kaddem.repositories.UniversiteRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;

@Service
@AllArgsConstructor
public class UniversiteService implements IUniversiteService{

    private final UniversiteRepository universiteRepository;
    private final DepartementRepository departementRepository;
    private final EtudiantRepository etudiantRepository;
    private final ProfessorRepo professorRepository;
    @Override
    public void addUniversite(Universite universite) {
        // TODO checking universite !existence before inserting
        universiteRepository.save(universite);
    }

    @Override
    public void updateUniversite(Long universiteId, Universite universite) {
        // TODO checking universite existence before updating
        Universite universiteToUpdate = getUniversiteById(universiteId);
        if (universiteToUpdate != null){
            if (universite != null && !Objects.equals(universiteToUpdate, universite)){
                universiteToUpdate.setNomUniv(universite.getNomUniv());
                universiteRepository.save(universite);
            }
        }
        else throw new IllegalStateException("Univeriste with id " + universiteId + " does not exist");

    }

    @Override
    public void deleteUniversite(Universite universite) {
        // TODO checking universite existence before deleting
        universiteRepository.delete(universite);
    }

    @Override
    public void deleteUniversiteById(Long universiteId) {
        // TODO checking universite existence before deleting
        universiteRepository.deleteById(universiteId);
    }

    @Override
    public List<Universite> getAllUniversites() {
        return universiteRepository.findAll();
    }

    @Override
    public Universite getUniversiteById(Long universiteId) {
        return universiteRepository.findById(universiteId)
                .orElseThrow(() -> new IllegalStateException("Universite with id " + universiteId + " does not exist"));
    }
    @Override
    public void assignUniversiteToDepartement(Long idUniversite, Long idDepartement) {
        Optional<Departement> optionalDepartement = departementRepository.findById(idDepartement);
        Optional<Universite> optionalUniversite = universiteRepository.findById(idUniversite);
        if(optionalUniversite.isPresent()&& optionalDepartement.isPresent()){
            Set<Departement> departements = optionalUniversite.get().getDepartements();
            departements.add(optionalDepartement.get());
            universiteRepository.save(optionalUniversite.orElse(null));
        }
    }
    @Override
    public List<Departement> retrieveDepartementsByUniversite(Long idUniversite) {
        Universite universite = universiteRepository.findById(idUniversite).orElseThrow(() -> new IllegalStateException("University with id " + idUniversite +  "does not exist"));
        return universite.getDepartements().stream().toList();
    }

    @Override
    public void assignUniversiteToEtudiant(Long idUniversite, Long idEtudiant) {
        Optional<Etudiant> optionalEtudiant = etudiantRepository.findById(idEtudiant);
        Optional<Universite> optionalUniversite= universiteRepository.findById(idUniversite);
        if(optionalUniversite.isPresent()&& optionalEtudiant.isPresent()){
            Set<Etudiant> etudiants= optionalUniversite.get().getEtudiants();
            etudiants.add(optionalEtudiant.get());
            universiteRepository.save(optionalUniversite.orElse(null));
        }
    }

    @Override
    public List<Etudiant> retrieveEtudiantByUniversite(Long idUniversite) {
        Universite universite = universiteRepository.findById(idUniversite).orElseThrow(() -> new IllegalStateException("University with id " + idUniversite +  "does not exist"));
        return universite.getEtudiants().stream().toList();
    }

    @Override
    public void assignUniversiteToProfessor(Long idUniversite, Long idProfessor) {
        Optional<Professor> optionalProfessor= professorRepository.findById(idProfessor);
        Optional<Universite> optionalUniversite= universiteRepository.findById(idUniversite);
        if(optionalUniversite.isPresent()&& optionalProfessor.isPresent()){
            Set<Professor> professors=optionalUniversite.get().getProfessors();
            professors.add(optionalProfessor.get());
            universiteRepository.save(optionalUniversite.orElse(null));
        }

    }

    @Override
    public List<Professor> retrieveProfessorByUniversite(Long idUniversite) {
        Universite universite = universiteRepository.findById(idUniversite).orElseThrow(() -> new IllegalStateException("University with id " + idUniversite +  "does not exist"));
        return universite.getProfessors().stream().toList();
    }
}
