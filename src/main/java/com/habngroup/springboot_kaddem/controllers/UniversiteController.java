package com.habngroup.springboot_kaddem.controllers;

import com.habngroup.springboot_kaddem.entities.Departement;
import com.habngroup.springboot_kaddem.entities.Universite;
import com.habngroup.springboot_kaddem.services.IUniversiteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@CrossOrigin
public class UniversiteController {
    private final IUniversiteService iUniversiteService;

    @Autowired
    public UniversiteController(IUniversiteService iUniversiteService) {
        this.iUniversiteService = iUniversiteService;
    }

    @GetMapping("/getUniversites")
    @PreAuthorize("hasAnyRole('ROLE_USER','ROLE_ADMIN')")
    List<Universite> getAllUniversites(){
        return iUniversiteService.getAllUniversites();
    }

    @GetMapping("/getUniversite/{universiteId}")
    @PreAuthorize("hasAnyRole('ROLE_USER','ROLE_ADMIN')")
    Universite getUniversiteById(@PathVariable("universiteId") Long universiteId){
        return  iUniversiteService.getUniversiteById(universiteId);
    }

    @PostMapping("/addUniversite")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    void addUniversite(@RequestBody Universite universite){
        iUniversiteService.addUniversite(universite);
    }

    @DeleteMapping("/deleteUniversite")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    void deleteUniversite(@RequestBody Universite universite){
        iUniversiteService.deleteUniversite(universite);
    }

    @DeleteMapping("/deleteUniversite/{universiteId}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    void deleteUniversite(@PathVariable("universiteId") Long universiteId){
        iUniversiteService.deleteUniversiteById(universiteId);
    }

    @PutMapping("/updateUniversite/{universiteId}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    void updateUniversite(@PathVariable("universiteId") Long universiteId, @RequestBody Universite universite){
        iUniversiteService.updateUniversite(universiteId, universite);
    }


    @PutMapping("/assignUniversiteToDepartement/{universiteId}/{departementId}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public void assignUniversiteToDepartement(@PathVariable("universiteId") Long universiteId,@PathVariable("departementId") Long departementId){
        iUniversiteService.assignUniversiteToDepartement(universiteId, departementId);
    }

    @GetMapping("/retreiveDepartementsByUniversity/{universityId}")
    @PreAuthorize("hasAnyRole('ROLE_USER','ROLE_ADMIN')")
    List<Departement> getDepartementsByUniversite(@PathVariable("universityId") Long universityId){
        return iUniversiteService.retrieveDepartementsByUniversite(universityId);
    }
}
