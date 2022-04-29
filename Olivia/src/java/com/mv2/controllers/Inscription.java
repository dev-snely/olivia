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
import com.model.entities.Compte;
import com.model.entities.Entreprise;
import com.model.entities.Etudiant;
import com.model.entities.Professeur;
import java.io.IOException;
import java.io.PrintWriter;
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
        boolean inscription = false;
        //On prend les paramètres du formulaire de connexion.
        //Ici, c'est pour savoir il sagit de quel type de formulaire(etudiant,prof,entreprise)
        String typeacct = request.getParameter("typeForm");
        
        //Implementation du dao
        CompteDaoImpl daoCompte = new CompteDaoImpl();
        List<Compte> listeCompte= daoCompte.findAll();
        //J'ajoute le dao admin car les autre sont pas encore faite, mais la
        //demarche devrait être pareil
        //implementations de tous les DAOs
        EntrepriseDaoImpl entrepriseDao= new EntrepriseDaoImpl();
        AdminDaoImpl daoAdmin = new AdminDaoImpl();
        CvDaoImpl CVdao = new   CvDaoImpl();  
        EtudiantDaoImpl etudiantDao = new EtudiantDaoImpl();
        LettreMotivationDaoImpl lettreDao = new LettreMotivationDaoImpl();
        OccupationDaoImpl occupationDao = new OccupationDaoImpl();
        OffreDaoImpl offresDao = new OffreDaoImpl();
        PostulationDaoImpl postulationDao = new PostulationDaoImpl();
        ProfesseurDaoImpl profDao = new ProfesseurDaoImpl();
        PubliciteDaoImp pubDao = new PubliciteDaoImp();
       //Exemple pour admin, des que les autres sont implementés, c'est la même chose avec des if
       
       //Verifier si le email existe deja, car il doit être unique
        
          if(daoCompte.findByCourriel(request.getParameter("courriel")).equals(null)){
              if(typeacct.equals("Admin")){
                Admin admin = new Admin();
                Compte compte = new Compte();
             compte.setCourriel(request.getParameter("courriel"));
                compte.setPassword(request.getParameter("mdp"));
                compte.setTypeCompte("Admin");
            admin.setNom(request.getParameter("nom"));
            admin.setPrenom("prenom");
            admin.setCompte(compte);
            daoCompte.create(compte);
            daoAdmin.create(admin);
            request.setAttribute("succes", true);
            request.getRequestDispatcher("pageAccueil.jsp").forward(request, response);
                 //Entreprise
            }else if(typeacct.equals("Entreprise")){
                Entreprise Entreprise = new Entreprise();
                Compte compte = new Compte();
             compte.setCourriel(request.getParameter("courriel"));
                compte.setPassword(request.getParameter("mdp"));
                compte.setTypeCompte("Entr");
            Entreprise.setNom(request.getParameter("nom"));
            Entreprise.setCompte(compte);
            daoCompte.create(compte);
            
            request.setAttribute("succes", true);
            request.getRequestDispatcher("pageAccueil.jsp").forward(request, response);
                 
            }//Etudiant
            else if (typeacct.equals("Etudiant")){
                Etudiant etudiant = new Etudiant();
                Compte compte = new Compte();
                compte.setCourriel(request.getParameter("courriel"));
                compte.setPassword(request.getParameter("mdp"));
                compte.setTypeCompte("Etu");
                etudiant.setCompte(compte);
                etudiant.setNom(request.getParameter("nom"));
                etudiant.setPrenom(request.getParameter("prenom"));
                etudiant.setNumeroDa(Integer.valueOf(request.getParameter("numDA")));
                
                request.setAttribute("succes", true);
                request.getRequestDispatcher("pageAccueil.jsp").forward(request, response);
                
                
            }else if(typeacct.equals("Professeur")){
                Professeur LeProf = new Professeur();
                Compte compte = new Compte();
                compte.setCourriel(request.getParameter("courriel"));
                compte.setPassword(request.getParameter("mdp"));
                compte.setTypeCompte("Etu");
                LeProf.setCompte(compte);
                LeProf.setNom(request.getParameter("nom"));
                LeProf.setPrenom(request.getParameter("prenom"));
                LeProf.setNumeroDa(Integer.valueOf(request.getParameter("numDA")));
                
                request.setAttribute("succes", true);
                request.getRequestDispatcher("pageAccueil.jsp").forward(request, response);
                
            }
            
        }else{
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
