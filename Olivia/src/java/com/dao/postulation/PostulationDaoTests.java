/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dao.postulation;

import com.model.entities.Etudiant;
import com.model.entities.Offre;
import com.model.entities.Postulation;
import java.util.List;

/**
 *
 * @author gabri
 */
public class PostulationDaoTests {
     public static void main(String[] args) {
        
        PostulationDaoImpl dao = new PostulationDaoImpl();
         Etudiant etu = dao.daoEtu.findById(1);
         Offre offre = dao.daoOffre.findById(1);
        List<Postulation> listePost = null;
        Postulation post=null;
        listePost = dao.findAll();
        System.out.println("-------------------------- findAll --------------------------");
        for (Postulation post1 : listePost) {

            System.out.println(post1);
        }
        System.out.println("-------------------------- findById --------------------------");
        post = dao.findByIdEtudiantEtOffre(offre,etu);
        System.out.println(post);
        System.out.println("-------------------------- Create --------------------------");
        Postulation post1=new Postulation();
        post1.setAcceptation(true);
          post1.setSignature(true);
       post = dao.findByIdEtudiantEtOffre(offre,etu);
        System.out.println(post);
               System.out.println("-------------------------- Update --------------------------");
      
        post1.setAcceptation(false);
          post1.setSignature(false);
       
        dao.update(post1,offre,etu);
      post = dao.findByIdEtudiantEtOffre(offre,etu);
        System.out.println(post);
      
        System.out.println("-------------------------- Delete --------------------------");

        dao.delete(offre,etu);
         post = dao.findByIdEtudiantEtOffre(offre,etu);
        System.out.println(post);
        
 
    }
}
