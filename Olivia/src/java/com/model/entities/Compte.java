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
public class Compte {
    private int Id;
    private String courriel;
    private String password;
    private String typeCompte;
    
    public Compte() {
    }

    public Compte(String courriel, String password, String typeCompte) {
        this.courriel = courriel;
        this.password = password;
        this.typeCompte = typeCompte;
    }

    public int getId() {
        return Id;
    }

    public String getCourriel() {
        return courriel;
    }

    public String getPassword() {
        return password;
    }

    public String getTypeCompte() {
        return typeCompte;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public void setCourriel(String courriel) {
        this.courriel = courriel;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setTypeCompte(String typeCompte) {
        this.typeCompte = typeCompte;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + this.Id;
        hash = 89 * hash + Objects.hashCode(this.courriel);
        hash = 89 * hash + Objects.hashCode(this.password);
        hash = 89 * hash + Objects.hashCode(this.typeCompte);
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
        final Compte other = (Compte) obj;
        if (this.Id != other.Id) {
            return false;
        }
        if (!Objects.equals(this.courriel, other.courriel)) {
            return false;
        }
        if (!Objects.equals(this.password, other.password)) {
            return false;
        }
        if (!Objects.equals(this.typeCompte, other.typeCompte)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Compte{" + "Id=" + Id + ", courriel=" + courriel + ", typeCompte=" + typeCompte + '}';
    }
    
}
