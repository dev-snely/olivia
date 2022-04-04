/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dao.admin;

import com.dao.compte.CompteDaoImpl;
import com.model.entities.Admin;
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
public class AdminDaoImpl implements AdminDao {
    
    private static final String SQL_SELECT = "select * from admin";
    private static final String SQL_SELECT_PAR_ID = "select * from admin where id = ?";
    private static final String SQL_INSET = "insert into admin ( IdAdmin , Nom, Prenom, CompteId_Compte ) value(?,?,?,?)";
    private static final String SQL_UPDATE = "update admin set Nom =?,Prenom = ?,CompteId_Compte = ? where IdAdmin = ?";
    private static final String SQL_DELETE = "delete from admin where id = ?";

    @Override
    public List<Admin> findAll() {
        List<Admin> listeCompte = null;
        try {
            //Initialise la requête préparée basée sur la connexion 
            // la requête SQL passé en argument pour construire l'objet preparedStatement
            PreparedStatement ps = ConnexionBD.getConnection().prepareStatement(SQL_SELECT);
            //On execute la requête et on récupère les résultats dans la requête 
            // dans ResultSet
            ResultSet result = ps.executeQuery();
            listeCompte = new ArrayList<>();
            //// la méthode next() pour se déplacer sur l'enregistrement suivant
            //on parcours ligne par ligne les résultas retournés
            while (result.next()) {
                //on enregistre les données dans un entities (bean, classe java)
                Admin unAdmin = new Admin();
                unAdmin.setId(result.getInt("idAdmin"));
                unAdmin.setNom(result.getString("Nom"));
                unAdmin.setPrenom(result.getString("Prenom"));
                unAdmin.setCompte(result.getInt("CompteId_Compte"));
                listeCompte.add(unAdmin);
            }

        } catch (SQLException ex) {
            Logger.getLogger(CompteDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        //Fermeture de toutes les ressources ouvertes
        ConnexionBD.closeConnection();
        return listeCompte;
    }

    @Override
    public Admin findById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean create(Admin admin) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean update(Admin admin) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
