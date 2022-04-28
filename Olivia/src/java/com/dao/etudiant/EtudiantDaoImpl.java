/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dao.etudiant;

import com.dao.compte.CompteDaoImpl;
import com.model.entities.Compte;
import com.model.entities.Etudiant;
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
public class EtudiantDaoImpl implements EtudiantDao {

    private static final String SQL_SELECT = "select * from etudiant";
    private static final String SQL_SELECT_PAR_ID = "select * from etudiant where IdEtudiant = ?";
    private static final String SQL_SELECT_PAR_NOM = "select * from admin where Nom = ?";
    private static final String SQL_SELECT_PAR_PRENOM = "select * from admin where Prenom = ?";
    private static final String SQL_INSET = "insert into admin(Nom,Prenom,Compte_IdCompte) value(?,?,?)";
    private static final String SQL_UPDATE = "update admin set Nom =?,Prenom = ? where IdAdmin = ?";
    private static final String SQL_DELETE = "delete from admin where IdAdmin = ?";
    CompteDaoImpl daoCompte = new CompteDaoImpl();

    @Override
    public List<Etudiant> findAll() {
        List<Etudiant> listeEtudiants = null;

        try {
            //Initialise la requête préparée basée sur la connexion 
            // la requête SQL passé en argument pour construire l'objet preparedStatement
            PreparedStatement ps = ConnexionBD.getConnection().prepareStatement(SQL_SELECT);
            //On execute la requête et on récupère les résultats dans la requête 
            // dans ResultSet
            ResultSet result = ps.executeQuery();

            listeEtudiants = new ArrayList<>();

            //// la méthode next() pour se déplacer sur l'enregistrement suivant
            //on parcours ligne par ligne les résultas retournés
            while (result.next()) {
                //on enregistre les données dans un entities (bean, classe java)

                Etudiant etudiant = new Etudiant();
                etudiant.setId(result.getInt("IdAEtudiant"));
                etudiant.setNom(result.getString("Nom"));
                etudiant.setPrenom(result.getString("Prenom"));
                etudiant.setNumeroDa(result.getInt("NumeroDa"));
                etudiant.setCompte(daoCompte.findById(result.getInt("Compte_IdCompte")));

                listeEtudiants.add(etudiant);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CompteDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        ConnexionBD.closeConnection();
        return listeEtudiants;
    }

    @Override
    public Etudiant findById(int id) {
        Etudiant etudiant = new Etudiant();
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
                etudiant.setId(result.getInt("IdEtudiant"));
                etudiant.setNom(result.getString("Nom"));
                etudiant.setPrenom(result.getString("Prenom"));
                etudiant.setCompte(daoCompte.findById(result.getInt("Compte_IdCompte")));
            }

        } catch (SQLException ex) {
            Logger.getLogger(CompteDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        ConnexionBD.closeConnection();
        return etudiant;
    }

    @Override
    public List<Etudiant> findByNom(String nom) {
        List<Etudiant> listeEtudiant = null;
        try {
            //Initialise la requête préparée basée sur la connexion 
            // la requête SQL passé en argument pour construire l'objet preparedStatement
            PreparedStatement ps = ConnexionBD.getConnection().prepareStatement(SQL_SELECT_PAR_NOM);
            //On execute la requête et on récupère les résultats dans la requête 
            // dans ResultSet
            ps.setString(1, nom);
            ResultSet result = ps.executeQuery();
            listeEtudiant = new ArrayList<>();
            //// la méthode next() pour se déplacer sur l'enregistrement suivant
            //on parcours ligne par ligne les résultas retournés
            while (result.next()) {
                //on enregistre les données dans un entities (bean, classe java)
                Etudiant etu = new Etudiant();
                etu.setId(result.getInt("IdEtudiant"));
                etu.setNom(result.getString("Nom"));
                etu.setPrenom(result.getString("Prenom"));
                etu.setCompte(daoCompte.findById(result.getInt("Compte_IdCompte")));

                listeEtudiant.add(etu);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CompteDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        ConnexionBD.closeConnection();
        return listeEtudiant;
    }

    @Override
    public List<Etudiant> findByPrenom(String prenom) {
        List<Etudiant> listeEtudiant = null;
        try {
            //Initialise la requête préparée basée sur la connexion 
            // la requête SQL passé en argument pour construire l'objet preparedStatement
            PreparedStatement ps = ConnexionBD.getConnection().prepareStatement(SQL_SELECT_PAR_NOM);
            //On execute la requête et on récupère les résultats dans la requête 
            // dans ResultSet
            ps.setString(1, prenom);
            ResultSet result = ps.executeQuery();
            listeEtudiant = new ArrayList<>();
            //// la méthode next() pour se déplacer sur l'enregistrement suivant
            //on parcours ligne par ligne les résultas retournés
            while (result.next()) {
                //on enregistre les données dans un entities (bean, classe java)
                Etudiant etu = new Etudiant();
                etu.setId(result.getInt("IdEtudiant"));
                etu.setNom(result.getString("Nom"));
                etu.setPrenom(result.getString("Prenom"));
                etu.setCompte(daoCompte.findById(result.getInt("Compte_IdCompte")));

                listeEtudiant.add(etu);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CompteDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        ConnexionBD.closeConnection();
        return listeEtudiant;
    }

    @Override
    public List<Etudiant> findByNumeroDA(int DA) {
        List<Etudiant> listeEtudiant = null;
        try {
            //Initialise la requête préparée basée sur la connexion 
            // la requête SQL passé en argument pour construire l'objet preparedStatement
            PreparedStatement ps = ConnexionBD.getConnection().prepareStatement(SQL_SELECT_PAR_NOM);
            //On execute la requête et on récupère les résultats dans la requête 
            // dans ResultSet
            ps.setInt(1, DA);
            ResultSet result = ps.executeQuery();
            listeEtudiant = new ArrayList<>();
            //// la méthode next() pour se déplacer sur l'enregistrement suivant
            //on parcours ligne par ligne les résultas retournés
            while (result.next()) {
                //on enregistre les données dans un entities (bean, classe java)
                Etudiant etu = new Etudiant();
                etu.setId(result.getInt("IdEtudiant"));
                etu.setNom(result.getString("Nom"));
                etu.setPrenom(result.getString("Prenom"));
                etu.setCompte(daoCompte.findById(result.getInt("Compte_IdCompte")));

                listeEtudiant.add(etu);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CompteDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        ConnexionBD.closeConnection();
        return listeEtudiant;
    }

    @Override
    public boolean create(Etudiant etu) {
        Compte compte =etu.getCompte();
        boolean retour = false;
        int nbLigne = 0;
        PreparedStatement ps;
        try {

            ps = ConnexionBD.getConnection().prepareStatement(SQL_INSET);
            
            ps.setString(1, etu.getNom());
            ps.setString(2, etu.getPrenom());
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
    public boolean update(Etudiant etu) {
        boolean retour = false;

        int nbLigne = 0;
        PreparedStatement ps;
        try {
            ps = ConnexionBD.getConnection().prepareStatement(SQL_UPDATE);

            ps.setString(1, etu.getNom());
            ps.setString(2, etu.getPrenom());
            ps.setInt(3, etu.getId());


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

}
