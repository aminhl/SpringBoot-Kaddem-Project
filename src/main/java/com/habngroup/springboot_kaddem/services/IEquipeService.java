package com.habngroup.springboot_kaddem.services;

import com.habngroup.springboot_kaddem.entities.Equipe;
import java.util.List;

public interface IEquipeService {
    void addEquipe(Equipe equipe);
    void updateEquipe(Equipe equipe );
    void deleteEquipe(Equipe equipe);
    void deleteEquipeById(Long id);
    List<Equipe> getAllEquipes();
    Equipe getEquipeById(Long id);
}
