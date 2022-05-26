/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mv2.controllers.ctrlEnt;

import com.action.OffreAction;
import com.action.PostulationAction;
import com.model.entities.Offre;
import com.model.entities.Postulation;
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
public class AccepterCandidat extends HttpServlet {

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

        HttpSession session = request.getSession(false);
        int idEtudiant = Integer.parseInt(request.getParameter("idEtudiant"));
        int idOffre = Integer.parseInt(request.getParameter("idOffre"));

        Postulation p = PostulationAction.findPostulationParIdEtudiantEtIdOffre(idEtudiant, idOffre);
        p.setAcceptation(true);
        PostulationAction.MAJPostulationAcceptation(p, idEtudiant, idOffre);
        
        Offre offre = OffreAction.chercherOffreParId(idOffre);
        
        List<Postulation> listePost = PostulationAction.trouverToutLesPostulationsDUneOffre(offre);
        if (listePost == null || listePost.size() <= 0){
            session.setAttribute("lesCandidaturesVide", true);
        } else {
            session.setAttribute("lesCandidaturesVide", false);
            session.setAttribute("listeCandidatures", listePost);
            session.setAttribute("offreAuditionner", offre);
        }
        
        request.getRequestDispatcher("pageCandidatures.jsp").forward(request, response);
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
