package com.habngroup.springboot_kaddem.services;

import com.habngroup.springboot_kaddem.entities.Contrat;
import com.habngroup.springboot_kaddem.repositories.ContratRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Objects;

@Service
@AllArgsConstructor
public class ContratService implements IContratService {
    private final ContratRepository contratRepository;

    @Override
    public void addContrat(Contrat contrat) {
        // TODO checking contrat !existence before inserting
        contratRepository.save(contrat);
    }

    @Override
    public void updateContrat(Long contratId, Contrat contrat) {
       Contrat contratToUpdate = getContratById(contratId);
       if (contratToUpdate != null){
           if (contrat != null && !Objects.equals(contratToUpdate, contrat)){
               contratToUpdate.setMontantContrat(contrat.getMontantContrat());
               contratToUpdate.setDateDebutContrat(contrat.getDateDebutContrat());
               contratToUpdate.setDateFinContrat(contrat.getDateFinContrat());
               contratToUpdate.setArchive(contrat.isArchive());
               contratToUpdate.setSpecialite(contrat.getSpecialite());
               contratRepository.save(contratToUpdate);
           }
       }
       else throw new IllegalStateException("Contrat with id " + contratId + " does not exist");
    }

    @Override
    public void deleteContrat(Contrat contrat) {
        // TODO checking contrat existence before deleting
        contratRepository.delete(contrat);
    }

    @Override
    public void deleteContratById(Long contratId) {
        // TODO checking contrat existence before deleting
        contratRepository.deleteById(contratId);
    }

    @Override
    public List<Contrat> getAllContrats() {
        return contratRepository.findAll();
    }

    @Override
    public Contrat getContratById(Long contratId) {
        return contratRepository.findById(contratId)
                .orElseThrow(() -> new IllegalStateException("Contrat does not exist"));
    }
}
