package com.habngroup.springboot_kaddem.services;

import com.habngroup.springboot_kaddem.entities.Universite;
import java.util.List;

public interface IUniversiteService {
    void addUniversite(Universite universite);
    void updateUniversite(Universite universite );
    void deleteUniversite(Universite universite);
    void deleteUniversiteById(Long id);
    List<Universite> getAllUniversites();
    Universite getUniversiteById(Long id);
}
