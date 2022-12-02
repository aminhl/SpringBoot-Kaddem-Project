package com.habngroup.springboot_kaddem.services;

import com.habngroup.springboot_kaddem.entities.Club;
import com.habngroup.springboot_kaddem.repositories.ClubRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ClubService implements IClubService{

    private final ClubRepository clubRepository;

    @Override
    public void addClub(Club club) {
        // TODO checking club !existence before insert
        this.clubRepository.save(club);
    }

    @Override
    public void updateClub(Long clubId, Club club) {
        // TODO checking club existence before update
        this.clubRepository.save(club);
    }

    @Override
    public void deleteClub(Club club) {
        // TODO checking club existence before delete
        this.clubRepository.delete(club);
    }

    @Override
    public void deleteClubById(Long clubId) {
        // TODO checking club existence before delete
        this.clubRepository.deleteById(clubId);
    }

    @Override
    public List<Club> getAllClubs() {
        return this.clubRepository.findAll();
    }

    @Override
    public Club getClubById(Long clubId) {
        return this.clubRepository.findById(clubId)
                .orElse(null);
    }
}
