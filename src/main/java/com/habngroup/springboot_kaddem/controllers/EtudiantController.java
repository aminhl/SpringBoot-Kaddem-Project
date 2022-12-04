package com.habngroup.springboot_kaddem.controllers;

import com.habngroup.springboot_kaddem.entities.Etudiant;
import com.habngroup.springboot_kaddem.services.IEtudiantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200/")
public class EtudiantController {
    private final IEtudiantService iEtudiantService;

    @Autowired
    public EtudiantController(IEtudiantService iEtudiantService) {
        this.iEtudiantService = iEtudiantService;
    }

    @GetMapping("/getEtudiants")
    @PreAuthorize("hasAnyRole('ROLE_USER','ROLE_ADMIN')")
    List<Etudiant> getAllEtudiants(){
        return iEtudiantService.getAllEtudiants();
    }

    @GetMapping("/getEtudiant/{etudiantId}")
    @PreAuthorize("hasAnyRole('ROLE_USER','ROLE_ADMIN')")
    Etudiant getEtudiantById(@PathVariable("etudiantId") Long etudiantId){
        return  iEtudiantService.getEtudiantById(etudiantId);
    }

    @PostMapping("/addEtudiant")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    void addEtudiant(@RequestBody Etudiant etudiant){
        iEtudiantService.addEtudiant(etudiant);
    }

    @DeleteMapping("/deleteEtudiant")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    void deleteEtudiant(@RequestBody Etudiant etudiant){
        iEtudiantService.deleteEtudiant(etudiant);
    }

    @DeleteMapping("/deleteEtudiant/{etudiantId}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    void deleteEtudiant(@PathVariable("etudiantId") Long etudiantId){
        iEtudiantService.deleteEtudiantById(etudiantId);
    }

    @PutMapping("/updateEtudiant/{etudiantId}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    void updateEtudiant(@PathVariable("etudiantId") Long etudiantId, @RequestBody Etudiant etudiant){
        iEtudiantService.updateEtudiant(etudiantId, etudiant);
    }

    @GetMapping("/getEtudiantsByDepartement/{departementId}")
    @PreAuthorize("hasAnyRole('ROLE_USER','ROLE_ADMIN')")
    List<Etudiant> getEtudiantsByDepartement(@PathVariable("departementId") Long departementId){
        return iEtudiantService.getEtudiantsByDepartement(departementId);
    }

    @PutMapping("/assignEtudiantToDepartement/{etudiantId}/{departementId}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public void assignEtudiantToDepartement(@PathVariable("etudiantId") Long etudiantId,
                                            @PathVariable("departementId") Long departementId){
        iEtudiantService.assignEtudiantToDepartement(etudiantId,departementId);
    }

    @PostMapping("/addAndAssignEtudiantToEquipeAndContract/{idContrat}/{idEquipe}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    Etudiant addAndAssignEtudiantToEquipeAndContract(@RequestBody Etudiant etudiant,
                                                     @PathVariable("idContrat") Long idContrat,
                                                     @PathVariable("idEquipe") Long idEquipe
    )
    {
        return iEtudiantService.addAndAssignEtudiantToEquipeAndContract(etudiant,idContrat,idEquipe);
    }

}
