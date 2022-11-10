package com.habngroup.springboot_kaddem.services;

import com.habngroup.springboot_kaddem.entities.DetailEquipe;
import java.util.List;

public interface IDetailEquipeService {
    void addDetailEquipe(DetailEquipe detailEquipe);
    void updateDetailEquipe(DetailEquipe detailEquipe );
    void deleteDetailEquipe(DetailEquipe detailEquipe);
    void deleteDetailEquipeById(Long id);
    List<DetailEquipe> getAllDetailEquipes();
    DetailEquipe getDetailEquipeById(Long contratId);
}
