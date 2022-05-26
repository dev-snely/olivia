/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.mv2.controllers;

import com.dao.etudiant.EtudiantDaoImpl;
import com.dao.lettreMotivation.LettreMotivationDaoImpl;
import com.model.entities.Etudiant;
import com.model.entities.LettreMotivation;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Mahmo
 */
public class MettreAjourLettre extends HttpServlet {

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
            /* TODO output your page here. You may use following sample code. */
             EtudiantDaoImpl etudiantDao = new EtudiantDaoImpl();
             Etudiant letudiant = etudiantDao.findByNumeroDA((int) request.getSession().getAttribute("numDA"));
             LettreMotivation lettre = new LettreMotivation();
             lettre.setId(letudiant.getLettre().getId());
             lettre.setContenu(request.getParameter("contenuLettre"));
             lettre.setTitre(request.getParameter("titleLettre"));
             LettreMotivationDaoImpl daoLettre = new LettreMotivationDaoImpl();
             daoLettre.update(lettre);
            request.getRequestDispatcher("afficherLettreMotivation").forward(request, response);
        
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