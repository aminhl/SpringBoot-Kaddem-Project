package com.habngroup.springboot_kaddem.services;

import com.habngroup.springboot_kaddem.entities.Departement;
import com.habngroup.springboot_kaddem.repositories.DepartementRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class DepartementService implements IDepartementService{

    private final DepartementRepository departementRepository;

    public DepartementService(DepartementRepository departementRepository) {
        this.departementRepository = departementRepository;
    }

    @Override
    public void addDepartement(Departement departement) {
        // TODO checking departement !existence before inserting
        departementRepository.save(departement);
    }

    @Override
    public void updateDepartement(Long departementId, Departement departement) {
        Departement departementToUpdate = getDepartementById(departementId);
        if (departementToUpdate != null){
            if (departement != null && departement.getNomDepart().length() > 0 && !Objects.equals(departementToUpdate.getNomDepart(), departement.getNomDepart())){
                departementToUpdate.setNomDepart(departement.getNomDepart());
                departementRepository.save(departementToUpdate);
            }
        }
        else throw new IllegalStateException("Departement with id " + departementId + " does not exist");
    }

    @Override
    public void deleteDepartement(Departement departement) {
        // TODO checking departement existence before deleting
        departementRepository.delete(departement);
    }

    @Override
    public void deleteDepartementById(Long departementId) {
        // TODO checking departement existence before deleting
        departementRepository.deleteById(departementId);
    }

    @Override
    public List<Departement> getAllDepartements() {
        return departementRepository.findAll();
    }

    @Override
    public Departement getDepartementById(Long departementId) {
        return departementRepository.findById(departementId)
                .orElseThrow(() -> new IllegalStateException("Departement does not exist"));
    }
}