/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.model.entities;

import java.util.ArrayList;
import java.util.Objects;


/**
 *
 * @author gabri
 */
public class Professeur {
     private int Id;
    private String nom;
    private String prenom;
    private int numeroDa;
    private ArrayList<Etudiant> listeEtudiant;
    private Compte compte;

    public Professeur() {
    }
    public Professeur(String nom, String prenom, int numeroDa) {
        this.nom = nom;
        this.prenom = prenom;
        this.numeroDa = numeroDa;
    }

    public Professeur(String nom, String prenom, int numeroDa, Compte compte) {
        this.nom = nom;
        this.prenom = prenom;
        this.numeroDa = numeroDa;
        this.compte = compte;
    }

    public int getId() {
        return Id;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public int getNumeroDa() {
        return numeroDa;
    }

    public ArrayList<Etudiant> getListeEtudiant() {
        return listeEtudiant;
    }

    public Compte getCompte() {
        return compte;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setNumeroDa(int numeroDa) {
        this.numeroDa = numeroDa;
    }

    public void setListeEtudiant(ArrayList<Etudiant> listeEtudiant) {
        this.listeEtudiant = listeEtudiant;
    }

    public void setCompte(Compte compte) {
        this.compte = compte;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + this.Id;
        hash = 29 * hash + Objects.hashCode(this.nom);
        hash = 29 * hash + Objects.hashCode(this.prenom);
        hash = 29 * hash + this.numeroDa;
        hash = 29 * hash + Objects.hashCode(this.listeEtudiant);
        hash = 29 * hash + Objects.hashCode(this.compte);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Professeur other = (Professeur) obj;
        if (this.Id != other.Id) {
            return false;
        }
        if (this.numeroDa != other.numeroDa) {
            return false;
        }
        if (!Objects.equals(this.nom, other.nom)) {
            return false;
        }
        if (!Objects.equals(this.prenom, other.prenom)) {
            return false;
        }
        if (!Objects.equals(this.listeEtudiant, other.listeEtudiant)) {
            return false;
        }
        if (!Objects.equals(this.compte, other.compte)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Professeur{" + "Id=" + Id + ", nom=" + nom + ", prenom=" + prenom + ", numeroDa=" + numeroDa + ", listeEtudiant=" + listeEtudiant + ", compte=" + compte + '}';
    }


}
