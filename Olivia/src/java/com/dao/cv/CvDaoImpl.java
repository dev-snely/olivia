/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dao.cv;

import com.dao.etudiant.EtudiantDaoImpl;
import com.model.entities.CV;
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
public class CvDaoImpl implements CvDao{
    private static final String SQL_SELECT = "select * from cv";
    private static final String SQL_SELECT_PAR_ID = "select * from cv where IdCV = ?";
    private static final String SQL_INSET = "insert into cv(Resume,ExperienceTravail,Education,Certification,Competence,Langue) value(?,?,?,?,?,?)";
    private static final String SQL_UPDATE = "update cv set Resume =?,ExperienceTravail = ?,Education = ?,Certification = ?,Competence = ?,Langue = ? where IdCV = ?";
    private static final String SQL_DELETE = "delete from cv where IdCV = ?";
    

    @Override
    public List<CV> findAll() {
      List<CV> listeCv = null;
       try {
            //Initialise la requête préparée basée sur la connexion 
            // la requête SQL passé en argument pour construire l'objet preparedStatement
            PreparedStatement ps = ConnexionBD.getConnection().prepareStatement(SQL_SELECT);
            //On execute la requête et on récupère les résultats dans la requête 
            // dans ResultSet
            ResultSet result = ps.executeQuery();
            listeCv = new ArrayList<>();
              //// la méthode next() pour se déplacer sur l'enregistrement suivant
            //on parcours ligne par ligne les résultas retournés
            while (result.next()) {
                //on enregistre les données dans un entities (bean, classe java)
                CV cv = new CV();
                cv.setId(result.getInt("IdCV"));
                cv.setCertification(result.getString("Certification"));
                cv.setCompetence(result.getString("Competence"));
                cv.setEducation(result.getString("Education"));
                cv.setExperienceTravail(result.getString("ExperienceTravail"));
                cv.setLangue(result.getString("Langue"));
                cv.setResume(result.getString("Resume"));

                listeCv.add(cv);
            }
       }catch (SQLException ex) {
            Logger.getLogger(CvDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
    }
       ConnexionBD.closeConnection();
        return listeCv;
    }

    @Override
    public CV findById(int id) {
            CV cv = null;
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
                cv = new CV();
               cv.setId(result.getInt("IdCV"));
                cv.setCertification(result.getString("Certification"));
                cv.setCompetence(result.getString("Competence"));
                cv.setEducation(result.getString("Education"));
                cv.setExperienceTravail(result.getString("ExperienceTravail"));
                cv.setLangue(result.getString("Langue"));
                cv.setResume(result.getString("Resume"));
            }
            
        
        
    }catch (SQLException ex) {
            Logger.getLogger(CvDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        
    }ConnexionBD.closeConnection();
        return cv;   }

    @Override
    public boolean create(CV cv,Etudiant etu) {
        EtudiantDaoImpl daoEtu=new EtudiantDaoImpl();
         boolean retour = false;
        int nbLigne = 0;
        PreparedStatement ps;
        try {
            ps = ConnexionBD.getConnection().prepareStatement(SQL_INSET);

         
            ps.setString(1, cv.getResume());
            ps.setString(2, cv.getExperienceTravail());
            ps.setString(3, cv.getEducation());
            ps.setString(4, cv.getCertification());
            ps.setString(5, cv.getCompetence());
            ps.setString(6, cv.getLangue());

            daoEtu.updateCv(etu,cv);

            nbLigne = ps.executeUpdate();

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            Logger.getLogger(CvDaoImpl.class.getName()).log(Level.SEVERE, null, e);
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
        return retour; }

    @Override
    public boolean update(CV cv) {
      boolean retour = false;
        int nbLigne = 0;
        PreparedStatement ps;
        try {
            ps = ConnexionBD.getConnection().prepareStatement(SQL_UPDATE);
           
             ps.setString(1, cv.getResume());
            ps.setString(2, cv.getExperienceTravail());
            ps.setString(3, cv.getEducation());
            ps.setString(4, cv.getCertification());
            ps.setString(5, cv.getCompetence());
            ps.setString(6, cv.getLangue());
            ps.setInt(7, cv.getId());
        
            

            nbLigne = ps.executeUpdate();

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            Logger.getLogger(CvDaoImpl.class.getName()).log(Level.SEVERE, null, e);
        }
        if (nbLigne > 0) {
            retour = true;
        }
        ConnexionBD.closeConnection();
        return retour;}
    
}
