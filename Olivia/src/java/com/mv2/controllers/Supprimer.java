/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mv2.controllers;

import com.dao.compte.CompteDaoImpl;
import com.model.entities.Compte;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author gabri
 */
public class Supprimer extends HttpServlet {

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

        ArrayList<String> listCategory = new ArrayList<String>();
        String typeCompte = request.getParameter("typeCompte");
        HttpSession session = request.getSession(true);

        if (request.getParameter("typeCompte") == null) {
            session.setAttribute("retour", true);
        } else {
            session.setAttribute("retour", false);
        }

        listCategory.add("etudiant");
        listCategory.add("entreprise");
        listCategory.add("professeur");
        listCategory.add("admin");
        session.setAttribute("listCategory", listCategory);

        CompteDaoImpl dao = new CompteDaoImpl();
        ArrayList<Compte> Compte = (ArrayList) dao.findByTypeCompte(typeCompte);
        session.setAttribute("compte", Compte);
       

        String CompteSupprimer = request.getParameter("supprimer");
        if(CompteSupprimer!=null){
        dao.delete(Integer.parseInt(CompteSupprimer));      
        }
      
        request.getRequestDispatcher("Supprimer.jsp").forward(request, response);
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
