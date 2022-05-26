/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dao.occupation;

import com.dao.compte.CompteDaoImpl;
import com.dao.etudiant.EtudiantDaoImpl;
import com.model.entities.Etudiant;
import com.model.entities.Occupation;

import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

/**
 *
 * @author gabri
 */
public class OccupationDaoTests {
    
       public static void main(String[] args) {
            
        EtudiantDaoImpl daoEtu = new EtudiantDaoImpl();
        CompteDaoImpl daoCompte=new CompteDaoImpl();
        OccupationDaoImpl dao = new OccupationDaoImpl();
        List<Occupation> lesOcuup = null;
        Occupation occup = null;
        
        System.out.println("-------------------------- findAll --------------------------");
        lesOcuup= dao.findAll();
        for ( Occupation occupation : lesOcuup) {
            System.out.println(occupation);

        }
        System.out.println("-------------------------- findById --------------------------");
        occup = dao.findById(1);
        System.out.println(occup);
        System.out.println("-------------------------- Create --------------------------");

        Etudiant letudiant = daoEtu.findById(1);
        
        String dateDebut=new String("2022-11-01");
        String dateFin=new String("2023-11-01");
         
        Occupation uneOccup=new Occupation(dateDebut,dateFin,false);
        dao.create(uneOccup,letudiant);
 
        //Affichage de toutes les offres maintenant que c ajouté
      lesOcuup= dao.findAll();
        for ( Occupation occupation : lesOcuup) {
            System.out.println(occupation);

        }
                  System.out.println("-------------------------- Update --------------------------");
       
         Occupation cv2=dao.findById(3);
         String dateNew=new String("2025-11-01");
         cv2.setDateDebut(dateNew);
 
        dao.update(cv2);
        //Affichage de toutes les offres maintenant que c ajouté
         lesOcuup= dao.findAll();
        for ( Occupation occupation : lesOcuup) {
            System.out.println(occupation);

        }
          System.out.println("-------------------------- FindByDateDebut --------------------------");
        lesOcuup =  dao.findByDateDebut(dateNew);
        for ( Occupation occupation : lesOcuup) {
            System.out.println(occupation);

        }
                  System.out.println("-------------------------- FindByDateFin --------------------------");
        lesOcuup =  dao.findByDateFin(dateFin);
        for ( Occupation occupation : lesOcuup) {
            System.out.println(occupation);

        }
         System.out.println("-------------------------- Delete --------------------------");
       
   
        dao.delete(2);
        //Affichage de toutes les offres maintenant que c ajouté
        lesOcuup= dao.findAll();
        for ( Occupation occupation : lesOcuup) {
            System.out.println(occupation);

        }

        

    }  
}
