package com.habngroup.springboot_kaddem.repositories;

import com.habngroup.springboot_kaddem.DTO.ArchivePercentType;
import com.habngroup.springboot_kaddem.entities.Contrat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;
import java.util.List;

public interface ContratRepository extends JpaRepository<Contrat, Long> {
    @Query(value = "select new com.habngroup.springboot_kaddem.DTO.ArchivePercentType" +
            "(count(*)/(Select COUNT(*) from Contrat) * 100, archive) from Contrat GROUP BY archive")
    public List <ArchivePercentType> getPercentageGroupByArchiveStatus();

    List<Contrat> findContratsByDateFinContrat(Date date);
}
