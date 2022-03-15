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
public class LettreMotivation {
    private int Id;
    private String contenu;
    private String titre;

    public LettreMotivation(String contenu, String titre) {
        this.contenu = contenu;
        this.titre = titre;
    }

    public LettreMotivation() {
    }

    public int getId() {
        return Id;
    }

    public String getContenu() {
        return contenu;
    }

    public String getTitre() {
        return titre;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public void setContenu(String contenu) {
        this.contenu = contenu;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + this.Id;
        hash = 53 * hash + Objects.hashCode(this.contenu);
        hash = 53 * hash + Objects.hashCode(this.titre);
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
        final LettreMotivation other = (LettreMotivation) obj;
        if (this.Id != other.Id) {
            return false;
        }
        if (!Objects.equals(this.contenu, other.contenu)) {
            return false;
        }
        if (!Objects.equals(this.titre, other.titre)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "LettreMotivation{" + "Id=" + Id + ", contenu=" + contenu + ", titre=" + titre + '}';
    }
    
}
