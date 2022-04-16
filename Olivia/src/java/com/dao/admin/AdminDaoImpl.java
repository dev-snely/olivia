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
    private static final String SQL_INSERT = "insert into admin ( Nom, Prenom, Compte_IdCompte ) value(?,?,?)";
    private static final String SQL_UPDATE = "update admin set Nom =?,Prenom = ? where IdAdmin = ?";
    private static final String SQL_DELETE = "delete from admin where idAdmin = ?";
    private static final String SQL_FIND_BY_NOM = "select * from admin where Nom = ?";
    private static final String SQL_FIND_BY_PRENOM = "select * from admin where Prenom = ?";

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
                
                
                int idCompte;
                idCompte = result.getInt("Compte_IdCompte");
                
                CompteDaoImpl dao = new CompteDaoImpl();
                Compte compte = dao.findById(idCompte);
                
                unAdmin.setCompte(compte);
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
        Admin unAdmin = null;
        try {
            //Initialise la requête préparée base sur la connexion 
            // la requête SQL passé en argument pour construire l'objet preparedStatement
            PreparedStatement ps = ConnexionBD.getConnection().prepareStatement(SQL_SELECT_PAR_ID);
            // on initialise la propriété id du bean avec sa valeur
            ps.setInt(1, id);
            //On execute la requête et on récupère les résultats dans la requête 
            // dans ResultSet
            
            ResultSet result = ps.executeQuery();
            unAdmin = new Admin();
            //// la méthode next() pour se déplacer sur l'enregistrement suivant
            //on parcours ligne par ligne les resultats retournés
            while (result.next()) {
                //on enregistre les données dans un entities (bean, classe java)

                unAdmin.setId(result.getInt("idAdmin"));
                unAdmin.setNom(result.getString("Nom"));
                unAdmin.setPrenom(result.getString("Prenom"));
                
                int idCompte;
                idCompte = result.getInt("Compte_IdCompte");
                
                CompteDaoImpl dao = new CompteDaoImpl();
                Compte compte = dao.findById(idCompte);
                
                unAdmin.setCompte(compte);
            }

        } catch (SQLException ex) {
            Logger.getLogger(CompteDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        //Fermeture de toutes les ressources ouvertes
        ConnexionBD.closeConnection();
        return unAdmin;
    }

    @Override
    public boolean create(Admin admin) {
        boolean retour = false;
        int nbLigne = 0;
        PreparedStatement ps;
        try {
            ps = ConnexionBD.getConnection().prepareStatement(SQL_INSERT);

            ps.setString(1, admin.getNom());
            ps.setString(2, admin.getPrenom());
            ps.setInt(3, admin.getCompte().getId());

            nbLigne = ps.executeUpdate();

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            Logger.getLogger(CompteDaoImpl.class.getName()).log(Level.SEVERE, null, e);
        }

        // System.out.println("nb ligne " + nbLigne);
        if (nbLigne > 0) {
            retour = true;
        }
        ConnexionBD.closeConnection();
        return retour;
    }

    @Override
    public boolean delete(int idAdmin) {
        boolean retour = false;
        int nbLigne = 0;
        PreparedStatement ps;
        try {
            ps = ConnexionBD.getConnection().prepareStatement(SQL_DELETE);
            ps.setInt(1, idAdmin);
            
            
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

        //System.out.println("nb ligne " + nbLigne);
        if (nbLigne > 0) {
            retour = true;
        }
        ConnexionBD.closeConnection();
        return retour;
    }

    @Override
    public List<Admin> findByNom(String nom) {
        List<Admin> listeAdmin = null;
        try {
            //Initialise la requête préparée base sur la connexion 
            // la requête SQL passé en argument pour construire l'objet preparedStatement
            PreparedStatement ps = ConnexionBD.getConnection().prepareStatement(SQL_FIND_BY_NOM);
            // on initialise la propriété id du bean avec sa valeur
            ps.setString(1, nom);
            //On execute la requête et on récupère les résultats dans la requête 
            // dans ResultSet
            ResultSet result = ps.executeQuery();
            listeAdmin = new ArrayList<>();
            //// la méthode next() pour se déplacer sur l'enregistrement suivant
            //on parcours ligne par ligne les resultats retournés
            while (result.next()) {
                //on enregistre les données dans un entities (bean, classe java)
                Admin unAdmin = new Admin();
                unAdmin.setId(result.getInt("idAdmin"));
                unAdmin.setNom(result.getString("Nom"));
                unAdmin.setPrenom(result.getString("Prenom"));
                
                int idCompte;
                idCompte = result.getInt("Compte_IdCompte");
                
                CompteDaoImpl dao = new CompteDaoImpl();
                Compte compte = dao.findById(idCompte);
                
                unAdmin.setCompte(compte);
                listeAdmin.add(unAdmin);
            }

        } catch (SQLException ex) {
            Logger.getLogger(CompteDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        //Fermeture de toutes les ressources ouvertes
        ConnexionBD.closeConnection();
        return listeAdmin;
    }

    @Override
    public List<Admin> findByPrenom(String prenom) {
        List<Admin> listeAdmin = null;
        try {
            //Initialise la requête préparée base sur la connexion 
            // la requête SQL passé en argument pour construire l'objet preparedStatement
            PreparedStatement ps = ConnexionBD.getConnection().prepareStatement(SQL_FIND_BY_PRENOM);
            // on initialise la propriété id du bean avec sa valeur
            ps.setString(1, prenom);
            //On execute la requête et on récupère les résultats dans la requête 
            // dans ResultSet
            ResultSet result = ps.executeQuery();
            listeAdmin = new ArrayList<>();
            //// la méthode next() pour se déplacer sur l'enregistrement suivant
            //on parcours ligne par ligne les resultats retournés
            while (result.next()) {
                //on enregistre les données dans un entities (bean, classe java)
                Admin unAdmin = new Admin();
                unAdmin.setId(result.getInt("idAdmin"));
                unAdmin.setNom(result.getString("Nom"));
                unAdmin.setPrenom(result.getString("Prenom"));
                
                int idCompte;
                idCompte = result.getInt("Compte_IdCompte");
                
                CompteDaoImpl dao = new CompteDaoImpl();
                Compte compte = dao.findById(idCompte);
                
                unAdmin.setCompte(compte);
                listeAdmin.add(unAdmin);
            }

        } catch (SQLException ex) {
            Logger.getLogger(CompteDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        //Fermeture de toutes les ressources ouvertes
        ConnexionBD.closeConnection();
        return listeAdmin;
    }
    
}
