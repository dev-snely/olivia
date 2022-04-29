/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dao.postulation;

import com.dao.etudiant.EtudiantDaoImpl;
import com.dao.offre.OffreDaoImpl;
import com.model.entities.Etudiant;
import com.model.entities.Offre;
import com.model.entities.Postulation;
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
public class PostulationDaoImpl implements PostulationDao {

    private static final String SQL_SELECT = "select * from postulation";
    private static final String SQL_SELECT_PAR_ID_ETU_OFFRE = "select * from postulation where Etudiant_IdEtudiant = ? AND Offre_IdOffre=?";
    private static final String SQL_INSET = "insert into postulation(Signature,Acceptation,Etudiant_IdEtudiant,Offre_IdOffre) value(?,?,?,?)";
    private static final String SQL_UPDATE = "update postulation set Signature =?,Acceptation = ? where  Etudiant_IdEtudiant = ? AND Offre_IdOffre=?";
    private static final String SQL_DELETE = "delete from postulation where  Etudiant_IdEtudiant = ? AND Offre_IdOffre=?";
    OffreDaoImpl daoOffre = new OffreDaoImpl();
    EtudiantDaoImpl daoEtu = new EtudiantDaoImpl();

    @Override
    public List<Postulation> findAll() {
        List<Postulation> listePost = null;
        try {
            //Initialise la requête préparée basée sur la connexion 
            // la requête SQL passé en argument pour construire l'objet preparedStatement
            PreparedStatement ps = ConnexionBD.getConnection().prepareStatement(SQL_SELECT);
            //On execute la requête et on récupère les résultats dans la requête 
            // dans ResultSet
            ResultSet result = ps.executeQuery();
            listePost = new ArrayList<>();
            //// la méthode next() pour se déplacer sur l'enregistrement suivant
            //on parcours ligne par ligne les résultas retournés
            while (result.next()) {
                //on enregistre les données dans un entities (bean, classe java)
                Postulation post = new Postulation();
                post.setAcceptation(result.getBoolean("Acceptation"));
                post.setSignature(result.getBoolean("Signature"));
                post.setEtudiant(daoEtu.findById(result.getInt("Etudiant_IdEtudiant")));
                post.setOffre(daoOffre.findById(result.getInt("Offre_IdOffre")));

                listePost.add(post);
            }

        } catch (SQLException ex) {
            Logger.getLogger(PostulationDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        //Fermeture de toutes les ressources ouvertes
        ConnexionBD.closeConnection();
        return listePost;
    }

    @Override
    public Postulation findByIdEtudiantEtOffre(Offre offre, Etudiant etudiant) {
        Postulation post = null;
        try {
            //Initialise la requête préparée base sur la connexion 
            // la requête SQL passé en argument pour construire l'objet preparedStatement
            PreparedStatement ps = ConnexionBD.getConnection().prepareStatement(SQL_SELECT_PAR_ID_ETU_OFFRE);
            // on initialise la propriété id du bean avec sa valeur
            ps.setInt(1, etudiant.getId());
            ps.setInt(2, offre.getId());
            //On execute la requête et on récupère les résultats dans la requête 
            // dans ResultSet
            ResultSet result = ps.executeQuery();

            //// la méthode next() pour se déplacer sur l'enregistrement suivant
            //on parcours ligne par ligne les resultats retournés
            while (result.next()) {
                //on enregistre les données dans un entities (bean, classe java)
                post = new Postulation();
                post.setAcceptation(result.getBoolean("Acceptation"));
                post.setSignature(result.getBoolean("Signature"));
                post.setEtudiant(etudiant);
                post.setOffre(offre);

            }

        } catch (SQLException ex) {
            Logger.getLogger(PostulationDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        //Fermeture de toutes les ressources ouvertes
        ConnexionBD.closeConnection();
        return post;
    }

    @Override
    public boolean create(Postulation post, Offre offre, Etudiant etudiant) {
        boolean retour = false;
        int nbLigne = 0;
        PreparedStatement ps;
        try {
            ps = ConnexionBD.getConnection().prepareStatement(SQL_INSET);

            ps.setBoolean(1, post.isAcceptation());
            ps.setBoolean(2, post.isSignature());
            ps.setInt(3, etudiant.getId());
            ps.setInt(4, offre.getId());

            nbLigne = ps.executeUpdate();

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            Logger.getLogger(PostulationDaoImpl.class.getName()).log(Level.SEVERE, null, e);
        }

//		System.out.println("nb ligne " + nbLigne);
        if (nbLigne > 0) {
            retour = true;
        }
        ConnexionBD.closeConnection();
        return retour;
    }

    @Override
    public boolean delete(Offre offre, Etudiant etudiant) {
        boolean retour = false;
        int nbLigne = 0;
        PreparedStatement ps;
        try {
            ps = ConnexionBD.getConnection().prepareStatement(SQL_DELETE);
            ps.setInt(1, etudiant.getId());
            ps.setInt(2, offre.getId());
            nbLigne = ps.executeUpdate();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        if (nbLigne > 0) {
            retour = true;
        }
        ConnexionBD.closeConnection();
        return retour;
    }

    @Override
    public boolean update(Postulation post, Offre offre, Etudiant etudiant) {
         boolean retour = false;
        int nbLigne = 0;
        PreparedStatement ps;
        try {
            ps = ConnexionBD.getConnection().prepareStatement(SQL_UPDATE);

           ps.setBoolean(1, post.isAcceptation());
            ps.setBoolean(2, post.isSignature());
            ps.setInt(3, etudiant.getId());
            ps.setInt(4, offre.getId());

            nbLigne = ps.executeUpdate();

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            Logger.getLogger(PostulationDaoImpl.class.getName()).log(Level.SEVERE, null, e);
        }

//		System.out.println("nb ligne " + nbLigne);
        if (nbLigne > 0) {
            retour = true;
        }
        ConnexionBD.closeConnection();
        return retour;}

}
