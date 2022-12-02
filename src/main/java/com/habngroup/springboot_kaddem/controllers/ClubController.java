package com.habngroup.springboot_kaddem.controllers;

import com.habngroup.springboot_kaddem.entities.Club;
import com.habngroup.springboot_kaddem.services.IClubService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class ClubController {
    
    private final IClubService iClubService;
    
    public ClubController(IClubService iClubService) {
        this.iClubService = iClubService;
    }

    @GetMapping("/getClubs")
    List<Club> getAllClubs(){
        return iClubService.getAllClubs();
    }

    @GetMapping("/getClub/{clubId}")
    Club getClubById(@PathVariable("clubId") Long clubId){
        return iClubService.getClubById(clubId);
    }

    @PostMapping("/addClub")
    void addClub(@RequestBody Club club){
        iClubService.addClub(club);
    }

    @DeleteMapping("/deleteClub")
    void deleteClub(@RequestBody Club club){
        iClubService.deleteClub(club);
    }

    @DeleteMapping("/deleteClub/{clubId}")
    void deleteClubById(@PathVariable("clubId") Long clubId){
        iClubService.deleteClubById(clubId);
    }

    @PutMapping("/updateClub/{clubId}")
    void updateClub(@PathVariable("clubId") Long clubId, @RequestBody Club club){
        iClubService.updateClub(clubId, club);
    }
}
