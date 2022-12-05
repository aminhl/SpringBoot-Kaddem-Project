package com.habngroup.springboot_kaddem.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Club implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idClub;
    private String nomClub;
    private String logoClub;
    private String domaine;
}
