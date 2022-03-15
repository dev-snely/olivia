/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.model.entities;

import java.util.Objects;

/**
 *
 * @author gabri
 */
public class Admin {
    private int Id;
    private String nom;
    private String prenom;
    private Compte compte;

    public Admin() {
    }

    public Admin(String nom, String prenom) {
        this.nom = nom;
        this.prenom = prenom;
    }

    public Admin(String nom, String prenom, Compte compte) {
        this.nom = nom;
        this.prenom = prenom;
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

    public void setCompte(Compte compte) {
        this.compte = compte;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 41 * hash + this.Id;
        hash = 41 * hash + Objects.hashCode(this.nom);
        hash = 41 * hash + Objects.hashCode(this.prenom);
        hash = 41 * hash + Objects.hashCode(this.compte);
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
        final Admin other = (Admin) obj;
        if (this.Id != other.Id) {
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
        return true;
    }

    @Override
    public String toString() {
        return "Admin{" + "Id=" + Id + ", nom=" + nom + ", prenom=" + prenom + ", compte=" + compte + '}';
    }
    
}
