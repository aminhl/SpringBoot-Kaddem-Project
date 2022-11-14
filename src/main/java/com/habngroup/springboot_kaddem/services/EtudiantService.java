package com.habngroup.springboot_kaddem.services;

import com.habngroup.springboot_kaddem.entities.Etudiant;
import com.habngroup.springboot_kaddem.repositories.ContratRepository;
import com.habngroup.springboot_kaddem.repositories.DepartementRepository;
import com.habngroup.springboot_kaddem.repositories.EquipeRepository;
import com.habngroup.springboot_kaddem.repositories.EtudiantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

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

}
