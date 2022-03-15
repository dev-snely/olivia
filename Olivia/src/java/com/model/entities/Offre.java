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
public class Offre {
    private int Id;
    private String poste;
    private String description;
    private float remuneration;

    public Offre() {
    }

    public Offre(String poste, String description, float remuneration) {
        this.poste = poste;
        this.description = description;
        this.remuneration = remuneration;
    }

    public int getId() {
        return Id;
    }

    public String getPoste() {
        return poste;
    }

    public String getDescription() {
        return description;
    }

    public float getRemuneration() {
        return remuneration;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public void setPoste(String poste) {
        this.poste = poste;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setRemuneration(float remuneration) {
        this.remuneration = remuneration;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 53 * hash + this.Id;
        hash = 53 * hash + Objects.hashCode(this.poste);
        hash = 53 * hash + Objects.hashCode(this.description);
        hash = 53 * hash + Float.floatToIntBits(this.remuneration);
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
        final Offre other = (Offre) obj;
        if (this.Id != other.Id) {
            return false;
        }
        if (Float.floatToIntBits(this.remuneration) != Float.floatToIntBits(other.remuneration)) {
            return false;
        }
        if (!Objects.equals(this.poste, other.poste)) {
            return false;
        }
        if (!Objects.equals(this.description, other.description)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Offre{" + "Id=" + Id + ", poste=" + poste + ", description=" + description + ", remuneration=" + remuneration + '}';
    }
    
}
