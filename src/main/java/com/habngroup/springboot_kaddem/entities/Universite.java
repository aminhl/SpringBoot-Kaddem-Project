package com.habngroup.springboot_kaddem.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public class Universite implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idUniv")
    private Long idUniv;
    private String nomUniv;

    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL)
    private Set<Departement> departements;
    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL)
    private Set<Etudiant>etudiants;

}
