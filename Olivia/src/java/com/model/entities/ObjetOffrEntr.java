/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.model.entities;

/**
 *
 * @author LysAd
 */
public class ObjetOffrEntr{
    Offre uneOffre = null;
    Entreprise uneEntreprise = null;

    public ObjetOffrEntr(Offre o, Entreprise e){
        uneOffre = o;
        uneEntreprise = e;
    }

    public Offre getOffre() {
        return uneOffre;
    }

    public void setOffre(Offre uneOffre) {
        this.uneOffre = uneOffre;
    }

    public Entreprise getEntreprise() {
        return uneEntreprise;
    }

    public void setEntreprise(Entreprise uneEntreprise) {
        this.uneEntreprise = uneEntreprise;
    }
    
}
