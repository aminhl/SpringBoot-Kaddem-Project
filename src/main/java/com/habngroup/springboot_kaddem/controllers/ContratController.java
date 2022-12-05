package com.habngroup.springboot_kaddem.controllers;

import com.habngroup.springboot_kaddem.DTO.ArchivePercentType;
import com.habngroup.springboot_kaddem.entities.Contrat;
import com.habngroup.springboot_kaddem.entities.Specialite;
import com.habngroup.springboot_kaddem.services.IContratService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
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
    List<Contrat> getAllContrats(){
        return iContratService.getAllContrats();
    }

    @GetMapping("/getContrat/{contratId}")
    Contrat getContratById(@PathVariable("contratId") Long contratId){
        return iContratService.getContratById(contratId);
    }

    @PostMapping("/addContrat")
    void addContrat(@RequestBody Contrat contrat){
        iContratService.addContrat(contrat);
    }

    @DeleteMapping("/deleteContrat")
    void deleteContrat(@RequestBody Contrat contrat){
        iContratService.deleteContrat(contrat);
    }

    @DeleteMapping("/deleteContrat/{contratId}")
    void deleteContratById(@PathVariable("contratId") Long contratId){
        iContratService.deleteContratById(contratId);
    }

    @PutMapping("/updateContrat/{contratId}")
    void updateContrat(@PathVariable("contratId") Long contratId, @RequestBody Contrat contrat){
        iContratService.updateContrat(contratId, contrat);
    }

    @PutMapping("/affectContratToEtudiant/{nomEtudiant}/{prenomEtudiant}")
    Contrat affectContratToEtudiant(@RequestBody Contrat contrat,
                                    @PathVariable("nomEtudiant") String nomEtudiant,
                                    @PathVariable("prenomEtudiant") String prenomEtudiant
    ){
        return iContratService.affectContratToEtudiant(contrat, nomEtudiant, prenomEtudiant);
    }

    @GetMapping("/vData/percentArchiveStatus")
    public List<ArchivePercentType> getPercentageGroupByArchiveStatus(){
        return iContratService.getContratPercentByArchiveStatus();
    }

    @GetMapping("/searchContratByAnyCriteria/")
    List<Contrat> findByAnyParam(
            @RequestParam(required = false) @DateTimeFormat(pattern = "yyyy-MM-dd") Date dateDebut,
            @RequestParam(required = false) @DateTimeFormat(pattern = "yyyy-MM-dd") Date dateFin,
            @RequestParam(required = false) Specialite specialite,
            @RequestParam(required = false) boolean archive,
            @RequestParam(required = false) Long montant
            ){
        return iContratService.findAllByDateDebutContratOrDateFinContratOrSpecialiteOrArchiveOrMontantContrat(dateDebut, dateFin, specialite, archive, montant);
    }

    @GetMapping("/getContratsBetween/{dateDebut}/{dateFin}")
    List<Contrat> getContratsBetween(@PathVariable("dateDebut") @DateTimeFormat(pattern = "yyyy-MM-dd") Date dateDebut,
                                     @PathVariable("dateFin") @DateTimeFormat(pattern = "yyyy-MM-dd") Date dateFin){
        return iContratService.getContratsBetween(dateDebut, dateFin);
    }

    @GetMapping("/getNbContratsValides/{dateDebut}/{dateFin}")
    Long getNbContratsValides(@PathVariable("dateDebut") @DateTimeFormat(pattern = "yyyy-MM-dd") Date dateDebut,
                              @PathVariable("dateFin") @DateTimeFormat(pattern = "yyyy-MM-dd") Date dateFin){
        return iContratService.nbContratsValides(dateDebut, dateFin);
    }

    @GetMapping("getRandomIdContrat")
    Long getRandomIdContrat(){
        return iContratService.getRandomIdContrat();
    }

    @PutMapping("/contratReduction")
    void reductionOnRandomContrat(){
       iContratService.reductionOnRandomContrat();
    }
}

