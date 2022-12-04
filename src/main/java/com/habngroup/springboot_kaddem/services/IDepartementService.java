package com.habngroup.springboot_kaddem.services;

import com.habngroup.springboot_kaddem.entities.Departement;
import com.habngroup.springboot_kaddem.entities.Option;
import com.habngroup.springboot_kaddem.entities.Professor;

import java.util.List;
import java.util.Map;
import java.util.Set;

public interface IDepartementService {
    void addDepartement(Departement departement);
    void updateDepartement(Long departementId, Departement departement);
    void deleteDepartement(Departement departement);
    void deleteDepartementById(Long departementId);
    List<Departement> getAllDepartements();
    Departement getDepartementById(Long departementId);

    Departement affectChefDepartement(String nomDepartement, Professor professor);
    Set<Option> displayDepartementoptionsbynom(String nomDepartement);
}
