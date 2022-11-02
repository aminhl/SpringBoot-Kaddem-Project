package com.habngroup.springboot_kaddem.entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class DetailEquipe implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idDetailEquipe")
    private long idDetailEquipe;
    private long salle;
    private String thematique;
    @OneToOne
    Equipe equipe;

    public DetailEquipe() {
    }

    public DetailEquipe(long salle, String thematique) {
        this.salle = salle;
        this.thematique = thematique;
    }

    public DetailEquipe(long idDetailEquipe, long salle, String thematique) {
        this.idDetailEquipe = idDetailEquipe;
        this.salle = salle;
        this.thematique = thematique;
    }

    public long getIdDetailEquipe() {
        return idDetailEquipe;
    }

    public void setIdDetailEquipe(long idDetailEquipe) {
        this.idDetailEquipe = idDetailEquipe;
    }

    public long getSalle() {
        return salle;
    }

    public void setSalle(long salle) {
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
