/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dao.publicite;

import com.model.entities.Entreprise;
import com.model.entities.Publicite;
import com.services.singleton.ConnexionBD;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author gabri
 */
public class PubliciteDaoImp implements PubliciteDao{
    private static final String SQL_SELECT = "select * from publicite";
    private static final String SQL_SELECT_PAR_ID = "select * from publicite where idPublicite = ?";
    private static final String SQL_INSET = "insert into publicite(Contenu,ImgLink,Entreprise_IdEntreprise) value(?,?,?)";
    private static final String SQL_UPDATE = "update publicite set Contenu =?,ImgLink = ? where idPublicite = ?";
    private static final String SQL_DELETE = "delete from publicite where idPublicite = ?";
 
    @Override
    public List<Publicite> findAll() {
         List<Publicite> listePub = null;
        try {
            //Initialise la requête préparée basée sur la connexion 
            // la requête SQL passé en argument pour construire l'objet preparedStatement
            PreparedStatement ps = ConnexionBD.getConnection().prepareStatement(SQL_SELECT);
            //On execute la requête et on récupère les résultats dans la requête 
            // dans ResultSet
            ResultSet result = ps.executeQuery();
            listePub = new ArrayList<>();
            //// la méthode next() pour se déplacer sur l'enregistrement suivant
            //on parcours ligne par ligne les résultas retournés
            while (result.next()) {
                //on enregistre les données dans un entities (bean, classe java)
                Publicite pub = new Publicite();
                pub.setId(result.getInt("idPublicite"));
                pub.setContenu(result.getString("Contenu"));
                pub.setImgLink(result.getString("ImgLink"));
      

                listePub.add(pub);
            }

        } catch (SQLException ex) {
            Logger.getLogger(PubliciteDaoImp.class.getName()).log(Level.SEVERE, null, ex);
        }
        //Fermeture de toutes les ressources ouvertes
        ConnexionBD.closeConnection();
        return listePub;}

    @Override
    public Publicite findById(int id) {
     Publicite pub = null;
        try {
            //Initialise la requête préparée base sur la connexion 
            // la requête SQL passé en argument pour construire l'objet preparedStatement
            PreparedStatement ps = ConnexionBD.getConnection().prepareStatement(SQL_SELECT_PAR_ID);
           // on initialise la propriété id du bean avec sa valeur
            ps.setInt(1, id);
            //On execute la requête et on récupère les résultats dans la requête 
            // dans ResultSet
            ResultSet result = ps.executeQuery();

            //// la méthode next() pour se déplacer sur l'enregistrement suivant
           
            //on parcours ligne par ligne les resultats retournés
            while (result.next()) {
                //on enregistre les données dans un entities (bean, classe java)
                pub = new Publicite();
                pub.setId(result.getInt("idPublicite"));
                pub.setContenu(result.getString("Contenu"));
                pub.setImgLink(result.getString("ImgLink"));


            }

        } catch (SQLException ex) {
            Logger.getLogger(PubliciteDaoImp.class.getName()).log(Level.SEVERE, null, ex);
        }
        //Fermeture de toutes les ressources ouvertes
        ConnexionBD.closeConnection();
        return pub;  }

    @Override
    public boolean create(Publicite pub, Entreprise ent) {
     boolean retour = false;
        int nbLigne = 0;
        PreparedStatement ps;
        try {
            ps = ConnexionBD.getConnection().prepareStatement(SQL_INSET);

            
            ps.setString(1, pub.getContenu());
            ps.setString(2, pub.getImgLink());
            ps.setInt(3, ent.getId());


            nbLigne = ps.executeUpdate();

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            Logger.getLogger(PubliciteDaoImp.class.getName()).log(Level.SEVERE, null, e);
        }

//		System.out.println("nb ligne " + nbLigne);
        if (nbLigne > 0) {
            retour = true;
        }
        ConnexionBD.closeConnection();
        return retour; }

    @Override
    public boolean delete(int id) {
           boolean retour = false;
        int nbLigne = 0;
        PreparedStatement ps;
        try {
            ps = ConnexionBD.getConnection().prepareStatement(SQL_DELETE);
            ps.setInt(1, id);

            nbLigne = ps.executeUpdate();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        if (nbLigne > 0) {
            retour = true;
        }
        ConnexionBD.closeConnection();
        return retour; }

    @Override
    public boolean update(Publicite pub) {
        boolean retour = false;
        int nbLigne = 0;
        PreparedStatement ps;
        try {
            ps = ConnexionBD.getConnection().prepareStatement(SQL_UPDATE);

            ps.setString(1, pub.getContenu());
            ps.setString(2, pub.getImgLink());
            
     
     
            ps.setInt(3, pub.getId());

            nbLigne = ps.executeUpdate();

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            Logger.getLogger(PubliciteDaoImp.class.getName()).log(Level.SEVERE, null, e);
        }

//		System.out.println("nb ligne " + nbLigne);
        if (nbLigne > 0) {
            retour = true;
        }
        ConnexionBD.closeConnection();
        return retour;
    }
    
}
