package com.habngroup.springboot_kaddem.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
public class Equipe implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idEquipe")
    private Long idEquipe;
    private String nomEquipe;
    @Enumerated(EnumType.STRING)
    private Niveau niveau;
    @ManyToMany(cascade = CascadeType.ALL, mappedBy = "equipes")
    private Set<Etudiant> etudiants;
    @OneToOne(mappedBy = "equipe")
    DetailEquipe detailEquipe;

    public Equipe() {
    }

    public Equipe(String nomEquipe, Niveau niveau) {
        this.nomEquipe = nomEquipe;
        this.niveau = niveau;
    }

    public Equipe(Long idEquipe, String nomEquipe, Niveau niveau) {
        this.idEquipe = idEquipe;
        this.nomEquipe = nomEquipe;
        this.niveau = niveau;
    }

    public Long getIdEquipe() {
        return idEquipe;
    }

    public void setIdEquipe(Long idEquipe) {
        this.idEquipe = idEquipe;
    }

    public String getNomEquipe() {
        return nomEquipe;
    }

    public void setNomEquipe(String nomEquipe) {
        this.nomEquipe = nomEquipe;
    }

    public Niveau getNiveau() {
        return niveau;
    }

    public void setNiveau(Niveau niveau) {
        this.niveau = niveau;
    }

    @Override
    public String toString() {
        return "Equipe{" +
                "idEquipe=" + idEquipe +
                ", nomEquipe='" + nomEquipe + '\'' +
                ", niveau=" + niveau +
                '}';
    }
}
