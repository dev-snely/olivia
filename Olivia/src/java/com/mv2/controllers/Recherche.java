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
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author LysAd
 */
public class Recherche extends HttpServlet {

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

        //Afficher les offres d'emploi de tout les entreprises
        //dans une liste d'offre vide.
        List<Offre> listeToutOffre = new ArrayList();

        //Daos nécessaires
        OffreDaoImpl daoOffre = new OffreDaoImpl();
        CompteDaoImpl daoCompte = new CompteDaoImpl();
        EntrepriseDaoImpl daoEntr = new EntrepriseDaoImpl();

        //Chercher la liste d'offre de chaque entreprises
        //& ajouter dans la liste les offres.
        List<Entreprise> listeEntr = daoEntr.findAll();
        for (Entreprise ent : listeEntr){
            List<Offre> listeOffreEnt = daoOffre.findByIdEntreprise(ent.getId());
            for (Offre offre : listeOffreEnt){
                listeToutOffre.add(offre);
            }
        }
        
        HttpSession session = request.getSession(false);
        session.setAttribute("listeOffres", listeToutOffre);   
        
        request.getRequestDispatcher("pageRecherche.jsp").forward(request, response);
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
