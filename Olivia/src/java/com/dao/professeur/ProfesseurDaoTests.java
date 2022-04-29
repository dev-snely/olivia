/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dao.professeur;

import com.dao.compte.CompteDaoImpl;
import com.model.entities.Compte;
import com.model.entities.Professeur;
import java.util.List;

/**
 *
 * @author gabri
 */
public class ProfesseurDaoTests {
      public static void main(String[] args) {
        ProfesseurDaoImpl dao = new ProfesseurDaoImpl();
        CompteDaoImpl daoCompte = new CompteDaoImpl();
        List<Professeur> lesProfs = null;
        Professeur prof = null;
        lesProfs = dao.findAll();
        System.out.println("-------------------------- findAll --------------------------");
         lesProfs = dao.findAll();
        for (Professeur unprof : lesProfs) {
            System.out.println(unprof);
        }
        System.out.println("-------------------------- findById --------------------------");
        prof = dao.findById(1);
        System.out.println(prof);

        System.out.println("-------------------------- Create --------------------------");
        Compte unCompte = new Compte("proqf1234@gmail.com", "342", "prof");
        daoCompte.create(unCompte);

        Professeur leProf = new Professeur("loud", "Mouth", 1234567, daoCompte.findByCourriel("proqf1234@gmail.com"));
        dao.create(leProf);
        //Affichage de toutes les entreprises maintenant que c ajouté
     lesProfs = dao.findAll();
        for (Professeur unprof : lesProfs) {
            System.out.println(unprof);
        }
        System.out.println("-------------------------- Update --------------------------");

        prof = dao.findById(2);
        prof.setNom("Je suis changer");

        dao.update(prof);
        //Affichage de toutes les offres maintenant que c ajouté
        lesProfs = dao.findAll();
        for (Professeur unProf : lesProfs) {
            System.out.println(unProf);
        }
        System.out.println("-------------------------- Delete --------------------------");

        dao.delete(2);
        //Affichage de toutes les offres maintenant que c ajouté
        lesProfs = dao.findAll();
        for (Professeur unProf : lesProfs) {
            System.out.println(unProf);
        }
    }
}
