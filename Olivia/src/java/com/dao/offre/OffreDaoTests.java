/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dao.offre;

import com.dao.entreprise.EntrepriseDaoImpl;
import com.model.entities.Entreprise;
import com.model.entities.Offre;
import java.util.List;

/**
 *
 * @author gabri
 */
public class OffreDaoTests {

    public static void main(String[] args) {
        EntrepriseDaoImpl daoEnt = new EntrepriseDaoImpl();
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
        Entreprise ent =daoEnt.findById(1);
   
        Offre loffre = new Offre("Fron-end develop", "fait du front end", 200);
        dao.create(offre, ent);
        //Affichage de toutes les offres maintenant que c ajouté
        lesOffres = dao.findAll();
        for (Offre uneoffre : lesOffres) {
            System.out.println(uneoffre);

        }
         System.out.println("-------------------------- Delete --------------------------");
       
   
        dao.delete(4);
        //Affichage de toutes les offres maintenant que c ajouté
        lesOffres = dao.findAll();
        for (Offre uneoffre : lesOffres) {
            System.out.println(uneoffre);

        }
         System.out.println("-------------------------- Update --------------------------");
       
         Offre uneOffre=dao.findById(1);
         uneOffre.setDescription("Nouvelle Description");
          uneOffre.setPoste("Nouveau Poste");
          uneOffre.setRemuneration(100.55f);
        dao.update(uneOffre);
        //Affichage de toutes les offres maintenant que c ajouté
        lesOffres = dao.findAll();
        for (Offre uneoffre : lesOffres) {
            System.out.println(uneoffre);

        }
        

    }
}
