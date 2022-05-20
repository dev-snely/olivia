/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.action;

import com.dao.compte.CompteDaoImpl;
import com.dao.entreprise.EntrepriseDaoImpl;
import com.dao.offre.OffreDaoImpl;
import com.model.entities.Compte;
import com.model.entities.Entreprise;
import com.model.entities.Offre;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 *
 * @author LysAd
 */
public class OffreAction {

    public static boolean ajouterOffre(Offre offre, Entreprise ent) {
        boolean retour = false;
        OffreDaoImpl dao = new OffreDaoImpl();
        if (dao.create(offre, ent)) {
            retour = true;
        }
        return retour;
    }

    public static boolean supprimerOffre(Offre offre) {
        boolean retour = false;
        OffreDaoImpl dao = new OffreDaoImpl();
        if (dao.delete(offre.getId())) {
            retour = true;
        }
        return retour;
    }

    public static Offre chercherOffreParId(int id) {
        OffreDaoImpl dao = new OffreDaoImpl();
        Offre offre = dao.findById(id);
        return offre;
    }

    public static boolean modifierOffre(Offre nouvelOffre) {
        boolean retour = false;
        OffreDaoImpl dao = new OffreDaoImpl();
        if (dao.update(nouvelOffre)){
            retour = true;
        }
        return retour;
    }
    
    public static List<Offre> chercherOffresDeLEntrepriseConnecte(HttpServletRequest request){
    
        //Daos nécessaires
        OffreDaoImpl daoOffre = new OffreDaoImpl();
        CompteDaoImpl daoCompte = new CompteDaoImpl();
        EntrepriseDaoImpl daoEntr = new EntrepriseDaoImpl();
        
        //Infos de l'entreprise connecté
        HttpSession session = request.getSession(false);
        String courriel = (String) session.getAttribute("email");
        Compte compteEntre = daoCompte.findByCourriel(courriel);
        Entreprise entreprise = daoEntr.findByIdCompte(compteEntre.getId());
        
        //Recuperation des offres de l'entreprise connecté
        List<Offre> listeOffres = daoOffre.findByIdEntreprise(entreprise.getId());
        
        return listeOffres;
    }
}
