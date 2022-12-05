package com.habngroup.springboot_kaddem.controllers;

import com.habngroup.springboot_kaddem.entities.Departement;
import com.habngroup.springboot_kaddem.entities.Etudiant;
import com.habngroup.springboot_kaddem.entities.Universite;
import com.habngroup.springboot_kaddem.services.IUniversiteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.TreeSet;

@RestController
@CrossOrigin
public class UniversiteController {
    private final IUniversiteService iUniversiteService;

    @Autowired
    public UniversiteController(IUniversiteService iUniversiteService) {
        this.iUniversiteService = iUniversiteService;
    }

    @GetMapping("/getUniversites")
    List<Universite> getAllUniversites(){
        return iUniversiteService.getAllUniversites();
    }

    @GetMapping("/getUniversitiesSorted")
    TreeSet<Universite> getUniversitiesSorted(){
        return iUniversiteService.getUniversitiesSorted();
    }

    @GetMapping("/getUniversite/{universiteId}")
    Universite getUniversiteById(@PathVariable("universiteId") Long universiteId){
        return  iUniversiteService.getUniversiteById(universiteId);
    }

    @PostMapping("/addUniversite")
    void addUniversite(@RequestBody Universite universite){
        iUniversiteService.addUniversite(universite);
    }

    @DeleteMapping("/deleteUniversite")
    void deleteUniversite(@RequestBody Universite universite){
        iUniversiteService.deleteUniversite(universite);
    }

    @DeleteMapping("/deleteUniversite/{universiteId}")
    void deleteUniversite(@PathVariable("universiteId") Long universiteId){
        iUniversiteService.deleteUniversiteById(universiteId);
    }

    @PutMapping("/updateUniversite/{universiteId}")
    void updateUniversite(@PathVariable("universiteId") Long universiteId, @RequestBody Universite universite){
        iUniversiteService.updateUniversite(universiteId, universite);
    }


    @PutMapping("/assignUniversiteToDepartement/{universiteId}/{departementId}")
    public void assignUniversiteToDepartement(@PathVariable("universiteId") Long universiteId,@PathVariable("departementId") Long departementId){
        iUniversiteService.assignUniversiteToDepartement(universiteId, departementId);
    }

    @GetMapping("/retreiveDepartementsByUniversity/{universityId}")
    List<Departement> getDepartementsByUniversite(@PathVariable("universityId") Long universityId){
        return iUniversiteService.retrieveDepartementsByUniversite(universityId);
    }

    @PutMapping("/assignUniversiteToEtudiant/{universiteId}/{etudiantId}")
    public void assignUniversiteToEtudiant(@PathVariable("universiteId") Long universiteId,@PathVariable("etudiantId") Long etudiantId){
        iUniversiteService.assignUniversiteToEtudiant(universiteId,etudiantId);
    }

    @GetMapping("/retrieveEtudiantsByUniversite/{universiteId}")
    List<Etudiant> retrieveEtudiantByUniversite(@PathVariable("universiteId")Long universityId){
        return iUniversiteService.retrieveEtudiantByUniversite(universityId);
    }




}
