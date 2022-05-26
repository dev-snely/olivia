/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mv2.controllers;

import com.dao.compte.CompteDaoImpl;
import com.dao.admin.AdminDaoImpl;
import com.dao.cv.CvDaoImpl;
import com.dao.entreprise.EntrepriseDaoImpl;
import com.dao.etudiant.EtudiantDaoImpl;
import com.dao.lettreMotivation.LettreMotivationDaoImpl;
import com.dao.occupation.OccupationDaoImpl;
import com.dao.offre.OffreDaoImpl;
import com.dao.postulation.PostulationDaoImpl;
import com.dao.professeur.ProfesseurDaoImpl;
import com.dao.publicite.PubliciteDaoImp;
import com.model.entities.Admin;
import com.model.entities.CV;
import com.model.entities.Compte;
import com.model.entities.Entreprise;
import com.model.entities.Etudiant;
import com.model.entities.LettreMotivation;
import com.model.entities.Occupation;
import com.model.entities.Offre;
import com.model.entities.Professeur;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Mahmo
 */
public class Inscription extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        //Valeurs permettant de valider l'inscription
        boolean creation1 = false;
        boolean creation2 = false;
        boolean inscription = false;

        //On prend les paramètres du formulaire de connexion.
        //Typeacct est pour savoir il sagit de quel type d'entité
        //provient le formulaire(etudiant,prof,entreprise)
        String nom = request.getParameter("nom");
        String prenom = request.getParameter("prenom");
        String courriel = request.getParameter("courriel");
        String mdp = request.getParameter("mdp");
        String numDA = request.getParameter("numDA");
        String typeacct = request.getParameter("typeForm");

        //Implementation des daos pouvant 
        //s'inscrire : Etudiant, Professeur & Entreprise
        CompteDaoImpl daoCompte = new CompteDaoImpl();
        AdminDaoImpl daoAdmin = new AdminDaoImpl();
        EtudiantDaoImpl etudiantDao = new EtudiantDaoImpl();
        ProfesseurDaoImpl profDao = new ProfesseurDaoImpl();
        EntrepriseDaoImpl entrepriseDao = new EntrepriseDaoImpl();

        List<Compte> listeCompte = daoCompte.findAll();
        //Objet Compte à créer dans la BDD
        Compte compteACreer = new Compte(courriel, mdp, typeacct);

        //Verifier si le compte existe deja dans les comptes de la BD, car il doit être unique
        if (!listeCompte.contains(compteACreer)) {
            switch (typeacct) {
                case "Admin": {
                    creation1 = daoCompte.create(compteACreer);
                    Admin unAdmin = new Admin();
                    unAdmin.setCompte(daoCompte.findByCourriel(courriel));
                    unAdmin.setNom(nom);
                    unAdmin.setPrenom(prenom);
                    creation2 = daoAdmin.create(unAdmin);
                    if (creation1 && creation2) {
                        inscription = true;
                        request.setAttribute("succes", inscription);
                    }
                    break;
                }
                case "Entreprise": {
                    creation1 = daoCompte.create(compteACreer);
                    Entreprise ent = new Entreprise();
                    ent.setCompte(daoCompte.findByCourriel(courriel));
                    ent.setNom(nom);
                    ent.setDescription("Aucune description.");
                    ent.setPersonneReference("Aucune personne de référence.");
                    creation2 = entrepriseDao.create(ent);
                    if (creation1 && creation2) {
                        inscription = true;
                        request.setAttribute("succes", inscription);
                    }
                    break;
                }
                case "Etudiant": {
                    CvDaoImpl daoCV =new CvDaoImpl();
                    LettreMotivation lettre=new LettreMotivation("","");
                    CV cv =new CV("","","","","","");
                    LettreMotivationDaoImpl daoLettre =new LettreMotivationDaoImpl();
                    Offre offre=new Offre();
                    Occupation occup=new Occupation("","",offre);
                    creation1 = daoCompte.create(compteACreer);
                    Etudiant etudiant = new Etudiant();
                    etudiant.setCompte(daoCompte.findByCourriel(courriel));
                    etudiant.setNom(nom);
                    etudiant.setPrenom(prenom);
                    etudiant.setNumeroDa(Integer.valueOf(numDA));
                     daoCV.create(cv,etudiant);
                     daoLettre.create(lettre, etudiant);
                    ArrayList<CV> listeCv=(ArrayList<CV>) daoCV.findAll();
                    ArrayList<LettreMotivation> LettreMotivations=(ArrayList<LettreMotivation>) daoLettre.findAll();
                    
                    cv=listeCv.get(LettreMotivations.size()-1);
                    lettre=LettreMotivations.get(LettreMotivations.size()-1);
                   
                    System.out.println("------------"+lettre.getId());
                     System.out.println("------------"+cv.getId());
                    creation2 = etudiantDao.create(etudiant);
                    etudiant=etudiantDao.findByNumeroDA(etudiant.getNumeroDa());
                    boolean bool1= etudiantDao.updateLettre(etudiant,lettre);
                    boolean bool2= etudiantDao.updateCv(etudiant, cv);
                    System.out.println("------------"+bool1+bool2);
                    if (creation1 && creation2) {
                        inscription = true;
                        request.setAttribute("succes", inscription);
                    }
                    break;
                }
                case "Professeur": {
                    creation1 = daoCompte.create(compteACreer);
                    Professeur leProf = new Professeur();
                    leProf.setCompte(daoCompte.findByCourriel(courriel));
                    leProf.setNom(nom);
                    leProf.setPrenom(prenom);
                    leProf.setNumeroDa(Integer.valueOf(numDA));
                    creation2 = profDao.create(leProf);
                    if (creation1 && creation2) {
                        inscription = true;
                        request.setAttribute("succes", inscription);
                    }
                    break;
                }
                default:
                    break;
            }
            request.getRequestDispatcher("pageAccueil.jsp").forward(request, response);
            
        } else if (inscription == false) {
            request.setAttribute("succes", false);
            request.getRequestDispatcher("pageAccueil.jsp").forward(request, response);
        }

    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
