/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.action;

import com.dao.entreprise.EntrepriseDao;
import com.dao.entreprise.EntrepriseDaoImpl;
import com.model.entities.Compte;
import com.model.entities.Entreprise;

/**
 *
 * @author LysAd
 */
public class EntrepriseAction {

    public static Entreprise findEntrepriseParCourriel(String courriel) {

        //On a besoin de l'id du compte de l'ent
        Compte compteEnt = CompteAction.findByCourriel(courriel);
        int idCompteEnt = compteEnt.getId();

        //On trouve l'entreprise avec le dao
        EntrepriseDao dao = new EntrepriseDaoImpl();
        Entreprise ent = dao.findByIdCompte(idCompteEnt);
        return ent;
    }

    public static Entreprise findEntrepriseParId(int id) {
        EntrepriseDao dao = new EntrepriseDaoImpl();
        Entreprise ent = dao.findById(id);
        return ent;
    }
}
