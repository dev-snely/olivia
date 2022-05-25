/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dao.professeur;

import com.dao.compte.CompteDaoImpl;
import com.model.entities.Compte;
import com.model.entities.Professeur;
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
public class ProfesseurDaoImpl implements ProfesseurDao{
 private static final String SQL_SELECT_PAR_ID_COMPTE = "select * from professeur where Compte_IdCompte = ?";
    private static final String SQL_SELECT = "select * from professeur";
    private static final String SQL_SELECT_PAR_ID = "select * from professeur where IdProfesseur = ?";
    private static final String SQL_SELECT_PAR_NOM = "select * from professeur where Nom = ?";
    private static final String SQL_SELECT_PAR_PRENOM = "select * from professeur where Prenom = ?";
    private static final String SQL_SELECT_PAR_NUMERODA = "select * from professeur where NumeroDA = ?";
    private static final String SQL_INSET = "insert into professeur(Nom,Prenom,NumeroDA,Compte_IdCompte) value(?,?,?,?)";
    private static final String SQL_UPDATE = "update professeur set Nom =?,Prenom = ?,NumeroDA=? where IdProfesseur = ?";
    private static final String SQL_DELETE = "delete from professeur where IdProfesseur = ?";
    CompteDaoImpl daoCompte = new CompteDaoImpl();
    @Override
    public List<Professeur> findAll() {
        List<Professeur> listeProf = null;

        try {
            //Initialise la requête préparée basée sur la connexion 
            // la requête SQL passé en argument pour construire l'objet preparedStatement
            PreparedStatement ps = ConnexionBD.getConnection().prepareStatement(SQL_SELECT);
            //On execute la requête et on récupère les résultats dans la requête 
            // dans ResultSet
            ResultSet result = ps.executeQuery();
            listeProf = new ArrayList<>();

            //// la méthode next() pour se déplacer sur l'enregistrement suivant
            //on parcours ligne par ligne les résultas retournés
            while (result.next()) {
                //on enregistre les données dans un entities (bean, classe java)
                Professeur prof = new Professeur();
                prof.setId(result.getInt("IdProfesseur"));
                prof.setNom(result.getString("Nom"));
                prof.setPrenom(result.getString("Prenom"));
                prof.setNumeroDa(result.getInt("NumeroDA"));
  
                prof.setCompte(daoCompte.findById(result.getInt("Compte_IdCompte")));

                listeProf.add(prof);  
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProfesseurDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        ConnexionBD.closeConnection();
        return listeProf;
            }

    @Override
    public Professeur findById(int id) {
         Professeur prof = new Professeur();
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
                prof.setId(result.getInt("IdProfesseur"));
                prof.setNom(result.getString("Nom"));
                prof.setPrenom(result.getString("Prenom"));
                prof.setNumeroDa(result.getInt("NumeroDA"));

                prof.setCompte(daoCompte.findById(result.getInt("Compte_IdCompte")));
            }

        } catch (SQLException ex) {
            Logger.getLogger(ProfesseurDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        ConnexionBD.closeConnection();
        return prof;
    }

    @Override
    public List<Professeur> findByNom(String nom) {
         List<Professeur> listeProf = null;
        try {
            //Initialise la requête préparée basée sur la connexion 
            // la requête SQL passé en argument pour construire l'objet preparedStatement
            PreparedStatement ps = ConnexionBD.getConnection().prepareStatement(SQL_SELECT_PAR_NOM);
            //On execute la requête et on récupère les résultats dans la requête 
            // dans ResultSet
            ps.setString(1, nom);
            ResultSet result = ps.executeQuery();
            listeProf = new ArrayList<>();
            //// la méthode next() pour se déplacer sur l'enregistrement suivant
            //on parcours ligne par ligne les résultas retournés
            while (result.next()) {
                //on enregistre les données dans un entities (bean, classe java)

                Professeur prof=new Professeur();
                prof.setId(result.getInt("IdProfesseur"));
                prof.setNom(result.getString("Nom"));
                prof.setPrenom(result.getString("Prenom"));
                prof.setNumeroDa(result.getInt("NumeroDA"));

                prof.setCompte(daoCompte.findById(result.getInt("Compte_IdCompte")));

                listeProf.add(prof);

            }
        } catch (SQLException ex) {
            Logger.getLogger(ProfesseurDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        ConnexionBD.closeConnection();
        return listeProf;
    }

    @Override
    public List<Professeur> findByPrenom(String prenom) {
                 List<Professeur> listeProf = null;
        try {
            //Initialise la requête préparée basée sur la connexion 
            // la requête SQL passé en argument pour construire l'objet preparedStatement
            PreparedStatement ps = ConnexionBD.getConnection().prepareStatement(SQL_SELECT_PAR_PRENOM);
            //On execute la requête et on récupère les résultats dans la requête 
            // dans ResultSet
            ps.setString(1, prenom);
            ResultSet result = ps.executeQuery();
            listeProf = new ArrayList<>();
            //// la méthode next() pour se déplacer sur l'enregistrement suivant
            //on parcours ligne par ligne les résultas retournés
            while (result.next()) {
                //on enregistre les données dans un entities (bean, classe java)

                Professeur prof=new Professeur();
                prof.setId(result.getInt("IdProfesseur"));
                prof.setNom(result.getString("Nom"));
                prof.setPrenom(result.getString("Prenom"));
                prof.setNumeroDa(result.getInt("NumeroDA"));

                prof.setCompte(daoCompte.findById(result.getInt("Compte_IdCompte")));

                listeProf.add(prof);

            }
        } catch (SQLException ex) {
            Logger.getLogger(ProfesseurDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        ConnexionBD.closeConnection();
        return listeProf;}

    @Override
    public Professeur findByNumeroDA(int DA) {
                         Professeur prof = new Professeur();
        try {
            //Initialise la requête préparée basée sur la connexion 
            // la requête SQL passé en argument pour construire l'objet preparedStatement
            PreparedStatement ps = ConnexionBD.getConnection().prepareStatement(SQL_SELECT_PAR_NUMERODA);
            //On execute la requête et on récupère les résultats dans la requête 
            // dans ResultSet
           ps.setInt(1, DA);
            ResultSet result = ps.executeQuery();
            while (result.next()) {
                //// la méthode next() pour se déplacer sur l'enregistrement suivant
                //on parcours ligne par ligne les résultas retournés
                //on enregistre les données dans un entities (bean, classe java)
                prof.setId(result.getInt("IdProfesseur"));
                prof.setNom(result.getString("Nom"));
                prof.setPrenom(result.getString("Prenom"));
                prof.setNumeroDa(result.getInt("NumeroDA"));

                prof.setCompte(daoCompte.findById(result.getInt("Compte_IdCompte")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProfesseurDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        ConnexionBD.closeConnection();
        return prof;  }

    @Override
    public boolean create(Professeur etu) {
        Compte compte = etu.getCompte();
        boolean retour = false;
        int nbLigne = 0;
        PreparedStatement ps;
        try {

            ps = ConnexionBD.getConnection().prepareStatement(SQL_INSET);

            ps.setString(1, etu.getNom());
            ps.setString(2, etu.getPrenom());
            ps.setInt(3, etu.getNumeroDa());
            ps.setInt(4, compte.getId());

            nbLigne = ps.executeUpdate();

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            Logger.getLogger(ProfesseurDaoImpl.class.getName()).log(Level.SEVERE, null, e);
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
        return retour;   }

    @Override
    public boolean update(Professeur etu) {
       boolean retour = false;
        int nbLigne = 0;
        PreparedStatement ps;
        try {
            ps = ConnexionBD.getConnection().prepareStatement(SQL_UPDATE);

            ps.setString(1, etu.getNom());
            ps.setString(2, etu.getPrenom());
              ps.setInt(3, etu.getNumeroDa());
            ps.setInt(4, etu.getId());
           

            nbLigne = ps.executeUpdate();

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            Logger.getLogger(ProfesseurDaoImpl.class.getName()).log(Level.SEVERE, null, e);
        }

        //System.out.println("nb ligne " + nbLigne);
        if (nbLigne > 0) {
            retour = true;
        }
        ConnexionBD.closeConnection();
        return retour; }

    @Override
    public Professeur findByIdCompte(int id) {
          Professeur prof = new Professeur();
        try {
            //Initialise la requête préparée basée sur la connexion 
            // la requête SQL passé en argument pour construire l'objet preparedStatement
            PreparedStatement ps = ConnexionBD.getConnection().prepareStatement(SQL_SELECT_PAR_ID_COMPTE);
            //On execute la requête et on récupère les résultats dans la requête 
            // dans ResultSet
            ps.setInt(1, id);
            ResultSet result = ps.executeQuery();
            while (result.next()) {
                //// la méthode next() pour se déplacer sur l'enregistrement suivant
                //on parcours ligne par ligne les résultas retournés
                //on enregistre les données dans un entities (bean, classe java)
                prof.setId(result.getInt("IdProfesseur"));
                prof.setNom(result.getString("Nom"));
                prof.setPrenom(result.getString("Prenom"));
                prof.setNumeroDa(result.getInt("NumeroDA"));

                prof.setCompte(daoCompte.findById(result.getInt("Compte_IdCompte")));
            }

        } catch (SQLException ex) {
            Logger.getLogger(ProfesseurDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        ConnexionBD.closeConnection();
        return prof;}
    
}
