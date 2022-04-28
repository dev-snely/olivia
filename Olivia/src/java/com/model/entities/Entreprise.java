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
public class Entreprise {
    private int Id;
    private String nom;
    private String description;
    private String personneReference;
    private ArrayList<Offre> offres;
    private ArrayList<Publicite> publicite;
    private Compte compte;

    public Entreprise() {
    }

    public Entreprise(String description, String personneReference, Compte compte) {
        this.description = description;
        this.personneReference = personneReference;
        this.compte = compte;
    }
    public Entreprise(String nom,String description, String personneReference, Compte compte) {
        this.nom = nom;
        this.description = description;
        this.personneReference = personneReference;
        this.compte = compte;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getId() {
        return Id;
    }

    public String getDescription() {
        return description;
    }

    public String getPersonneReference() {
        return personneReference;
    }

    public ArrayList<Offre> getOffres() {
        return offres;
    }

    public ArrayList<Publicite> getPublicite() {
        return publicite;
    }

    public Compte getCompte() {
        return compte;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPersonneReference(String personneReference) {
        this.personneReference = personneReference;
    }

    public void setOffres(ArrayList<Offre> offres) {
        this.offres = offres;
    }

    public void setPublicite(ArrayList<Publicite> publicite) {
        this.publicite = publicite;
    }

    public void setCompte(Compte compte) {
        this.compte = compte;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 83 * hash + this.Id;
        hash = 83 * hash + Objects.hashCode(this.nom);
        hash = 83 * hash + Objects.hashCode(this.description);
        hash = 83 * hash + Objects.hashCode(this.personneReference);
        hash = 83 * hash + Objects.hashCode(this.offres);
        hash = 83 * hash + Objects.hashCode(this.publicite);
        hash = 83 * hash + Objects.hashCode(this.compte);
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
        final Entreprise other = (Entreprise) obj;
        if (this.Id != other.Id) {
            return false;
        }
        if (!Objects.equals(this.nom, other.nom)) {
            return false;
        }
        if (!Objects.equals(this.description, other.description)) {
            return false;
        }
        if (!Objects.equals(this.personneReference, other.personneReference)) {
            return false;
        }
        if (!Objects.equals(this.offres, other.offres)) {
            return false;
        }
        if (!Objects.equals(this.publicite, other.publicite)) {
            return false;
        }
        if (!Objects.equals(this.compte, other.compte)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entreprise{" + "Id=" + Id + ", nom=" + nom + ", description=" + description + ", personneReference=" + personneReference + ", offres=" + offres + ", publicite=" + publicite + ", compte=" + compte + '}';
    }

  

    
}
