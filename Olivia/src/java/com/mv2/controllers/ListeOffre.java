/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mv2.controllers;

import com.dao.compte.CompteDaoImpl;
import com.dao.entreprise.EntrepriseDaoImpl;
import com.dao.offre.OffreDaoImpl;
import com.model.entities.Compte;
import com.model.entities.Entreprise;
import com.model.entities.Offre;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author LysAd
 */
public class ListeOffre extends HttpServlet {

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
        
        //Daos nécessaires
        OffreDaoImpl daoOffre = new OffreDaoImpl();
        CompteDaoImpl daoCompte = new CompteDaoImpl();
        EntrepriseDaoImpl daoEntr = new EntrepriseDaoImpl();
        
        //Infos de l'entreprise connecté
        HttpSession session = request.getSession(false);
        String courriel = (String) session.getAttribute("email");
        Compte compteEntre = daoCompte.findByCourriel(courriel);
        Entreprise entreprise = daoEntr.findByIdCompte(compteEntre.getId());
        
        //Recuperation des offres de l'entreprise connecté
        List<Offre> listeOffres = daoOffre.findByIdEntreprise(entreprise.getId());
        
        session.setAttribute("listeOffres", listeOffres);   
        
        request.getRequestDispatcher("pageOffresEntreprise.jsp").forward(request, response);
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
