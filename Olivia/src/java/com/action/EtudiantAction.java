/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.action;

import com.dao.etudiant.EtudiantDao;
import com.dao.etudiant.EtudiantDaoImpl;
import com.model.entities.CV;
import com.model.entities.Compte;
import com.model.entities.Etudiant;
import java.util.List;

/**
 *
 * @author Mahmo
 */
public class EtudiantAction {

    public static List<Etudiant> findAllEtudiant() {
        EtudiantDao dao = new EtudiantDaoImpl();
        List<Etudiant> listeEtu = dao.findAll();
        return listeEtu;
    }

    public static Etudiant findEtudiantById(int id) {
        EtudiantDao dao = new EtudiantDaoImpl();
        Etudiant etu = dao.findById(id);
        return etu;
    }

    public static Etudiant findEtudiantByCourriel(String courriel) {
        EtudiantDao dao = new EtudiantDaoImpl();

        Compte compteEtu = CompteAction.findByCourriel(courriel);
        Etudiant etu = dao.findByIdCompte(compteEtu.getId());

        return etu;
    }

    public static CV getCvEtudiant(int idEtudiant) {
        EtudiantDao dao = new EtudiantDaoImpl();
        Etudiant etu = findEtudiantById(idEtudiant);

        CV unCV = etu.getCv();
        
        return unCV;
        
    }

}
