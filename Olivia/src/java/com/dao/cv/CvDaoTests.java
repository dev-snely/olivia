/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dao.cv;

import com.dao.compte.CompteDaoImpl;
import com.dao.etudiant.EtudiantDaoImpl;
import com.model.entities.CV;
import com.model.entities.Compte;
import com.model.entities.Etudiant;
import java.util.List;

/**
 *
 * @author gabri
 */
public class CvDaoTests {
        public static void main(String[] args) {
        EtudiantDaoImpl daoEtu = new EtudiantDaoImpl();
        CompteDaoImpl daoCompte=new CompteDaoImpl();
        CvDaoImpl dao = new CvDaoImpl();
        List<CV> lesCV = null;
        CV cv = null;
        
        System.out.println("-------------------------- findAll --------------------------");
        lesCV= dao.findAll();
        for ( CV cv1 : lesCV) {
            System.out.println(cv1);

        }
        System.out.println("-------------------------- findById --------------------------");
        cv = dao.findById(1);
        System.out.println(cv);
        System.out.println("-------------------------- Create --------------------------");

        Etudiant letudiant = daoEtu.findById(2);
        
        CV unCv=new CV("cv","cv","cv","cv","cv","cv");
        dao.create(unCv,letudiant);
 
        //Affichage de toutes les offres maintenant que c ajouté
        lesCV= dao.findAll();
         for ( CV cv1 : lesCV) {
            System.out.println(cv1);

        }
                  System.out.println("-------------------------- Update --------------------------");
       
         CV cv2=dao.findById(3);
         cv2.setCertification("Nouvelle Certification");
 
        dao.update(cv2);
        //Affichage de toutes les offres maintenant que c ajouté
        lesCV= dao.findAll();
         for ( CV cv1 : lesCV) {
            System.out.println(cv1);

        }
         System.out.println("-------------------------- Delete --------------------------");
       
   
        dao.delete(2);
        //Affichage de toutes les offres maintenant que c ajouté
        lesCV= dao.findAll();
         for ( CV cv1 : lesCV) {
            System.out.println(cv1);

        }

        

    }
}
