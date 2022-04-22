/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dao.admin;

import com.dao.compte.CompteDaoImpl;
import com.model.entities.Admin;
import com.model.entities.Compte;
import java.util.List;

/**
 *
 * @author gabri
 */
public class AdminDaoTests {
        public static void main(String[] args) {
        AdminDaoImpl dao = new AdminDaoImpl();
        CompteDaoImpl daoCompte =new CompteDaoImpl();
        List<Admin> lesAdmin = null;
        Admin admin = null;
        lesAdmin = dao.findAll();
        System.out.println("-------------------------- findAll --------------------------");
        for (Admin unAdmin : lesAdmin) {
            System.out.println(unAdmin);

        }
        System.out.println("-------------------------- findById --------------------------");
        admin = dao.findById(1);
        System.out.println(admin);

        System.out.println("-------------------------- Create --------------------------");
        Compte unCompte=new Compte("admin2222@gmail.com","12223","adm");
        daoCompte.create(unCompte);
        
        Admin ladmin = new Admin("L'fsd", "fds", daoCompte.findByCourriel("admin2222@gmail.com"));
        dao.create(ladmin);
        //Affichage de toutes les offres maintenant que c ajouté
        lesAdmin = dao.findAll();
       for (Admin unAdmin : lesAdmin) {
            System.out.println(unAdmin);

        }
        System.out.println("-------------------------- Update --------------------------");

        admin = dao.findById(2);
        admin.setNom("Je suis changer");

        dao.update(admin);
        //Affichage de toutes les offres maintenant que c ajouté
       lesAdmin = dao.findAll();
       for (Admin unAdmin : lesAdmin) {
            System.out.println(unAdmin);

        }
       System.out.println("-------------------------- Delete --------------------------");

        dao.delete(2);
        //Affichage de toutes les offres maintenant que c ajouté
        
       lesAdmin = dao.findAll();
       for (Admin unAdmin : lesAdmin) {
            System.out.println(unAdmin);

        }

        System.out.println("-------------------------- FindByNom --------------------------");

        lesAdmin = dao.findByNom("Smith");
       for (Admin unAdmin : lesAdmin) {
            System.out.println(unAdmin);

        }
        System.out.println("-------------------------- FindByPrenom --------------------------");

        lesAdmin = dao.findByPrenom("Adam");
       for (Admin unAdmin : lesAdmin) {
            System.out.println(unAdmin);

        }
 
    }
}
