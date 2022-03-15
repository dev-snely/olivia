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
public class Etudiant {
    private int Id;
    private String nom;
    private String prenom;
    private int numeroDa;
    private Compte compte;
    private CV cv;
    private LettreMotivation lettre;
    private Occupation occupation;

    public Etudiant() {
    }

    public Etudiant(String nom, String prenom, int numeroDa, Compte compte) {
        this.nom = nom;
        this.prenom = prenom;
        this.numeroDa = numeroDa;
        this.compte = compte;
    }

    public Etudiant(String nom, String prenom, int numeroDa, Compte compte, CV cv, LettreMotivation lettre, Occupation occupation) {
        this.nom = nom;
        this.prenom = prenom;
        this.numeroDa = numeroDa;
        this.compte = compte;
        this.cv = cv;
        this.lettre = lettre;
        this.occupation = occupation;
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

    public Compte getCompte() {
        return compte;
    }

    public CV getCv() {
        return cv;
    }

    public LettreMotivation getLettre() {
        return lettre;
    }

    public Occupation getOccupation() {
        return occupation;
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

    public void setCompte(Compte compte) {
        this.compte = compte;
    }

    public void setCv(CV cv) {
        this.cv = cv;
    }

    public void setLettre(LettreMotivation lettre) {
        this.lettre = lettre;
    }

    public void setOccupation(Occupation occupation) {
        this.occupation = occupation;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 67 * hash + this.Id;
        hash = 67 * hash + Objects.hashCode(this.nom);
        hash = 67 * hash + Objects.hashCode(this.prenom);
        hash = 67 * hash + this.numeroDa;
        hash = 67 * hash + Objects.hashCode(this.compte);
        hash = 67 * hash + Objects.hashCode(this.cv);
        hash = 67 * hash + Objects.hashCode(this.lettre);
        hash = 67 * hash + Objects.hashCode(this.occupation);
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
        final Etudiant other = (Etudiant) obj;
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
        if (!Objects.equals(this.compte, other.compte)) {
            return false;
        }
        if (!Objects.equals(this.cv, other.cv)) {
            return false;
        }
        if (!Objects.equals(this.lettre, other.lettre)) {
            return false;
        }
        if (!Objects.equals(this.occupation, other.occupation)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Etudiant{" + "Id=" + Id + ", nom=" + nom + ", prenom=" + prenom + ", numeroDa=" + numeroDa + ", compte=" + compte + ", cv=" + cv + ", lettre=" + lettre + ", occupation=" + occupation + '}';
    }
   
    
}
