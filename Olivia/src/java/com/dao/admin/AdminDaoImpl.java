/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dao.admin;

import com.dao.compte.CompteDaoImpl;
import com.model.entities.Admin;
import com.model.entities.Compte;
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
    private static final String SQL_SELECT_PAR_ID = "select * from admin where IdAdmin = ?";
    private static final String SQL_SELECT_PAR_NOM = "select * from admin where Nom = ?";
    private static final String SQL_SELECT_PAR_PRENOM = "select * from admin where Prenom = ?";
    private static final String SQL_INSET = "insert into admin(Nom,Prenom,Compte_IdCompte) value(?,?,?)";
    private static final String SQL_UPDATE = "update admin set Nom =?,Prenom = ? where IdAdmin = ?";
    private static final String SQL_DELETE = "delete from admin where IdAdmin = ?";
    CompteDaoImpl daoCompte = new CompteDaoImpl();

    @Override
    public List<Admin> findAll() {
        List<Admin> listeAdmin = null;
        try {
            //Initialise la requête préparée basée sur la connexion 
            // la requête SQL passé en argument pour construire l'objet preparedStatement
            PreparedStatement ps = ConnexionBD.getConnection().prepareStatement(SQL_SELECT);
            //On execute la requête et on récupère les résultats dans la requête 
            // dans ResultSet
            ResultSet result = ps.executeQuery();
            listeAdmin = new ArrayList<>();
            //// la méthode next() pour se déplacer sur l'enregistrement suivant
            //on parcours ligne par ligne les résultas retournés
            while (result.next()) {
                //on enregistre les données dans un entities (bean, classe java)
                Admin admin = new Admin();
                admin.setId(result.getInt("IdAdmin"));
                admin.setNom(result.getString("Nom"));
                admin.setPrenom(result.getString("Prenom"));
                admin.setCompte(daoCompte.findById(result.getInt("Compte_IdCompte")));

                listeAdmin.add(admin);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CompteDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        ConnexionBD.closeConnection();
        return listeAdmin;
    }

    @Override
    public Admin findById(int id) {
        Admin admin = new Admin();
        try {
            //Initialise la requête préparée basée sur la connexion 
            // la requête SQL passé en argument pour construire l'objet preparedStatement
            PreparedStatement ps = ConnexionBD.getConnection().prepareStatement(SQL_SELECT_PAR_ID);
            //On execute la requête et on récupère les résultats dans la requête 
            // dans ResultSet
            ps.setInt(1, id);
            ResultSet result = ps.executeQuery();
           while (result.next()) {
            //// la méthode next() pour se déplacer sur l'enregistrement suivant
            //on parcours ligne par ligne les résultas retournés
            //on enregistre les données dans un entities (bean, classe java)
                admin.setId(result.getInt("IdAdmin"));
                admin.setNom(result.getString("Nom"));
                admin.setPrenom(result.getString("Prenom"));
                admin.setCompte(daoCompte.findById(result.getInt("Compte_IdCompte")));
           }     

        } catch (SQLException ex) {
            Logger.getLogger(CompteDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        ConnexionBD.closeConnection();
        return admin;
    }

    @Override
    public List<Admin> findByNom(String nom) {
               List<Admin> listeAdmin = null;
        try {
            //Initialise la requête préparée basée sur la connexion 
            // la requête SQL passé en argument pour construire l'objet preparedStatement
            PreparedStatement ps = ConnexionBD.getConnection().prepareStatement(SQL_SELECT_PAR_NOM);
            //On execute la requête et on récupère les résultats dans la requête 
            // dans ResultSet
             ps.setString(1, nom);
            ResultSet result = ps.executeQuery();
            listeAdmin = new ArrayList<>();
            //// la méthode next() pour se déplacer sur l'enregistrement suivant
            //on parcours ligne par ligne les résultas retournés
            while (result.next()) {
                //on enregistre les données dans un entities (bean, classe java)
                Admin admin = new Admin();
                admin.setId(result.getInt("IdAdmin"));
                admin.setNom(result.getString("Nom"));
                admin.setPrenom(result.getString("Prenom"));
                admin.setCompte(daoCompte.findById(result.getInt("Compte_IdCompte")));

                listeAdmin.add(admin);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CompteDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        ConnexionBD.closeConnection();
        return listeAdmin;
    }

    @Override
    public List<Admin> findByPrenom(String prenom) {
                      List<Admin> listeAdmin = null;
        try {
            //Initialise la requête préparée basée sur la connexion 
            // la requête SQL passé en argument pour construire l'objet preparedStatement
            PreparedStatement ps = ConnexionBD.getConnection().prepareStatement(SQL_SELECT_PAR_PRENOM);
            //On execute la requête et on récupère les résultats dans la requête 
            // dans ResultSet
             ps.setString(1, prenom);
            ResultSet result = ps.executeQuery();
            listeAdmin = new ArrayList<>();
            //// la méthode next() pour se déplacer sur l'enregistrement suivant
            //on parcours ligne par ligne les résultas retournés
            while (result.next()) {
                //on enregistre les données dans un entities (bean, classe java)
                Admin admin = new Admin();
                admin.setId(result.getInt("IdAdmin"));
                admin.setNom(result.getString("Nom"));
                admin.setPrenom(result.getString("Prenom"));
                admin.setCompte(daoCompte.findById(result.getInt("Compte_IdCompte")));

                listeAdmin.add(admin);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CompteDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        ConnexionBD.closeConnection();
        return listeAdmin;
    }

    @Override
    public boolean create(Admin admin) {
        Compte compte =admin.getCompte();
        boolean retour = false;
        int nbLigne = 0;
        PreparedStatement ps;
        try {
            ps = ConnexionBD.getConnection().prepareStatement(SQL_INSET);

            
            ps.setString(1, admin.getNom());
            ps.setString(2, admin.getPrenom());
            ps.setInt(3, compte.getId());
            


            nbLigne = ps.executeUpdate();

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            Logger.getLogger(CompteDaoImpl.class.getName()).log(Level.SEVERE, null, e);
        }
        if (nbLigne > 0) {
            retour = true;
        }
        ConnexionBD.closeConnection();
        return retour;
    }

    @Override
    public boolean delete(int id) {
                //pareil que publicité
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
    public boolean update(Admin admin) {
       boolean retour = false;
        int nbLigne = 0;
        PreparedStatement ps;
        try {
            ps = ConnexionBD.getConnection().prepareStatement(SQL_UPDATE);

            ps.setString(1, admin.getNom());
            ps.setString(2, admin.getPrenom());
            ps.setInt(3, admin.getId());
           

            nbLigne = ps.executeUpdate();

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            Logger.getLogger(CompteDaoImpl.class.getName()).log(Level.SEVERE, null, e);
        }
        if (nbLigne > 0) {
            retour = true;
        }
        ConnexionBD.closeConnection();
        return retour;
    }

}
