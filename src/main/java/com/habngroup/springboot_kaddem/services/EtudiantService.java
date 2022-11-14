package com.habngroup.springboot_kaddem.services;

import com.habngroup.springboot_kaddem.entities.Contrat;
import com.habngroup.springboot_kaddem.entities.Departement;
import com.habngroup.springboot_kaddem.entities.Equipe;
import com.habngroup.springboot_kaddem.entities.Etudiant;
import com.habngroup.springboot_kaddem.repositories.ContratRepository;
import com.habngroup.springboot_kaddem.repositories.DepartementRepository;
import com.habngroup.springboot_kaddem.repositories.EquipeRepository;
import com.habngroup.springboot_kaddem.repositories.EtudiantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class EtudiantService implements IEtudiantService {
    private final EtudiantRepository etudiantRepository;
    private final EquipeRepository equipeRepository;
    private final ContratRepository contratRepository;
    private final DepartementRepository departementRepository;

    @Autowired
    public EtudiantService(EtudiantRepository etudiantRepository, EquipeRepository equipeRepository, ContratRepository contratRepository, DepartementRepository departementRepository) {
        this.etudiantRepository = etudiantRepository;
        this.equipeRepository = equipeRepository;
        this.contratRepository = contratRepository;
        this.departementRepository = departementRepository;
    }

    @Override
    public void addEtudiant(Etudiant etudiant) {
        // TODO checking etudiant !existence before inserting
        etudiantRepository.save(etudiant);
    }

    @Override
    public void updateEtudiant(Long etudiantId, Etudiant etudiant) {
        // TODO checking etudiant existence before updating
        Etudiant etudiantToUpdate = getEtudiantById(etudiantId);
        if (etudiantToUpdate != null){
            if (etudiant != null && !Objects.equals(etudiantToUpdate, etudiant)){
                etudiantToUpdate.setNomE(etudiant.getNomE());
                etudiantToUpdate.setPrenomE(etudiant.getPrenomE());
                etudiantToUpdate.setOption(etudiant.getOption());
                etudiantRepository.save(etudiant);
            }
        }
        else throw new IllegalStateException("Etudiant with id " + etudiantId + " does not exist");

    }

    @Override
    public void deleteEtudiant(Etudiant etudiant) {
        // TODO checking etudiant existence before deleting
        etudiantRepository.delete(etudiant);
    }

    @Override
    public void deleteEtudiantById(Long etudiantId) {
        // TODO checking etudiant existence before deleting
        etudiantRepository.deleteById(etudiantId);
    }

    @Override
    public List<Etudiant> getAllEtudiants() {
        return etudiantRepository.findAll();
    }

    @Override
    public Etudiant getEtudiantById(Long etudiantId) {
        return etudiantRepository.findById(etudiantId)
                .orElseThrow(() -> new IllegalStateException("Etudiant with id " + etudiantId + " does not exist"));
    }

    @Override
    public Etudiant addAndAssignEtudiantToEquipeAndContract(Etudiant etudiant, Long idContrat, Long idEquipe) {
        Optional<Contrat> contratOptional = contratRepository.findById(idContrat);
        Optional<Equipe> equipeOptional = equipeRepository.findById(idEquipe);
        if (contratOptional.isPresent() && equipeOptional.isPresent()){
            etudiant.getContrats().add(contratOptional.get());
            etudiant.getEquipes().add(equipeOptional.get());
            return etudiantRepository.save(etudiant);
        }
        else throw new IllegalStateException("Contrat with id " + idContrat + " or equipe with id " + idEquipe
                + " does not exist");
    }

    @Override
    public Contrat affectContratToEtudiant(Contrat contrat, String nomEtudiant, String prenomEtudiant) {
        Etudiant etudiant = etudiantRepository.findEtudiantByNomEAndPrenomE(nomEtudiant, prenomEtudiant)
                .orElseThrow(() -> new IllegalStateException("Etudiant with nom " + nomEtudiant + " and prenom "
                        + prenomEtudiant + " does not exist"));
        if (contrat != null && etudiant.getContrats().size() < 6){
            etudiant.getContrats().add(contrat);
            etudiantRepository.save(etudiant);
            return contrat;
        }
        throw new IllegalStateException("Contrat does not exist or Etudiant has already 5 Contrats ");
    }

    @Override
    public List<Etudiant> getEtudiantsByDepartement(Long idDepartement) {
        Departement departement = departementRepository.findById(idDepartement)
                .orElseThrow(() -> new IllegalStateException("Departement with id " + idDepartement +
                        " does not exist"));
        return etudiantRepository.findEtudiantByDepartement(departement);
    }



}
