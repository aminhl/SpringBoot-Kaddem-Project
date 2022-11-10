package com.habngroup.springboot_kaddem.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;


@Entity
public class Departement implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idDepart")
    private Long idDepart;
    private String nomDepart;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "departement")
    private Set<Etudiant> etudiants;

    public Departement() {
    }

    public Departement(String nomDepart) {
        this.nomDepart = nomDepart;
    }

    public Departement(Long idDepart, String nomDepart) {
        this.idDepart = idDepart;
        this.nomDepart = nomDepart;
    }

    public Long getIdDepart() {
        return idDepart;
    }

    public void setIdDepart(Long idDepart) {
        this.idDepart = idDepart;
    }

    public String getNomDepart() {
        return nomDepart;
    }

    public void setNomDepart(String nomDepart) {
        this.nomDepart = nomDepart;
    }

    @Override
    public String toString() {
        return "Departement{" +
                "idDepart=" + idDepart +
                ", nomDepart='" + nomDepart + '\'' +
                '}';
    }
}
