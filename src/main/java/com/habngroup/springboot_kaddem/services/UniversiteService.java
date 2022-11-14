package com.habngroup.springboot_kaddem.services;

import com.habngroup.springboot_kaddem.entities.Universite;
import com.habngroup.springboot_kaddem.repositories.UniversiteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class UniversiteService implements IUniversiteService{

    private final UniversiteRepository universiteRepository;

    @Autowired
    public UniversiteService(UniversiteRepository universiteRepository) {
        this.universiteRepository = universiteRepository;
    }


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
}
