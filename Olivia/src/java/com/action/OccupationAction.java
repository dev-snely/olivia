/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.action;

import com.model.entities.Etudiant;
import com.model.entities.Occupation;

/**
 *
 * @author LysAd
 */
public class OccupationAction {
    public static Occupation trouverOccupationDeEtudiantConnecte(Etudiant etudiantConnecte){
        
        Etudiant etudiant = EtudiantAction.findEtudiantByCourriel(etudiantConnecte.getCompte().getCourriel());
        Occupation OccupationDeLEtudiantConnecte = etudiant.getOccupation();
        return OccupationDeLEtudiantConnecte;
    }
}