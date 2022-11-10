package com.habngroup.springboot_kaddem.entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class DetailEquipe implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idDetailEquipe")
    private Long idDetailEquipe;
    private Long salle;
    private String thematique;
    @OneToOne
    Equipe equipe;

    public DetailEquipe() {
    }

    public DetailEquipe(Long salle, String thematique) {
        this.salle = salle;
        this.thematique = thematique;
    }

    public DetailEquipe(Long idDetailEquipe, Long salle, String thematique) {
        this.idDetailEquipe = idDetailEquipe;
        this.salle = salle;
        this.thematique = thematique;
    }

    public Long getIdDetailEquipe() {
        return idDetailEquipe;
    }

    public void setIdDetailEquipe(Long idDetailEquipe) {
        this.idDetailEquipe = idDetailEquipe;
    }

    public Long getSalle() {
        return salle;
    }

    public void setSalle(Long salle) {
        this.salle = salle;
    }

    public String getThematique() {
        return thematique;
    }

    public void setThematique(String thematique) {
        this.thematique = thematique;
    }

    @Override
    public String toString() {
        return "Equipe{" +
                "idDetailEquipe=" + idDetailEquipe +
                ", salle=" + salle +
                ", thematique='" + thematique + '\'' +
                '}';
    }
}
