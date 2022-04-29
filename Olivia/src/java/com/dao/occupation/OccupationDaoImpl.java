/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dao.occupation;

import com.dao.etudiant.EtudiantDaoImpl;
import com.model.entities.Etudiant;
import com.model.entities.Occupation;
import com.services.singleton.ConnexionBD;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author gabri
 */
public class OccupationDaoImpl implements OccupationDao {

    private static final String SQL_INSET = "insert into occupation(DateDebut,DateFinl,Disponible) value(?,?,?)";

    private static final String SQL_SELECT = "select * from occupation";
    private static final String SQL_SELECT_PAR_ID = "select * from occupation where IdOccupation = ?";
    private static final String SQL_SELECT_PAR_DATE_FIN = "select * from occupation where DateFinl = ?";
    private static final String SQL_SELECT_PAR_DATE_DEBUT = "select * from occupation where DateDebut = ?";

    private static final String SQL_UPDATE = "update occupation set DateDebut =?,DateFinl = ?,Disponible = ? where IdOccupation = ?";

    private static final String SQL_DELETE = "delete from occupation where IdOccupation = ?";

    @Override
    public List<Occupation> findAll() {
        List<Occupation> listeOccupation = null;
        try {
            //Initialise la requête préparée basée sur la connexion 
            // la requête SQL passé en argument pour construire l'objet preparedStatement
            PreparedStatement ps = ConnexionBD.getConnection().prepareStatement(SQL_SELECT);
            //On execute la requête et on récupère les résultats dans la requête 
            // dans ResultSet
            ResultSet result = ps.executeQuery();
            listeOccupation = new ArrayList<>();
            //// la méthode next() pour se déplacer sur l'enregistrement suivant
            //on parcours ligne par ligne les résultas retournés
            while (result.next()) {
                //on enregistre les données dans un entities (bean, classe java)
                Occupation occupation = new Occupation();
                occupation.setId(result.getInt("IdOccupation"));
                occupation.setDateDebut(result.getString("DateDebut"));
                occupation.setDatefin(result.getString("DateFinl"));
                occupation.setDisponible(result.getBoolean("Disponible"));

                listeOccupation.add(occupation);
            }
        } catch (SQLException ex) {
            Logger.getLogger(OccupationDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        ConnexionBD.closeConnection();
        return listeOccupation;
    }

    @Override
    public Occupation findById(int id) {
        Occupation occupation = null;
        try {
            //Initialise la requête préparée base sur la connexion 
            // la requête SQL passé en argument pour construire l'objet preparedStatement
            PreparedStatement ps = ConnexionBD.getConnection().prepareStatement(SQL_SELECT_PAR_ID);
            // on initialise la propriété id du bean avec sa valeur
            ps.setInt(1, id);
            //On execute la requête et on récupère les résultats dans la requête 
            // dans ResultSet
            ResultSet result = ps.executeQuery();
            while (result.next()) {
                //on enregistre les données dans un entities (bean, classe java)
                occupation = new Occupation();
                occupation.setId(result.getInt("IdOccupation"));
                occupation.setDateDebut(result.getString("DateDebut"));
                occupation.setDatefin(result.getString("DateFinl"));
                occupation.setDisponible(result.getBoolean("Disponible"));

            }

        } catch (SQLException ex) {
            Logger.getLogger(OccupationDaoImpl.class.getName()).log(Level.SEVERE, null, ex);

        }
        ConnexionBD.closeConnection();
        return occupation;
    }

    @Override
    public List<Occupation> findByDateDebut(String date) {
        List<Occupation> listeOccupation = null;
        try {
            //Initialise la requête préparée basée sur la connexion 
            // la requête SQL passé en argument pour construire l'objet preparedStatement

            PreparedStatement ps = ConnexionBD.getConnection().prepareStatement(SQL_SELECT_PAR_DATE_DEBUT);
            //On execute la requête et on récupère les résultats dans la requête 
            // dans ResultSet
            ps.setString(1, date);
            ResultSet result = ps.executeQuery();
            listeOccupation = new ArrayList<>();
            //// la méthode next() pour se déplacer sur l'enregistrement suivant
            //on parcours ligne par ligne les résultas retournés
            while (result.next()) {
                //on enregistre les données dans un entities (bean, classe java)
                Occupation occupation = new Occupation();
                occupation.setId(result.getInt("IdOccupation"));
                occupation.setDateDebut(result.getString("DateDebut"));
                occupation.setDatefin(result.getString("DateFinl"));
                occupation.setDisponible(result.getBoolean("Disponible"));

                listeOccupation.add(occupation);
            }
        } catch (SQLException ex) {
            Logger.getLogger(OccupationDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        ConnexionBD.closeConnection();
        return listeOccupation;
    }

    @Override
    public List<Occupation> findByDateFin(String date) {
        List<Occupation> listeOccupation = null;
        try {
            //Initialise la requête préparée basée sur la connexion 
            // la requête SQL passé en argument pour construire l'objet preparedStatement

            PreparedStatement ps = ConnexionBD.getConnection().prepareStatement(SQL_SELECT_PAR_DATE_FIN);
            //On execute la requête et on récupère les résultats dans la requête 
            // dans ResultSet
            ps.setString(1, date);
            ResultSet result = ps.executeQuery();
            listeOccupation = new ArrayList<>();
            //// la méthode next() pour se déplacer sur l'enregistrement suivant
            //on parcours ligne par ligne les résultas retournés
            while (result.next()) {
                //on enregistre les données dans un entities (bean, classe java)
                Occupation occupation = new Occupation();
                occupation.setId(result.getInt("IdOccupation"));
                occupation.setDateDebut(result.getString("DateDebut"));
                occupation.setDatefin(result.getString("DateFinl"));
                occupation.setDisponible(result.getBoolean("Disponible"));

                listeOccupation.add(occupation);
            }
        } catch (SQLException ex) {
            Logger.getLogger(OccupationDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        ConnexionBD.closeConnection();
        return listeOccupation;
    }

    @Override
    public boolean create(Occupation ocup, Etudiant etu) {
        EtudiantDaoImpl daoEtu = new EtudiantDaoImpl();
        boolean retour = false;
        int nbLigne = 0;
        PreparedStatement ps;
        try {
            ps = ConnexionBD.getConnection().prepareStatement(SQL_INSET);

            ps.setString(1, ocup.getDateDebut());
            ps.setString(2, ocup.getDatefin());
            ps.setBoolean(3, ocup.isDisponible());
          
            nbLigne = ps.executeUpdate();
            List<Occupation> lesOccup=this.findAll();
            int longueur=lesOccup.size();
            ocup=findById(longueur-1);
            daoEtu.updateOccupation(etu, ocup);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            Logger.getLogger(OccupationDaoImpl.class.getName()).log(Level.SEVERE, null, e);
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
    public boolean update(Occupation ocup) {
        boolean retour = false;
        int nbLigne = 0;
        PreparedStatement ps;
        try {
            ps = ConnexionBD.getConnection().prepareStatement(SQL_UPDATE);

            ps.setString(1, ocup.getDateDebut());
            ps.setString(2, ocup.getDatefin());
            ps.setBoolean(3, ocup.isDisponible());
            ps.setInt(4, ocup.getId());

            nbLigne = ps.executeUpdate();

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            Logger.getLogger(OccupationDaoImpl.class.getName()).log(Level.SEVERE, null, e);
        }
        if (nbLigne > 0) {
            retour = true;
        }
        ConnexionBD.closeConnection();
        return retour;
    }

}
