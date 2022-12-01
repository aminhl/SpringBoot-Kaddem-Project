package com.habngroup.springboot_kaddem.repositories;

import com.habngroup.springboot_kaddem.DTO.ArchivePercentType;
import com.habngroup.springboot_kaddem.entities.Contrat;
import com.habngroup.springboot_kaddem.entities.Departement;
import com.habngroup.springboot_kaddem.entities.Etudiant;
import com.habngroup.springboot_kaddem.entities.Specialite;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface ContratRepository extends JpaRepository<Contrat, Long> {
    @Query(value = "select new com.habngroup.springboot_kaddem.DTO.ArchivePercentType" +
            "(count(*)/(Select COUNT(*) from Contrat) * 100, archive) from Contrat GROUP BY archive")
    public List <ArchivePercentType> getPercentageGroupByArchiveStatus();

    @Query("select c from Contrat c where c.etudiant = ?1")
    List<Contrat> findContratByEtudiant(Etudiant etudiant);

    List<Contrat> findAllByDateDebutContratOrDateFinContratOrSpecialiteOrArchiveOrMontantContrat(Date dateDebut, Date dateFin, Specialite specialite,
                                                                                                 boolean archive, Long montantContrat);
}
