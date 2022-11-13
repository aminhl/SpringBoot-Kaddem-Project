package com.habngroup.springboot_kaddem.services;

import com.habngroup.springboot_kaddem.entities.DetailEquipe;
import com.habngroup.springboot_kaddem.repositories.DetailEquipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class DetailEquipeService implements IDetailEquipeService{
    private final DetailEquipeRepository detailEquipeRepository;

    @Autowired
    public DetailEquipeService(DetailEquipeRepository detailEquipeRepository) {
        this.detailEquipeRepository = detailEquipeRepository;
    }


    @Override
    public void addDetailEquipe(DetailEquipe detailEquipe) {
        // TODO checking detailEquipe !existence before inerting
        detailEquipeRepository.save(detailEquipe);
    }

    @Override
    public void updateDetailEquipe(Long detailEquipeId, DetailEquipe detailEquipe) {
        // TODO checking detailEquipe existence before updating
        DetailEquipe detailEquipeTopUpdate = getDetailEquipeById(detailEquipeId);
        if (detailEquipeTopUpdate != null){
            if (detailEquipe != null && !Objects.equals(detailEquipeTopUpdate, detailEquipe)){
                detailEquipeTopUpdate.setSalle(detailEquipe.getSalle());
                detailEquipeTopUpdate.setThematique(detailEquipe.getThematique());
                detailEquipeRepository.save(detailEquipeTopUpdate);
            }
        }
        else throw new IllegalStateException("DetailEquipe with id " + detailEquipeId + " does not exist");
    }

    @Override
    public void deleteDetailEquipe(DetailEquipe detailEquipe) {
        // TODO checking detailEquipe existence before deleting
        detailEquipeRepository.delete(detailEquipe);
    }

    @Override
    public void deleteDetailEquipeById(Long contratId) {
        // TODO checking detailEquipe existence before deleting
        detailEquipeRepository.deleteById(contratId);
    }

    @Override
    public List<DetailEquipe> getAllDetailEquipes() {
        return detailEquipeRepository.findAll();
    }

    @Override
    public DetailEquipe getDetailEquipeById(Long contratId) {
        return detailEquipeRepository.findById(contratId)
                .orElseThrow(() -> new IllegalStateException("DetailEquipe does not exist"));
    }
}
