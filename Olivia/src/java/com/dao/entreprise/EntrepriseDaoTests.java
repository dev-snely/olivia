/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dao.entreprise;

import com.dao.compte.CompteDaoImpl;
import com.model.entities.Compte;
import com.model.entities.Entreprise;
import java.util.List;

/**
 *
 * @author gabri
 */
public class EntrepriseDaoTests {

    public static void main(String[] args) {
        EntrepriseDaoImpl dao = new EntrepriseDaoImpl();
        CompteDaoImpl daoCompte = new CompteDaoImpl();
        List<Entreprise> lesEntre = null;
        Entreprise entre = null;
        lesEntre = dao.findAll();
        System.out.println("-------------------------- findAll --------------------------");
        for (Entreprise unENtre : lesEntre) {
            System.out.println(unENtre);
        }
        System.out.println("-------------------------- findById --------------------------");
        entre = dao.findById(1);
        System.out.println(entre);

        System.out.println("-------------------------- Create --------------------------");
        Compte unCompte = new Compte("fds@gmail.com", "4321", "entre");
        daoCompte.create(unCompte);

        Entreprise lentreprise = new Entreprise("L'fsd", "fds", daoCompte.findByCourriel("fds@gmail.com"));
       lentreprise.setNom("unNom");
        dao.create(lentreprise);
        //Affichage de toutes les entreprises maintenant que c ajouté
        lesEntre = dao.findAll();
        for (Entreprise unENtre : lesEntre) {
            System.out.println(unENtre);
        }
        System.out.println("-------------------------- Update --------------------------");

        entre = dao.findById(3);
        entre.setDescription("Je suis changer");

        dao.update(entre);
        //Affichage de toutes les offres maintenant que c ajouté
        lesEntre = dao.findAll();
        for (Entreprise unENtre : lesEntre) {
            System.out.println(unENtre);
        }
        System.out.println("-------------------------- Delete --------------------------");

        dao.delete(3);
        //Affichage de toutes les offres maintenant que c ajouté
        lesEntre = dao.findAll();
        for (Entreprise unENtre : lesEntre) {
            System.out.println(unENtre);
        }

    }
}
