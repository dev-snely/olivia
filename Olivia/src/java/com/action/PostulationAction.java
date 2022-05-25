/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.action;

import com.dao.offre.OffreDaoImpl;
import com.dao.postulation.PostulationDaoImpl;
import com.model.entities.Etudiant;
import com.model.entities.Offre;
import com.model.entities.Postulation;
import java.util.List;

/**
 *
 * @author LysAd
 */
public class PostulationAction {
    
    
    public static boolean creérUnePostulation(Postulation post, Offre offre, Etudiant etudiant) {
        boolean retour = false;
        PostulationDaoImpl dao = new PostulationDaoImpl();
        if (dao.create(post, offre, etudiant)) {
            retour = true;
        }
        return retour;
    }
     
    public static List<Postulation> trouverToutLesPostulationsDUneOffre(Offre offre){
        List<Postulation> listePostulations;
        PostulationDaoImpl dao = new PostulationDaoImpl();
        
        listePostulations = dao.findByIdOffre(offre);
        return listePostulations;
    }
    
    public static List<Postulation> trouverToutLesPostulationsDUnEtudiant(Etudiant etudiant){
        List<Postulation> listePostulations;
        PostulationDaoImpl dao = new PostulationDaoImpl();
        
        listePostulations = dao.findByIdEtudiant(etudiant);
        return listePostulations;
    }
    public static void signerUnePostulation(Postulation post, Offre offre, Etudiant etudiant){
        PostulationDaoImpl dao = new PostulationDaoImpl();
        
        dao.update(post, offre, etudiant);
    }
        
}
