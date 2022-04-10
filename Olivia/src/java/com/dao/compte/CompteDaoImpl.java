/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dao.compte;

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
public class CompteDaoImpl implements CompteDao {

    private static final String SQL_SELECT = "select * from compte";
    private static final String SQL_SELECT_PAR_ID = "select * from compte where idcompte = ?";
    private static final String SQL_INSERT = "insert into compte ( Courriel, Password, TypeCompte ) value(?,?,?)";
    private static final String SQL_UPDATE = "update compte set Courriel =?,Password = ?,TypeCompte = ? where IdCompte = ?";
    private static final String SQL_DELETE = "delete from compte where idcompte = ?";
    private static final String SQL_FIND_BY_COURRIEL = "select * from compte where Courriel = ?";
    private static final String SQL_FIND_BY_PASSWORD = "select * from compte where Password = ?";
    private static final String SQL_FIND_BY_TYPE_COMPTE = "select * from compte where TypeCompte = ?";
    private static final String SQL_CONNEXION_PAR_EMAIL_AND_PASSWORD = "select * from compte where Courriel=? and Password=?";
    
    @Override
    public List<Compte> findAll() {
        List<Compte> listeCompte = null;
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
                Compte unCompte = new Compte();
                unCompte.setId(result.getInt("idCompte"));
                unCompte.setCourriel(result.getString("Courriel"));
                unCompte.setPassword(result.getString("Password"));
                unCompte.setTypeCompte(result.getString("TypeCompte"));
                listeCompte.add(unCompte);
            }

        } catch (SQLException ex) {
            Logger.getLogger(CompteDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        //Fermeture de toutes les ressources ouvertes
        ConnexionBD.closeConnection();
        return listeCompte;
    }

    @Override
    public Compte findById(int id) {
        Compte unCompte = null;
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
                unCompte = new Compte();
                unCompte.setId(result.getInt("idCompte"));
                unCompte.setCourriel(result.getString("Courriel"));
                unCompte.setPassword(result.getString("Password"));
                unCompte.setTypeCompte(result.getString("TypeCompte"));
            }

        } catch (SQLException ex) {
            Logger.getLogger(CompteDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        //Fermeture de toutes les ressources ouvertes
        ConnexionBD.closeConnection();
        return unCompte;
    }

    @Override
    public boolean create(Compte compte) {
        boolean retour = false;
        int nbLigne = 0;
        PreparedStatement ps;
        try {
            ps = ConnexionBD.getConnection().prepareStatement(SQL_INSERT);

            ps.setString(1, compte.getCourriel());
            ps.setString(2, compte.getPassword());
            ps.setString(3, compte.getTypeCompte());

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
    public boolean update(Compte compte) {
        boolean retour = false;
        int nbLigne = 0;
        PreparedStatement ps;
        try {
            ps = ConnexionBD.getConnection().prepareStatement(SQL_UPDATE);

            ps.setString(1, compte.getCourriel());
            ps.setString(2, compte.getPassword());
            ps.setString(3, compte.getTypeCompte());
            ps.setInt(4, compte.getId());

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
    public Compte findByCourriel(String email) {
        Compte unCompte = null;
        try {
            //Initialise la requête préparée base sur la connexion 
            // la requête SQL passé en argument pour construire l'objet preparedStatement
            PreparedStatement ps = ConnexionBD.getConnection().prepareStatement(SQL_FIND_BY_COURRIEL);
            // on initialise la propriété id du bean avec sa valeur
            ps.setString(1, email);
            //On execute la requête et on récupère les résultats dans la requête 
            // dans ResultSet
            ResultSet result = ps.executeQuery();

            //// la méthode next() pour se déplacer sur l'enregistrement suivant
            //on parcours ligne par ligne les resultats retournés
            while (result.next()) {
                //on enregistre les données dans un entities (bean, classe java)
                unCompte = new Compte();
                unCompte.setId(result.getInt("idCompte"));
                unCompte.setCourriel(result.getString("Courriel"));
                unCompte.setPassword(result.getString("Password"));
                unCompte.setTypeCompte(result.getString("TypeCompte"));
                
                
                
            }

        } catch (SQLException ex) {
            Logger.getLogger(CompteDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        //Fermeture de toutes les ressources ouvertes
        ConnexionBD.closeConnection();
        return unCompte;

    }

    @Override
    public List<Compte> findByPassword(String password) {
        List<Compte> listeCompte = null;
        try {
            //Initialise la requête préparée basée sur la connexion 
            // la requête SQL passé en argument pour construire l'objet preparedStatement
            PreparedStatement ps = ConnexionBD.getConnection().prepareStatement(SQL_FIND_BY_PASSWORD);
            //On execute la requête et on récupère les résultats dans la requête 
            // dans ResultSet
            ps.setString(1, password);
            ResultSet result = ps.executeQuery();
            listeCompte = new ArrayList<>();
            //// la méthode next() pour se déplacer sur l'enregistrement suivant
            //on parcours ligne par ligne les résultas retournés
            while (result.next()) {
                //on enregistre les données dans un entities (bean, classe java)
                Compte unCompte = new Compte();
                unCompte.setId(result.getInt("idCompte"));
                unCompte.setCourriel(result.getString("Courriel"));
                unCompte.setPassword(result.getString("Password"));
                unCompte.setTypeCompte(result.getString("TypeCompte"));
                listeCompte.add(unCompte);
            }

        } catch (SQLException ex) {
            Logger.getLogger(CompteDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        //Fermeture de toutes les ressources ouvertes
        ConnexionBD.closeConnection();
        return listeCompte;
    }

    @Override
    public List<Compte> findByTypeCompte(String type) {
        List<Compte> listeCompte = null;
        try {
            //Initialise la requête préparée basée sur la connexion 
            // la requête SQL passé en argument pour construire l'objet preparedStatement
            PreparedStatement ps = ConnexionBD.getConnection().prepareStatement(SQL_FIND_BY_TYPE_COMPTE);
            //On execute la requête et on récupère les résultats dans la requête 
            // dans ResultSet
            ps.setString(1, type);
            ResultSet result = ps.executeQuery();
            listeCompte = new ArrayList<>();
            //// la méthode next() pour se déplacer sur l'enregistrement suivant
            //on parcours ligne par ligne les résultas retournés
            while (result.next()) {
                //on enregistre les données dans un entities (bean, classe java)
                Compte unCompte = new Compte();
                unCompte.setId(result.getInt("idCompte"));
                unCompte.setCourriel(result.getString("Courriel"));
                unCompte.setPassword(result.getString("Password"));
                unCompte.setTypeCompte(result.getString("TypeCompte"));
                listeCompte.add(unCompte);
            }

        } catch (SQLException ex) {
            Logger.getLogger(CompteDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        //Fermeture de toutes les ressources ouvertes
        ConnexionBD.closeConnection();
        return listeCompte;
    }

    @Override
    public Compte isExiste(String email, String motDePasse) {
        Compte compte = null;
        
        try {
           
            PreparedStatement ps = ConnexionBD.getConnection().prepareStatement(SQL_CONNEXION_PAR_EMAIL_AND_PASSWORD);
            ps.setString(1, email);
            ps.setString(2, motDePasse);
            //On execute la requête et on récupère les résultats dans la requête 
            // dans ResultSet
            ResultSet result = ps.executeQuery();
            //on parcours ligne par ligne les resultats retournés
            while (result.next()) {
                //on enregistre les données dans un entities (bean, classe java)
                compte = new Compte();
                compte.setCourriel(result.getString("Courriel"));
                compte.setPassword(result.getString("Password"));
               
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(CompteDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
       
        ConnexionBD.closeConnection();
        return compte;
    }
}
