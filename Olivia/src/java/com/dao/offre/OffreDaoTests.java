/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dao.offre;

import com.model.entities.Entreprise;
import com.model.entities.Offre;
import java.util.List;

/**
 *
 * @author gabri
 */
public class OffreDaoTests {

    public static void main(String[] args) {
        OffreDaoImpl dao = new OffreDaoImpl();
        List<Offre> lesOffres = null;
        Offre offre = null;
        lesOffres = dao.findAll();
        System.out.println("-------------------------- findAll --------------------------");
        for (Offre uneoffre : lesOffres) {
            System.out.println(uneoffre);

        }
        System.out.println("-------------------------- findById --------------------------");
        offre = dao.findById(1);
        System.out.println(offre);
        System.out.println("-------------------------- Create --------------------------");
        Entreprise ent = new Entreprise();
        ent.setId(2);
        Offre loffre = new Offre("Fron-end develop", "fait du front end", 200);
        dao.create(offre, ent);
        //Affichage de toutes les offres maintenant que c ajouté
        lesOffres = dao.findAll();
        for (Offre uneoffre : lesOffres) {
            System.out.println(uneoffre);

        }
        
        

    }
}
