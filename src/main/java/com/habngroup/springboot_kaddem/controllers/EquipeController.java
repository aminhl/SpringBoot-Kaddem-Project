package com.habngroup.springboot_kaddem.controllers;

import com.habngroup.springboot_kaddem.entities.Equipe;
import com.habngroup.springboot_kaddem.services.IEquipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class EquipeController {

    private final IEquipeService iEquipeService;

    @Autowired
    public EquipeController(IEquipeService iEquipeService) {
        this.iEquipeService = iEquipeService;
    }

    @GetMapping("/getEquipes")
    @PreAuthorize("hasRole('ROLE_USER')")
    List<Equipe> getAllEquipes(){
        return iEquipeService.getAllEquipes();
    }

    @GetMapping("/getEquipe/{equipeId}")
    @PreAuthorize("hasRole('ROLE_USER')")
    Equipe getEquipeById(@PathVariable("equipeId") Long equipeId){
        return  iEquipeService.getEquipeById(equipeId);
    }

    @PostMapping("/addEquipe")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    void addEquipe(@RequestBody Equipe equipe){

        iEquipeService.addEquipe(equipe);
    }

    @DeleteMapping("/deleteEquipe")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    void deleteEquipe(@RequestBody Equipe equipe){
        iEquipeService.deleteEquipe(equipe);
    }

    @DeleteMapping("/deleteEquipe/{equipeId}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    void deleteEquipe(@PathVariable("equipeId") Long equipeId){
        iEquipeService.deleteEquipeById(equipeId);
    }

    @PutMapping("/updateEquipe/{equipeId}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    void updateEquipe(@PathVariable("equipeId") Long equipeId, @RequestBody Equipe equipe){
        iEquipeService.updateEquipe(equipeId, equipe);
    }
}
