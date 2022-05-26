/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mv2.controllers;

import com.action.EtudiantAction;
import com.action.PostulationAction;
import com.dao.etudiant.EtudiantDaoImpl;
import com.model.entities.Etudiant;
import com.model.entities.Postulation;
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
public class StagePostuler extends HttpServlet {

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
      response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        /* TODO output your page here. You may use following sample code. */
        HttpSession session = request.getSession(true);
        EtudiantDaoImpl daoEtud = new EtudiantDaoImpl();
        EtudiantAction action=new EtudiantAction();
        int id=(int) session.getAttribute("id");
        List<Etudiant> listeEtudiant =action.findAllEtudiant();
        System.out.println(listeEtudiant+"============================="); 
        List<Postulation> lesPostulation=new  ArrayList<Postulation>() ;
        
        for(int i = 0; listeEtudiant.size()>i;i++){
            
            Etudiant etudiant=listeEtudiant.get(i);
            List<Postulation> post  =PostulationAction.trouverToutLesPostulationsDUnEtudiant(etudiant);  
            lesPostulation.addAll(post);   
        
        }
         
        session.setAttribute("listePostulations", lesPostulation);
                session.setAttribute("etudiant", listeEtudiant);

        request.getRequestDispatcher("SatgeAll.jsp").forward(request, response);

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
