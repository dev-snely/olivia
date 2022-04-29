/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dao.etudiant;

import com.dao.compte.CompteDaoImpl;

import com.dao.cv.CvDaoImpl;
import com.dao.lettreMotivation.LettreMotivationDaoImpl;
import com.dao.occupation.OccupationDaoImpl;
import com.model.entities.CV;
import com.model.entities.Compte;
import com.model.entities.Etudiant;
import com.model.entities.LettreMotivation;
import com.model.entities.Occupation;
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
    private static final String SQL_SELECT_PAR_NOM = "select * from etudiant where Nom = ?";
    private static final String SQL_SELECT_PAR_PRENOM = "select * from etudiant where Prenom = ?";
    private static final String SQL_SELECT_PAR_NUMERODA = "select * from etudiant where NumeroDA = ?";
    private static final String SQL_INSET = "insert into etudiant(Nom,Prenom,NumeroDA,Compte_IdCompte) value(?,?,?,?)";
    private static final String SQL_UPDATE = "update etudiant set Nom =?,Prenom = ? where IdEtudiant = ?";
    private static final String SQL_UPDATE_CV = "update etudiant set CV_IdCV =? where IdEtudiant = ?";
    private static final String SQL_UPDATE_LETTRE = "update etudiant set LettreMotivation_IdLettreMotivation =? where IdEtudiant = ?";
    private static final String SQL_UPDATE_OCCUPATION = "update etudiant set Occupation_IdOccupation =? where IdEtudiant = ?";
    private static final String SQL_DELETE = "delete from etudiant where IdEtudiant = ?";
    CompteDaoImpl daoCompte = new CompteDaoImpl();
    CvDaoImpl daocv = new CvDaoImpl();
    LettreMotivationDaoImpl daoLettre = new LettreMotivationDaoImpl();
    OccupationDaoImpl daoOccup = new OccupationDaoImpl();

    @Override
    public List<Etudiant> findAll() {
        List<Etudiant> listeEtu = null;

        try {
            //Initialise la requête préparée basée sur la connexion 
            // la requête SQL passé en argument pour construire l'objet preparedStatement
            PreparedStatement ps = ConnexionBD.getConnection().prepareStatement(SQL_SELECT);
            //On execute la requête et on récupère les résultats dans la requête 
            // dans ResultSet
            ResultSet result = ps.executeQuery();
            listeEtu = new ArrayList<>();

            //// la méthode next() pour se déplacer sur l'enregistrement suivant
            //on parcours ligne par ligne les résultas retournés
            while (result.next()) {
                //on enregistre les données dans un entities (bean, classe java)
                Etudiant etu = new Etudiant();
                etu.setId(result.getInt("IdEtudiant"));
                etu.setNom(result.getString("Nom"));
                etu.setPrenom(result.getString("Prenom"));
                etu.setNumeroDa(result.getInt("NumeroDA"));
                if (daocv.findById(result.getInt("CV_IdCV")) != null) {
                    etu.setCv(daocv.findById(result.getInt("CV_IdCV")));
                }
                if (daoLettre.findById(result.getInt("LettreMotivation_IdLettreMotivation")) != null) {
                    etu.setLettre(daoLettre.findById(result.getInt("LettreMotivation_IdLettreMotivation")));
                }

                etu.setCompte(daoCompte.findById(result.getInt("Compte_IdCompte")));

                listeEtu.add(etu);
            }
        } catch (SQLException ex) {
            Logger.getLogger(EtudiantDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        ConnexionBD.closeConnection();
        return listeEtu;
    }

    @Override
    public Etudiant findById(int id) {
        Etudiant etu = new Etudiant();
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
                etu.setId(result.getInt("IdEtudiant"));
                etu.setNom(result.getString("Nom"));
                etu.setPrenom(result.getString("Prenom"));
                etu.setNumeroDa(result.getInt("NumeroDA"));
                if (daocv.findById(result.getInt("CV_IdCV")) != null) {
                    etu.setCv(daocv.findById(result.getInt("CV_IdCV")));
                }
                if (daoLettre.findById(result.getInt("LettreMotivation_IdLettreMotivation")) != null) {
                    etu.setLettre(daoLettre.findById(result.getInt("LettreMotivation_IdLettreMotivation")));
                }

                etu.setCompte(daoCompte.findById(result.getInt("Compte_IdCompte")));
            }

        } catch (SQLException ex) {
            Logger.getLogger(EtudiantDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        ConnexionBD.closeConnection();
        return etu;
    }

    @Override
    public List<Etudiant> findByNom(String nom) {
        List<Etudiant> listeEtu = null;
        try {
            //Initialise la requête préparée basée sur la connexion 
            // la requête SQL passé en argument pour construire l'objet preparedStatement
            PreparedStatement ps = ConnexionBD.getConnection().prepareStatement(SQL_SELECT_PAR_NOM);
            //On execute la requête et on récupère les résultats dans la requête 
            // dans ResultSet
            ps.setString(1, nom);
            ResultSet result = ps.executeQuery();
            listeEtu = new ArrayList<>();
            //// la méthode next() pour se déplacer sur l'enregistrement suivant
            //on parcours ligne par ligne les résultas retournés
            while (result.next()) {
                //on enregistre les données dans un entities (bean, classe java)

                Etudiant etu = new Etudiant();
                etu.setId(result.getInt("IdEtudiant"));
                etu.setNom(result.getString("Nom"));
                etu.setPrenom(result.getString("Prenom"));
                etu.setNumeroDa(result.getInt("NumeroDA"));
                if (daocv.findById(result.getInt("CV_IdCV")) != null) {
                    etu.setCv(daocv.findById(result.getInt("CV_IdCV")));
                }
                if (daoLettre.findById(result.getInt("LettreMotivation_IdLettreMotivation")) != null) {
                    etu.setLettre(daoLettre.findById(result.getInt("LettreMotivation_IdLettreMotivation")));
                }

                etu.setCompte(daoCompte.findById(result.getInt("Compte_IdCompte")));

                listeEtu.add(etu);

            }
        } catch (SQLException ex) {
            Logger.getLogger(EtudiantDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        ConnexionBD.closeConnection();
        return listeEtu;
    }

    @Override
    public List<Etudiant> findByPrenom(String prenom) {
        List<Etudiant> listeEtu = null;
        try {
            //Initialise la requête préparée basée sur la connexion 
            // la requête SQL passé en argument pour construire l'objet preparedStatement
            PreparedStatement ps = ConnexionBD.getConnection().prepareStatement(SQL_SELECT_PAR_PRENOM);
            //On execute la requête et on récupère les résultats dans la requête 
            // dans ResultSet
            ps.setString(1, prenom);
            ResultSet result = ps.executeQuery();
            listeEtu = new ArrayList<>();
            //// la méthode next() pour se déplacer sur l'enregistrement suivant
            //on parcours ligne par ligne les résultas retournés
            while (result.next()) {
                //on enregistre les données dans un entities (bean, classe java)
                Etudiant etu = new Etudiant();
                etu.setId(result.getInt("IdEtudiant"));
                etu.setNom(result.getString("Nom"));
                etu.setPrenom(result.getString("Prenom"));
                etu.setNumeroDa(result.getInt("NumeroDA"));
                if (daocv.findById(result.getInt("CV_IdCV")) != null) {
                    etu.setCv(daocv.findById(result.getInt("CV_IdCV")));
                }
                if (daoLettre.findById(result.getInt("LettreMotivation_IdLettreMotivation")) != null) {
                    etu.setLettre(daoLettre.findById(result.getInt("LettreMotivation_IdLettreMotivation")));
                }

                etu.setCompte(daoCompte.findById(result.getInt("Compte_IdCompte")));

                listeEtu.add(etu);

            }
        } catch (SQLException ex) {
            Logger.getLogger(EtudiantDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        ConnexionBD.closeConnection();
        return listeEtu;
    }

    @Override
    public List<Etudiant> findByNumeroDA(int DA) {
        List<Etudiant> listeEtu = null;
        try {
            //Initialise la requête préparée basée sur la connexion 
            // la requête SQL passé en argument pour construire l'objet preparedStatement
            PreparedStatement ps = ConnexionBD.getConnection().prepareStatement(SQL_SELECT_PAR_NUMERODA);
            //On execute la requête et on récupère les résultats dans la requête 
            // dans ResultSet
            ps.setInt(1, DA);
            ResultSet result = ps.executeQuery();
            listeEtu = new ArrayList<>();
            //// la méthode next() pour se déplacer sur l'enregistrement suivant
            //on parcours ligne par ligne les résultas retournés
            while (result.next()) {
                //on enregistre les données dans un entities (bean, classe java)

                Etudiant etu = new Etudiant();
                etu.setId(result.getInt("IdEtudiant"));
                etu.setNom(result.getString("Nom"));
                etu.setPrenom(result.getString("Prenom"));
                etu.setNumeroDa(result.getInt("NumeroDA"));
                if (daocv.findById(result.getInt("CV_IdCV")) != null) {
                    etu.setCv(daocv.findById(result.getInt("CV_IdCV")));
                }
                if (daoLettre.findById(result.getInt("LettreMotivation_IdLettreMotivation")) != null) {
                    etu.setLettre(daoLettre.findById(result.getInt("LettreMotivation_IdLettreMotivation")));
                }

                etu.setCompte(daoCompte.findById(result.getInt("Compte_IdCompte")));

                listeEtu.add(etu);

            }
        } catch (SQLException ex) {
            Logger.getLogger(EtudiantDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        ConnexionBD.closeConnection();
        return listeEtu;
    }

    @Override
    public boolean create(Etudiant etu) {
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
            Logger.getLogger(EtudiantDaoImpl.class.getName()).log(Level.SEVERE, null, e);
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
            Logger.getLogger(EtudiantDaoImpl.class.getName()).log(Level.SEVERE, null, e);
        }

        //System.out.println("nb ligne " + nbLigne);
        if (nbLigne > 0) {
            retour = true;
        }
        ConnexionBD.closeConnection();
        return retour;
    }

    @Override
    public boolean updateCv(Etudiant etu, CV cv) {
        boolean retour = false;
        int nbLigne = 0;
        PreparedStatement ps;
        try {
            ps = ConnexionBD.getConnection().prepareStatement(SQL_UPDATE_CV);

            ps.setInt(1, cv.getId());

            ps.setInt(2, etu.getId());

            nbLigne = ps.executeUpdate();

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            Logger.getLogger(EtudiantDaoImpl.class.getName()).log(Level.SEVERE, null, e);
        }

        //System.out.println("nb ligne " + nbLigne);
        if (nbLigne > 0) {
            retour = true;
        }
        ConnexionBD.closeConnection();
        return retour;
    }

    @Override
    public boolean updateLettre(Etudiant etu, LettreMotivation lettre) {
        boolean retour = false;
        int nbLigne = 0;
        PreparedStatement ps;
        try {
            ps = ConnexionBD.getConnection().prepareStatement(SQL_UPDATE_LETTRE);

            ps.setInt(1, lettre.getId());
            ps.setInt(2, etu.getId());

            nbLigne = ps.executeUpdate();

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            Logger.getLogger(EtudiantDaoImpl.class.getName()).log(Level.SEVERE, null, e);
        }

        //System.out.println("nb ligne " + nbLigne);
        if (nbLigne > 0) {
            retour = true;
        }
        ConnexionBD.closeConnection();
        return retour;
    }

    @Override
    public boolean updateOccupation(Etudiant etu, Occupation occup) {
        boolean retour = false;
        int nbLigne = 0;
        PreparedStatement ps;
        try {
            ps = ConnexionBD.getConnection().prepareStatement(SQL_UPDATE_OCCUPATION);

            ps.setInt(1, occup.getId());
            ps.setInt(2, etu.getId());

            nbLigne = ps.executeUpdate();

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            Logger.getLogger(EtudiantDaoImpl.class.getName()).log(Level.SEVERE, null, e);
        }

        //System.out.println("nb ligne " + nbLigne);
        if (nbLigne > 0) {
            retour = true;
        }
        ConnexionBD.closeConnection();
        return retour;
    }
}
