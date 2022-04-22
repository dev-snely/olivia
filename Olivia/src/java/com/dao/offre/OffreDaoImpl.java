/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dao.offre;

import com.model.entities.Entreprise;
import com.model.entities.Offre;
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
public class OffreDaoImpl implements OffreDao{
    private static final String SQL_SELECT = "select * from offre";
    private static final String SQL_SELECT_PAR_ID = "select * from offre where IdOffre = ?";
    private static final String SQL_INSET = "insert into offre(Poste,Description,Remuneration,Entreprise_IdEntreprise) value(?,?,?,?)";
    private static final String SQL_UPDATE = "update offre set Poste =?,Description = ?,Remuneration = ? where IdOffre = ?";
    private static final String SQL_DELETE = "delete from offre where IdOffre = ?";
    

    @Override
    public List<Offre> findAll() {
       List<Offre> listeOffre = null;
       try {
            //Initialise la requête préparée basée sur la connexion 
            // la requête SQL passé en argument pour construire l'objet preparedStatement
            PreparedStatement ps = ConnexionBD.getConnection().prepareStatement(SQL_SELECT);
            //On execute la requête et on récupère les résultats dans la requête 
            // dans ResultSet
            ResultSet result = ps.executeQuery();
            listeOffre = new ArrayList<>();
              //// la méthode next() pour se déplacer sur l'enregistrement suivant
            //on parcours ligne par ligne les résultas retournés
            while (result.next()) {
                //on enregistre les données dans un entities (bean, classe java)
                Offre offres = new Offre();
                offres.setId(result.getInt("idOffre"));
                offres.setPoste(result.getString("Poste"));
                offres.setDescription(result.getString("Description"));
                offres.setRemuneration(result.getFloat("Remuneration"));
                
      

                listeOffre.add(offres);
            }
       }catch (SQLException ex) {
            Logger.getLogger(OffreDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
    }
       ConnexionBD.closeConnection();
        return listeOffre;
    }
            
            
    

    @Override
    public Offre findById(int id) {
        Offre offre = null;
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
                offre = new Offre();
                offre.setId(result.getInt("idOffre"));
                offre.setPoste(result.getString("Poste"));
                offre.setDescription(result.getString("Description"));
                offre.setRemuneration(result.getFloat("Remuneration"));
            }
            
        
        
    }catch (SQLException ex) {
            Logger.getLogger(OffreDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        
    }ConnexionBD.closeConnection();
        return offre;
    }

    @Override
    public boolean create(Offre ocup,Entreprise ent) {
        boolean retour = false;
        int nbLigne = 0;
        PreparedStatement ps;
        try {
            ps = ConnexionBD.getConnection().prepareStatement(SQL_INSET);

            
            ps.setString(1, ocup.getPoste());
            ps.setString(2, ocup.getDescription());
            ps.setFloat(3, ocup.getRemuneration());
            ps.setInt(4, ent.getId());


            nbLigne = ps.executeUpdate();

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            Logger.getLogger(OffreDaoImpl.class.getName()).log(Level.SEVERE, null, e);
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
        return retour; }
       
    

    @Override
    public boolean update(Offre ocup) {
        boolean retour = false;
        int nbLigne = 0;
        PreparedStatement ps;
        try {
            ps = ConnexionBD.getConnection().prepareStatement(SQL_UPDATE);

            ps.setString(1, ocup.getPoste());
            ps.setString(2, ocup.getDescription());
            ps.setFloat(3, ocup.getRemuneration());
            ps.setInt(4, ocup.getId());
            

            nbLigne = ps.executeUpdate();

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            Logger.getLogger(OffreDaoImpl.class.getName()).log(Level.SEVERE, null, e);
        }
        if (nbLigne > 0) {
            retour = true;
        }
        ConnexionBD.closeConnection();
        return retour;
        
    
    }
    

       
    }
    

