package com.habngroup.springboot_kaddem.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Professor implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name ="idProfessor")
    private Long idProfessor;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;

    @ManyToOne (cascade = CascadeType.ALL)
    @JsonIgnore
    private Departement department;

    @OneToOne (cascade = CascadeType.ALL)
    private Contrat contrat;

}
