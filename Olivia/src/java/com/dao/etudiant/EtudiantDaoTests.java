/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dao.etudiant;

import com.dao.compte.CompteDaoImpl;
import com.model.entities.Compte;
import com.model.entities.Etudiant;
import java.util.List;

/**
 *
 * @author gabri
 */
public class EtudiantDaoTests {

    public static void main(String[] args) {
        EtudiantDaoImpl dao = new EtudiantDaoImpl();
        CompteDaoImpl daoCompte = new CompteDaoImpl();
        List<Etudiant> lesEtu = null;
        Etudiant etu = null;
        lesEtu = dao.findAll();
        System.out.println("-------------------------- findAll --------------------------");
        for (Etudiant unEtu : lesEtu) {
            System.out.println(unEtu);
        }
        System.out.println("-------------------------- findById --------------------------");
        etu = dao.findById(1);
        System.out.println(etu);

        System.out.println("-------------------------- Create --------------------------");
        Compte unCompte = new Compte("etus1222@gmail.com", "2342", "etu");
        daoCompte.create(unCompte);

        Etudiant letudiant = new Etudiant("Larry", "kid", 1234567, daoCompte.findByCourriel("etus1222@gmail.com"));
        dao.create(letudiant);
        //Affichage de toutes les entreprises maintenant que c ajouté
        lesEtu = dao.findAll();
        for (Etudiant unEtu : lesEtu) {
            System.out.println(unEtu);
        }
        System.out.println("-------------------------- Update --------------------------");

        etu = dao.findById(2);
        etu.setNom("Je suis changer");

        dao.update(etu);
        //Affichage de toutes les offres maintenant que c ajouté
        lesEtu = dao.findAll();
        for (Etudiant unEtu : lesEtu) {
            System.out.println(unEtu);
        }
        System.out.println("-------------------------- Delete --------------------------");

        dao.delete(2);
        //Affichage de toutes les offres maintenant que c ajouté
    for (Etudiant unEtu : lesEtu) {
            System.out.println(unEtu);
        }

    }
}
