/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dao.entreprise;

import com.dao.compte.CompteDaoImpl;
import com.model.entities.Compte;
import com.model.entities.Entreprise;
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
public class EntrepriseDaoImpl implements EntrepriseDao{
    private static final String SQL_SELECT = "select * from entreprise";
    private static final String SQL_SELECT_PAR_ID = "select * from entreprise where IdEntreprise = ?";
    private static final String SQL_SELECT_PAR_PERSONNEREF = "select * from entreprise where PersonneReference = ?";
     private static final String SQL_SELECT_PAR_ID_COMPTE = "select * from entreprise where Compte_IdCompte = ?";
    private static final String SQL_INSET = "insert into entreprise(Description,PersonneReference,Nom,Compte_IdCompte) value(?,?,?,?)";
    private static final String SQL_UPDATE = "update entreprise set Description =?,PersonneReference = ?,Nom = ? where IdEntreprise = ?";
    private static final String SQL_DELETE = "delete from entreprise where IdEntreprise = ?";
    CompteDaoImpl daoCompte = new CompteDaoImpl();
   @Override
    public List<Entreprise> findAll() {
         List<Entreprise> listeEnt = null;

        try {
            //Initialise la requête préparée basée sur la connexion 
            // la requête SQL passé en argument pour construire l'objet preparedStatement
            PreparedStatement ps = ConnexionBD.getConnection().prepareStatement(SQL_SELECT);
            //On execute la requête et on récupère les résultats dans la requête 
            // dans ResultSet
            ResultSet result = ps.executeQuery();

            listeEnt = new ArrayList<>();

            //// la méthode next() pour se déplacer sur l'enregistrement suivant
            //on parcours ligne par ligne les résultas retournés
            while (result.next()) {
                //on enregistre les données dans un entities (bean, classe java)

                Entreprise ent = new Entreprise();
                ent.setId(result.getInt("IdEntreprise"));
                ent.setNom(result.getString("Nom"));
                
                ent.setDescription(result.getString("Description"));
                ent.setPersonneReference(result.getString("PersonneReference"));
                ent.setCompte(daoCompte.findById(result.getInt("Compte_IdCompte")));

                listeEnt.add(ent);
            }
        } catch (SQLException ex) {
            Logger.getLogger(EntrepriseDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        ConnexionBD.closeConnection();
        return listeEnt;
    }

    @Override
    public Entreprise findById(int id) {
        Entreprise ent = null;
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
                ent = new Entreprise();
                ent.setId(result.getInt("IdEntreprise"));
                ent.setNom(result.getString("Nom"));
                ent.setCompte(daoCompte.findById(result.getInt("Compte_IdCompte")));
                ent.setDescription(result.getString("Description"));
                ent.setPersonneReference(result.getString("PersonneReference"));

            }

        } catch (SQLException ex) {
            Logger.getLogger(EntrepriseDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        //Fermeture de toutes les ressources ouvertes
        ConnexionBD.closeConnection();
        return ent;  }

    @Override
    public boolean create(Entreprise entre) {
       Compte compte =entre.getCompte();
        boolean retour = false;
        int nbLigne = 0;
        PreparedStatement ps;
        try {

            ps = ConnexionBD.getConnection().prepareStatement(SQL_INSET);
            
            ps.setString(1, entre.getDescription());
            ps.setString(2, entre.getPersonneReference());
            ps.setString(3, entre.getNom());
            ps.setInt(4, compte.getId());

            nbLigne = ps.executeUpdate();

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            Logger.getLogger(EntrepriseDaoImpl.class.getName()).log(Level.SEVERE, null, e);
        }

        if (nbLigne > 0) {
            retour = true;
        }
        ConnexionBD.closeConnection();
        return retour;}

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
        return retour;
    }

    @Override
    public boolean update(Entreprise entre) {
         boolean retour = false;

        int nbLigne = 0;
        PreparedStatement ps;
        try {
            ps = ConnexionBD.getConnection().prepareStatement(SQL_UPDATE);

            ps.setString(1, entre.getDescription());
            ps.setString(2, entre.getPersonneReference());
            ps.setString(3, entre.getNom());
            ps.setInt(4, entre.getId());


            nbLigne = ps.executeUpdate();

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            Logger.getLogger(EntrepriseDaoImpl.class.getName()).log(Level.SEVERE, null, e);
        }

        //System.out.println("nb ligne " + nbLigne);
        if (nbLigne > 0) {
            retour = true;
        }
        ConnexionBD.closeConnection();
        return retour;  }

    @Override
    public Entreprise findByIdCompte(int id) {
          Entreprise ent = null;
        try {
            //Initialise la requête préparée base sur la connexion 
            // la requête SQL passé en argument pour construire l'objet preparedStatement
            PreparedStatement ps = ConnexionBD.getConnection().prepareStatement(SQL_SELECT_PAR_ID_COMPTE);
           // on initialise la propriété id du bean avec sa valeur
            ps.setInt(1, id);
            //On execute la requête et on récupère les résultats dans la requête 
            // dans ResultSet
            ResultSet result = ps.executeQuery();

            //// la méthode next() pour se déplacer sur l'enregistrement suivant
           
            //on parcours ligne par ligne les resultats retournés
            while (result.next()) {
                //on enregistre les données dans un entities (bean, classe java)
                ent = new Entreprise();
                ent.setId(result.getInt("IdEntreprise"));
                ent.setNom(result.getString("Nom"));
                ent.setCompte(daoCompte.findById(result.getInt("Compte_IdCompte")));
                ent.setDescription(result.getString("Description"));
                ent.setPersonneReference(result.getString("PersonneReference"));

            }

        } catch (SQLException ex) {
            Logger.getLogger(EntrepriseDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        //Fermeture de toutes les ressources ouvertes
        ConnexionBD.closeConnection();
        return ent;   }
    
}
