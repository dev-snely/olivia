/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dao.entreprise;

import com.model.entities.Entreprise;
import com.services.singleton.ConnexionBD;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author gabri
 */
public class EntrepriseDaoImpl implements EntrepriseDao{
private static final String SQL_SELECT_PAR_ID = "select * from entreprise where IdEntreprise = ?";
    @Override
    public List<Entreprise> findAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
                //à faire quand les comptes seront fait
                //ent.setCompte(result.getString("Compte_IdCompte"));
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean update(Entreprise entre) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
