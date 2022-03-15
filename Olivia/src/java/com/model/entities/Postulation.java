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
public class Postulation {
    private Etudiant etudiant;
    private Offre offre;
    private boolean signature;
    private boolean acceptation;

    public Postulation() {
    }

    public Postulation(Etudiant etudiant, Offre offre) {
        this.etudiant = etudiant;
        this.offre = offre;
    }

    public Etudiant getEtudiant() {
        return etudiant;
    }

    public Offre getOffre() {
        return offre;
    }

    public boolean isSignature() {
        return signature;
    }

    public boolean isAcceptation() {
        return acceptation;
    }

    public void setEtudiant(Etudiant etudiant) {
        this.etudiant = etudiant;
    }

    public void setOffre(Offre offre) {
        this.offre = offre;
    }

    public void setSignature(boolean signature) {
        this.signature = signature;
    }

    public void setAcceptation(boolean acceptation) {
        this.acceptation = acceptation;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 43 * hash + Objects.hashCode(this.etudiant);
        hash = 43 * hash + Objects.hashCode(this.offre);
        hash = 43 * hash + (this.signature ? 1 : 0);
        hash = 43 * hash + (this.acceptation ? 1 : 0);
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
        final Postulation other = (Postulation) obj;
        if (this.signature != other.signature) {
            return false;
        }
        if (this.acceptation != other.acceptation) {
            return false;
        }
        if (!Objects.equals(this.etudiant, other.etudiant)) {
            return false;
        }
        if (!Objects.equals(this.offre, other.offre)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Postulation{" + "etudiant=" + etudiant + ", offre=" + offre + ", signature=" + signature + ", acceptation=" + acceptation + '}';
    }
    
}
