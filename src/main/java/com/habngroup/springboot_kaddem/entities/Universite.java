package com.habngroup.springboot_kaddem.entities;

import java.io.Serializable;

public class Universite implements Serializable {

   private long idUniv;
   private String nomUniv;

    public Universite() {
    }

    public Universite(String nomUniv) {
        this.nomUniv = nomUniv;
    }

    public Universite(long idUniv, String nomUniv) {
        this.idUniv = idUniv;
        this.nomUniv = nomUniv;
    }

    public long getIdUniv() {
        return idUniv;
    }

    public void setIdUniv(long idUniv) {
        this.idUniv = idUniv;
    }

    public String getNomUniv() {
        return nomUniv;
    }

    public void setNomUniv(String nomUniv) {
        this.nomUniv = nomUniv;
    }

    @Override
    public String toString() {
        return "Universite{" +
                "idUniv=" + idUniv +
                ", nomUniv='" + nomUniv + '\'' +
                '}';
    }
}
