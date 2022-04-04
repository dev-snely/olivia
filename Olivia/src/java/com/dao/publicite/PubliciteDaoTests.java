/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dao.publicite;

import com.model.entities.Entreprise;
import com.model.entities.Publicite;
import java.util.List;

/**
 *
 * @author gabri
 */
public class PubliciteDaoTests {

    public static void main(String[] args) {
        PubliciteDaoImp dao = new PubliciteDaoImp();
        List<Publicite> listePub = null;
        Publicite pub=null;
        listePub = dao.findAll();
        System.out.println("-------------------------- findAll --------------------------");
        for (Publicite pub1 : listePub) {

            System.out.println(pub1);
        }
        System.out.println("-------------------------- findById --------------------------");
        pub = dao.findById(1);
        System.out.println(pub);
        System.out.println("-------------------------- Create --------------------------");
        Entreprise ent = new Entreprise();
        ent.setId(1);
        Publicite publicite =new Publicite("le contenu de cette publicité", "publicite.png");
        dao.create(publicite, ent);
        pub = dao.findById(2);
        System.out.println(pub);
        System.out.println("-------------------------- Delete --------------------------");

        dao.delete(2);
        pub = dao.findById(2);
        System.out.println(pub);
        System.out.println("-------------------------- Delete --------------------------");
      
        publicite.setImgLink("nonononononon");
        publicite.setContenu("nananananan");
        dao.create(publicite, ent);
        dao.update(publicite);
        pub = dao.findById(3);
        System.out.println(pub);
    }
}
