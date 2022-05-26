/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mv2.controllers;

import com.dao.admin.AdminDaoImpl;
import com.dao.compte.CompteDaoImpl;
import com.dao.cv.CvDaoImpl;
import com.dao.entreprise.EntrepriseDaoImpl;
import com.dao.etudiant.EtudiantDaoImpl;
import com.dao.offre.OffreDaoImpl;
import com.dao.professeur.ProfesseurDaoImpl;
import com.model.entities.Admin;
import com.model.entities.Compte;
import com.model.entities.Entreprise;
import com.model.entities.Etudiant;
import com.model.entities.Offre;
import com.model.entities.Professeur;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author LysAd
 */
public class Connexion extends HttpServlet {

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
        boolean connexion = false;

        //On prend les paramètres du formulaire de connexion.
        String courriel = request.getParameter("courriel");
        String mdp = request.getParameter("mdp");
        String sauvegarde = request.getParameter("sauvegarde");

        //Verification Admin 
        CompteDaoImpl daoCompte = new CompteDaoImpl();
        Compte compteConnexion;
        ProfesseurDaoImpl daoProf = new ProfesseurDaoImpl();
        EtudiantDaoImpl daoEtudiant = new EtudiantDaoImpl();
        AdminDaoImpl daoAdmin = new AdminDaoImpl();
         OffreDaoImpl daoOffre = new OffreDaoImpl();
         
        EntrepriseDaoImpl daoEntre = new EntrepriseDaoImpl();
        compteConnexion = daoCompte.isExiste(courriel, mdp);

        if (compteConnexion != null) {
            HttpSession session = request.getSession(true);
            connexion = true;
            
            switch (compteConnexion.getTypeCompte().toLowerCase()) {
                case "etudiant":

                    Etudiant etudiant = daoEtudiant.findByIdCompte(compteConnexion.getId());
                    System.out.println(etudiant.getCv());
                    session.setAttribute("id",etudiant.getId());
                    session.setAttribute("cv",etudiant.getCv());
                    session.setAttribute("typeCompte", compteConnexion.getTypeCompte());
                    session.setAttribute("email", courriel);
                    session.setAttribute("nom", etudiant.getNom());
                    session.setAttribute("prenom", etudiant.getPrenom());
                    session.setAttribute("numDA", etudiant.getNumeroDa());
                    
                    break;
                case "professeur":
                    Professeur professeur = daoProf.findByIdCompte(compteConnexion.getId());
                    session.setAttribute("typeCompte", compteConnexion.getTypeCompte());
                    session.setAttribute("email", courriel);
                    session.setAttribute("nom", professeur.getNom());
                    session.setAttribute("prenom", professeur.getPrenom());
                    break;
                case "entreprise":
                    Entreprise entreprise = daoEntre.findByIdCompte(compteConnexion.getId());
                    session.setAttribute("typeCompte", compteConnexion.getTypeCompte());
                    session.setAttribute("email", courriel);
                     session.setAttribute("id", entreprise.getId());
                    session.setAttribute("nom", entreprise.getNom());
                    session.setAttribute("description", entreprise.getDescription());
                    session.setAttribute("personneReference", entreprise.getPersonneReference());
                    ArrayList<Offre>lesOffres =(ArrayList<Offre>)daoOffre.findByIdEntreprise(entreprise.getId());
                  
                    session.setAttribute("lesOffres", lesOffres);
                    break;
                case "admin":
                    Admin admin = daoAdmin.findByIdCompte(compteConnexion.getId());
                    session.setAttribute("typeCompte", compteConnexion.getTypeCompte());
                    session.setAttribute("email", courriel);
                    session.setAttribute("nom", admin.getNom());
                    session.setAttribute("prenom", admin.getPrenom());

                    break;
            }
            if (sauvegarde != null) {
                if (sauvegarde.equals("yes")) {
                    Cookie courrielCookie = new Cookie("courriel", courriel);
                    Cookie mdpCookie = new Cookie("mdp", mdp);
                    courrielCookie.setMaxAge(60 * 60);//1 heure (60 x 60secs)
                    mdpCookie.setMaxAge(60 * 60);
                    response.addCookie(courrielCookie);
                    response.addCookie(mdpCookie);
                }
            }
            request.getRequestDispatcher("homePage.jsp").forward(request, response);

        }

        if (!connexion) {
            out.println("<center>"
                    + "<p style='color:Tomato;padding-top:10px'>"
                    + " ---------------------->>>            Oops! Le compte entrée n'existe pas.         <<<----------------------"
                    + "</p> "
                    + "</center>"
            );

            request.getRequestDispatcher("pageConnexion.jsp").include(request, response);
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
