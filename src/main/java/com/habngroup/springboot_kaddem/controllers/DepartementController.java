package com.habngroup.springboot_kaddem.controllers;

import com.habngroup.springboot_kaddem.entities.Departement;
import com.habngroup.springboot_kaddem.services.IDepartementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class DepartementController {

    private final IDepartementService iDepartementService;

    @Autowired
    public DepartementController(IDepartementService iDepartementService) {
        this.iDepartementService = iDepartementService;
    }

    @GetMapping("/getDepartements")
    @PreAuthorize("hasAnyRole('ROLE_USER','ROLE_ADMIN')")
    List<Departement> getAllDepartements(){
        return iDepartementService.getAllDepartements();
    }

    @GetMapping("/getDepartement/{departementId}")
    @PreAuthorize("hasAnyRole('ROLE_USER','ROLE_ADMIN')")
    Departement getDepartementById(@PathVariable("departementId") Long departementId){
       return  iDepartementService.getDepartementById(departementId);
    }

    @PostMapping("/addDepartement")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    void addDepartement(@RequestBody Departement departement){
        iDepartementService.addDepartement(departement);
    }

    @DeleteMapping("/deleteDepartement")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    void deleteDepartement(@RequestBody Departement departement){
        iDepartementService.deleteDepartement(departement);
    }

    @DeleteMapping("/deleteDepartement/{departementId}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    void deleteDepartement(@PathVariable("departementId") Long departementId){
        iDepartementService.deleteDepartementById(departementId);
    }

    @PutMapping("/updateDepartement/{departementId}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    void updateDepartement(@PathVariable("departementId") Long departementId, @RequestBody Departement departement){
        iDepartementService.updateDepartement(departementId, departement);
    }

}
