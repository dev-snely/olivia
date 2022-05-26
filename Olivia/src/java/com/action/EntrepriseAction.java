/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.action;

import com.dao.compte.CompteDaoImpl;
import com.dao.entreprise.EntrepriseDao;
import com.dao.entreprise.EntrepriseDaoImpl;
import com.dao.offre.OffreDaoImpl;
import com.model.entities.Compte;
import com.model.entities.Entreprise;
import com.model.entities.Offre;
import java.util.List;

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

    public static List<Entreprise> findAllEntreprise() {
        EntrepriseDao dao = new EntrepriseDaoImpl();
        List<Entreprise> listeEntreprise = dao.findAll();
        return listeEntreprise;

    }

    public static Entreprise findEntrepriseParOffre(Offre offre) {
        Entreprise retour = null;
        OffreDaoImpl daoOffre = new OffreDaoImpl();
        List<Entreprise> listeEnt = EntrepriseAction.findAllEntreprise();
        for (Entreprise ent : listeEnt) {
            List<Offre> listeOffre = daoOffre.findByIdEntreprise(ent.getId());

            for (Offre uneOffre : listeOffre) {
                if (uneOffre.equals(offre)) {
                    retour = ent;
                }
            }
        }
        return retour;
    }

    public static boolean supprimerEntr(int id) {

        boolean retour = false;
        //Initialisation des DAOs
        CompteDaoImpl compteDao = new CompteDaoImpl();
        EntrepriseDao daoEntr = new EntrepriseDaoImpl();

        //Delete de l'entreprise
        //Delete du compte
        Compte compte = CompteAction.findByEntreprise(daoEntr.findById(id));
        //Verifier si tout a fonctionné
        boolean retourCompte = compteDao.delete(compte.getId());
        boolean retourEntr = daoEntr.delete(id);
        if (retourEntr && retourCompte) {
            retour = true;
        }
        return retour;

    }
}
