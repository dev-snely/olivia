/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dao.lettreMotivation;

import com.dao.compte.CompteDaoImpl;
import com.dao.etudiant.EtudiantDaoImpl;
import com.model.entities.Etudiant;
import com.model.entities.LettreMotivation;
import java.util.List;

/**
 *
 * @author gabri
 */
public class LettreMotivationDaoTests {
          public static void main(String[] args) {
        EtudiantDaoImpl daoEtu = new EtudiantDaoImpl();
        CompteDaoImpl daoCompte=new CompteDaoImpl();
        LettreMotivationDaoImpl dao = new LettreMotivationDaoImpl();
        List<LettreMotivation> lesLettre = null;
        LettreMotivation lettre = null;
        
        System.out.println("-------------------------- findAll --------------------------");
        lesLettre= dao.findAll();
        for ( LettreMotivation lettre1 : lesLettre) {
            System.out.println(lettre1);

        }
        System.out.println("-------------------------- findById --------------------------");
        lettre = dao.findById(1);
        System.out.println(lettre);
        System.out.println("-------------------------- Create --------------------------");

        Etudiant letudiant = daoEtu.findById(2);
        
        LettreMotivation uneLettre=new LettreMotivation("lettre","lettre");
        dao.create(uneLettre,letudiant);
 
        //Affichage de toutes les offres maintenant que c ajouté
          lesLettre= dao.findAll();
        for ( LettreMotivation lettre1 : lesLettre) {
            System.out.println(lettre1);

        }
                  System.out.println("-------------------------- Update --------------------------");
       
         LettreMotivation cv2=dao.findById(2);
         cv2.setContenu("Nouveau Contenu");
 
        dao.update(cv2);
        //Affichage de toutes les offres maintenant que c ajouté
        lesLettre= dao.findAll();
        for ( LettreMotivation lettre1 : lesLettre) {
            System.out.println(lettre1);

        }
         System.out.println("-------------------------- Delete --------------------------");
       
   
        dao.delete(2);
        //Affichage de toutes les offres maintenant que c ajouté
            lesLettre= dao.findAll();
        for ( LettreMotivation lettre1 : lesLettre) {
            System.out.println(lettre1);

        }

        

    }  
}
