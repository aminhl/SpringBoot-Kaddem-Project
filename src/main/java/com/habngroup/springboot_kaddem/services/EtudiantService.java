package com.habngroup.springboot_kaddem.services;

import com.habngroup.springboot_kaddem.entities.*;
import com.habngroup.springboot_kaddem.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.TreeSet;
import java.util.stream.Collectors;

@Service
public class EtudiantService implements IEtudiantService {
    private final EtudiantRepository etudiantRepository;
    private final EquipeRepository equipeRepository;
    private final ContratRepository contratRepository;
    private final DepartementRepository departementRepository;
    private final ClubRepository clubRepository;

    @Autowired
    public EtudiantService(EtudiantRepository etudiantRepository, EquipeRepository equipeRepository, ContratRepository contratRepository, DepartementRepository departementRepository, ClubRepository clubRepository) {
        this.etudiantRepository = etudiantRepository;
        this.equipeRepository = equipeRepository;
        this.contratRepository = contratRepository;
        this.departementRepository = departementRepository;
        this.clubRepository = clubRepository;
    }

    @Override
    public void addEtudiant(Etudiant etudiant) {
        // TODO checking etudiant !existence before inserting
        etudiantRepository.save(etudiant);
    }

    @Override
    public void updateEtudiant(Long etudiantId, Etudiant etudiant) {
        // TODO checking etudiant existence before updating
        Etudiant etudiantToUpdate = getEtudiantById(etudiantId);
        if (etudiantToUpdate != null){
            if (etudiant != null && !Objects.equals(etudiantToUpdate, etudiant)){
                etudiantToUpdate.setNomE(etudiant.getNomE());
                etudiantToUpdate.setPrenomE(etudiant.getPrenomE());
                etudiantToUpdate.setOption(etudiant.getOption());
                etudiantRepository.save(etudiant);
            }
        }
        else throw new IllegalStateException("Etudiant with id " + etudiantId + " does not exist");

    }

    @Override
    public void deleteEtudiant(Etudiant etudiant) {
        // TODO checking etudiant existence before deleting
        etudiantRepository.delete(etudiant);
    }

    @Override
    public void deleteEtudiantById(Long etudiantId) {
        // TODO checking etudiant existence before deleting
        etudiantRepository.deleteById(etudiantId);
    }

    @Override
    public List<Etudiant> getAllEtudiants() {
        return etudiantRepository.findAll();
    }

    @Override
    public Etudiant getEtudiantById(Long etudiantId) {
        return etudiantRepository.findById(etudiantId)
                .orElseThrow(() -> new IllegalStateException("Etudiant with id " + etudiantId + " does not exist"));
    }

    @Override
    public void assignEtudiantToDepartement(Long etudiantId, Long departementId) {

        Etudiant etudiant = etudiantRepository.findById(etudiantId).orElse(null);
        Departement departement = departementRepository.findById(departementId).orElse(null);
        etudiant.setDepartement(departement);
        etudiantRepository.save(etudiant);

    }

    @Override
    public Etudiant addAndAssignEtudiantToEquipeAndContract(Etudiant etudiant, Long idContrat, Long idEquipe) {
        Contrat contrat = contratRepository.findById(idContrat).orElse(null);
        Equipe equipe = equipeRepository.findById(idEquipe).orElse(null);

        etudiant.getEquipes().add(equipe);
        contrat.setEtudiant(etudiant);
      return   etudiantRepository.save(etudiant);


    }

    @Override
    public List<Etudiant> getEtudiantsByDepartement(Long idDepartement) {
        Departement departement = departementRepository.findById(idDepartement)
                .orElseThrow(() -> new IllegalStateException("Departement with id " + idDepartement +
                        " does not exist"));
        return etudiantRepository.findEtudiantByDepartement(departement);
    }

    @Override
    public Departement ShowDepartementEtudiantDetails(Long departementId) {
        return departementRepository.findById(departementId).
                orElseThrow(() -> new IllegalStateException("Departement with id " + departementId + " does not exist"));
    }

    @Override
    public List<Contrat> getAllContratByIdEtudiant(Long idEtudiant) {
            Etudiant etudiant = etudiantRepository.findById(idEtudiant).orElseThrow(() -> new IllegalStateException("Etudiant with id " + idEtudiant +
                    " does not exist"));
            return contratRepository.findContratByEtudiant(etudiant);

    }
    @Override
    public void AssignEtudiantToClub(Long etudiantId, Long clubId) {
        Etudiant etudiant = etudiantRepository.findById(etudiantId).orElse(null);
        Club club = clubRepository.findById(clubId).orElse(null);
        etudiant.setClub(club);
        etudiantRepository.save(etudiant);
    }

    @Override
    @Scheduled(cron = "* * */13 * * *")
    public String retrieveAndUpdateStatusContratbyEtudiant() throws ParseException {
      /*  LocalDateTime date = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        String format = date.plusDays(15).format(formatter);
        Date date1=new SimpleDateFormat("dd/MM/yyyy").parse(format);
        List<Contrat> contratList =contratRepository.findContratsByDateFinContrat(date1);
        System.out.println(contratList);*/
        return null;
    }

    @Override
    public List<Etudiant> findetudiantByNameOrLastName(String nomE, String prenomE) {

        return etudiantRepository.findByNomEOrPrenomE(nomE,prenomE);
    }

    @Override
    public List<Etudiant> ShowStudentbyOption(Option option) {
        return etudiantRepository.findByOption(option);
    }

    @Override
    public List<Etudiant> ShowStudentbyNomClub(String nomClub) {
        return etudiantRepository.findByClubNomClub(nomClub);
    }

    @Override
    public TreeSet<Etudiant> TriEtudiantbyName() {
        List<Etudiant> etudiantList = etudiantRepository.findAll();
        TreeSet<Etudiant> collect = etudiantList.stream().collect(Collectors.toCollection(TreeSet::new));
        return collect;
    }

}
