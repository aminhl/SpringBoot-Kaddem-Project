package com.habngroup.springboot_kaddem.controllers;

import com.habngroup.springboot_kaddem.DTO.ArchivePercentType;
import com.habngroup.springboot_kaddem.entities.Contrat;
import com.habngroup.springboot_kaddem.services.IContratService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class ContratController {

    private final IContratService iContratService;

    @Autowired
    public ContratController(IContratService iContratService) {
        this.iContratService = iContratService;
    }

    @GetMapping("/getContrats")
    @PreAuthorize("hasRole('ROLE_USER')")
    List<Contrat> getAllContrats(){
        return iContratService.getAllContrats();
    }

    @GetMapping("/getContrat/{contratId}")
    @PreAuthorize("hasRole('ROLE_USER')")
    @PreAuthorize("hasRole('ROLE_USER')")
    Contrat getContratById(@PathVariable("contratId") Long contratId){
        return iContratService.getContratById(contratId);
    }

    @PostMapping("/addContrat")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    void addContrat(@RequestBody Contrat contrat){
        iContratService.addContrat(contrat);
    }

    @DeleteMapping("/deleteContrat")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    void deleteContrat(@RequestBody Contrat contrat){
        iContratService.deleteContrat(contrat);
    }

    @DeleteMapping("/deleteContrat/{contratId}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    void deleteContratById(@PathVariable("contratId") Long contratId){
        iContratService.deleteContratById(contratId);
    }

    @PutMapping("/updateContrat/{contratId}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    void updateContrat(@PathVariable("contratId") Long contratId, @RequestBody Contrat contrat){
        iContratService.updateContrat(contratId, contrat);
    }

    @PutMapping("/affectContratToEtudiant/{nomEtudiant}/{prenomEtudiant}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    Contrat affectContratToEtudiant(@RequestBody Contrat contrat,
                                    @PathVariable("nomEtudiant") String nomEtudiant,
                                    @PathVariable("prenomEtudiant") String prenomEtudiant
    ){
        return iContratService.affectContratToEtudiant(contrat, nomEtudiant, prenomEtudiant);
    }

    @GetMapping("/vData/percentArchiveStatus")
    @PreAuthorize("hasRole('ROLE_USER')")
    public List<ArchivePercentType> getPercentageGroupByArchiveStatus(){
        return iContratService.getContratPercentByArchiveStatus();
    }

}

