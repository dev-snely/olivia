/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mv2.controllers;

import com.dao.admin.AdminDaoImpl;
import com.dao.entreprise.EntrepriseDaoImpl;
import com.dao.etudiant.EtudiantDaoImpl;
import com.dao.professeur.ProfesseurDaoImpl;
import com.model.entities.Admin;
import com.model.entities.Entreprise;
import com.model.entities.Etudiant;
import com.model.entities.Professeur;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author gabri
 */
public class Ajouter extends HttpServlet {

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
        request.getRequestDispatcher("Ajouter.jsp").forward(request, response);
        ArrayList<String> listCategory = new ArrayList<String>();
        HttpSession session = request.getSession(true);
         session.setAttribute("bool", "true");
        listCategory.add("etudiant");
        listCategory.add("entreprise");
        listCategory.add("professeur");
        listCategory.add("admin");
        session.setAttribute("listCategory", listCategory);
        
        //
        session.setAttribute("inscription", "etudiant");
        String inscription = request.getParameter("inscription"); 
        session.setAttribute("inscription", inscription);
        String compte = request.getParameter("inscription"); 
        String ajouter = request.getParameter("formulaire-ajouter");
        //
        
        switch (compte) {
            case "entreprise": {
                EntrepriseDaoImpl dao = new EntrepriseDaoImpl();
                List<Entreprise> listeEntreprise = dao.findAll();
                session.setAttribute("listCompte", listeEntreprise);
                session.setAttribute("bool", "false");
                break;
            }
            case "admin": {
                AdminDaoImpl dao = new AdminDaoImpl();
                List<Admin> listeAdmin = dao.findAll();
                session.setAttribute("listCompte", listeAdmin);
                session.setAttribute("bool", "false");
                break;
            }
            case "professeur": {
                ProfesseurDaoImpl dao = new ProfesseurDaoImpl();
                List<Professeur> listeProf = dao.findAll();
                session.setAttribute("listCompte", listeProf);
                session.setAttribute("bool", "false");
                break;
            }
            case "etudiant": {
                EtudiantDaoImpl dao = new EtudiantDaoImpl();
                List<Etudiant> listeEtu = dao.findAll();
                session.setAttribute("listCompte", listeEtu);
                session.setAttribute("bool", "false");
                break;
            }
            default:
                System.out.print("ne fonctionne pas");
                break;
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
