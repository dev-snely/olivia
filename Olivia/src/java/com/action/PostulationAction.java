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
    public static void supprimerunePostulation(Offre offre, Etudiant etudiant){
         PostulationDaoImpl dao = new PostulationDaoImpl();
         dao.delete(offre, etudiant);
        
    }
    public static List<Postulation> findbyIdOffre(int idOffre){
        PostulationDaoImpl dao = new PostulationDaoImpl();
        Offre off = OffreAction.chercherOffreParId(idOffre);
        List<Postulation> lesPOSt=    dao.findByIdOffre(off);
        return lesPOSt;
    }
    
    public static Postulation findPostulationParIdEtudiantEtIdOffre(int idEtudiant, int idOffre){
        PostulationDaoImpl dao = new PostulationDaoImpl();
        Postulation retour = dao.findByIdEtudiantEtOffre(
                OffreAction.chercherOffreParId(idOffre), 
                EtudiantAction.findEtudiantById(idEtudiant));
        
        return retour;
    }
    
    public static boolean MAJPostulationAcceptation(Postulation p, int idEtudiant, int idOffre){
        
        PostulationDaoImpl dao = new PostulationDaoImpl();
        
        Postulation pos = PostulationAction.findPostulationParIdEtudiantEtIdOffre(idEtudiant, idOffre);
        pos.setAcceptation(p.isAcceptation());
        
        boolean retour = dao.update(pos, OffreAction.chercherOffreParId(idOffre), EtudiantAction.findEtudiantById(idEtudiant));
        
        return retour;
        
    }
        
}
