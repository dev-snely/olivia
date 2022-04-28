/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dao.lettreMotivation;

import com.dao.etudiant.EtudiantDaoImpl;
import com.model.entities.Etudiant;
import com.model.entities.LettreMotivation;
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
public class LettreMotivationDaoImpl implements LettreMotivationDao{
 private static final String SQL_SELECT = "select * from lettremotivation";
    private static final String SQL_SELECT_PAR_ID = "select * from lettremotivation where IdLettreMotivation = ?";
    private static final String SQL_INSET = "insert into lettremotivation(Contenu,Titre) value(?,?)";
    private static final String SQL_UPDATE = "update lettremotivation set Contenu =?,Titre = ? where IdLettreMotivation = ?";
    private static final String SQL_DELETE = "delete from lettremotivation where IdLettreMotivation = ?";
    
    @Override
    public List<LettreMotivation> findAll() {
        List<LettreMotivation> listeLettre = null;
       try {
            //Initialise la requête préparée basée sur la connexion 
            // la requête SQL passé en argument pour construire l'objet preparedStatement
            PreparedStatement ps = ConnexionBD.getConnection().prepareStatement(SQL_SELECT);
            //On execute la requête et on récupère les résultats dans la requête 
            // dans ResultSet
            ResultSet result = ps.executeQuery();
            listeLettre = new ArrayList<>();
              //// la méthode next() pour se déplacer sur l'enregistrement suivant
            //on parcours ligne par ligne les résultas retournés
            while (result.next()) {
                //on enregistre les données dans un entities (bean, classe java)
                LettreMotivation lettre = new LettreMotivation();
                lettre.setId(result.getInt("IdLettreMotivation"));
                lettre.setContenu(result.getString("Contenu"));
                lettre.setTitre(result.getString("Titre"));
               

                listeLettre.add(lettre);
            }
       }catch (SQLException ex) {
            Logger.getLogger(LettreMotivationDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
    }
       ConnexionBD.closeConnection();
        return listeLettre;
    }

    @Override
    public LettreMotivation findById(int id) {
         LettreMotivation lettre = null;
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
                lettre = new LettreMotivation();
                lettre.setId(result.getInt("IdLettreMotivation"));
                lettre.setContenu(result.getString("Contenu"));
                lettre.setTitre(result.getString("Titre"));
               

            }
            
        
        
    }catch (SQLException ex) {
            Logger.getLogger(LettreMotivationDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        
    }ConnexionBD.closeConnection();
        return lettre;     }

    @Override
    public boolean create(LettreMotivation lettre,Etudiant etu) {
              EtudiantDaoImpl daoEtu=new EtudiantDaoImpl();
         boolean retour = false;
        int nbLigne = 0;
        PreparedStatement ps;
        try {
            ps = ConnexionBD.getConnection().prepareStatement(SQL_INSET);

         
            ps.setString(1, lettre.getContenu());
            ps.setString(2, lettre.getTitre());
          

            daoEtu.updateLettre(etu,lettre);

            nbLigne = ps.executeUpdate();

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            Logger.getLogger(LettreMotivationDaoImpl.class.getName()).log(Level.SEVERE, null, e);
        }
        if (nbLigne > 0) {
            retour = true;
        }
        ConnexionBD.closeConnection();
        return retour;    }

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
        return retour; }

    @Override
    public boolean update(LettreMotivation lettre) {
       boolean retour = false;
        int nbLigne = 0;
        PreparedStatement ps;
        try {
            ps = ConnexionBD.getConnection().prepareStatement(SQL_UPDATE);
           
             ps.setString(1, lettre.getContenu());
            ps.setString(2, lettre.getTitre());
     
            ps.setInt(3, lettre.getId());
        
            

            nbLigne = ps.executeUpdate();

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            Logger.getLogger(LettreMotivationDaoImpl.class.getName()).log(Level.SEVERE, null, e);
        }
        if (nbLigne > 0) {
            retour = true;
        }
        ConnexionBD.closeConnection();
        return retour;  }
    
}
