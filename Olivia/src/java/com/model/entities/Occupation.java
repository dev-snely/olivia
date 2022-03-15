/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.model.entities;

import java.util.Date;
import java.util.Objects;

/**
 *
 * @author gabri
 */
public class Occupation {
    private int id;
    private Date dateDebut;
    private Date datefin;
    private boolean disponible;
    private Offre offre;

    public Occupation() {
    }

    public Occupation(Date dateDebut, Date datefin, Offre offre) {
        this.dateDebut = dateDebut;
        this.datefin = datefin;
        this.offre = offre;
    }

    public int getId() {
        return id;
    }

    public Date getDateDebut() {
        return dateDebut;
    }

    public Date getDatefin() {
        return datefin;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public Offre getOffre() {
        return offre;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setDateDebut(Date dateDebut) {
        this.dateDebut = dateDebut;
    }

    public void setDatefin(Date datefin) {
        this.datefin = datefin;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    public void setOffre(Offre offre) {
        this.offre = offre;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 41 * hash + this.id;
        hash = 41 * hash + Objects.hashCode(this.dateDebut);
        hash = 41 * hash + Objects.hashCode(this.datefin);
        hash = 41 * hash + (this.disponible ? 1 : 0);
        hash = 41 * hash + Objects.hashCode(this.offre);
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
        final Occupation other = (Occupation) obj;
        if (this.id != other.id) {
            return false;
        }
        if (this.disponible != other.disponible) {
            return false;
        }
        if (!Objects.equals(this.dateDebut, other.dateDebut)) {
            return false;
        }
        if (!Objects.equals(this.datefin, other.datefin)) {
            return false;
        }
        if (!Objects.equals(this.offre, other.offre)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Occupation{" + "id=" + id + ", dateDebut=" + dateDebut + ", datefin=" + datefin + ", disponible=" + disponible + ", offre=" + offre + '}';
    }
    
}
