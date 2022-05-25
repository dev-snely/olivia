/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mv2.controllers;

import com.dao.entreprise.EntrepriseDaoImpl;
import com.dao.publicite.PubliciteDaoImp;
import com.model.entities.Entreprise;
import com.model.entities.Publicite;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;



/**
 *
 * @author gabri
 */

    @MultipartConfig(
  fileSizeThreshold = 1024 * 1024 * 1, // 1 MB
  maxFileSize = 1024 * 1024 * 10,      // 10 MB
  maxRequestSize = 1024 * 1024 * 100   // 100 MB
)
public class FairePub extends HttpServlet {


    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
 HttpSession session = request.getSession(true);
    int id=(int)session.getAttribute("id");
    Part filePart = request.getPart("file");
      String fileName = filePart.getSubmittedFileName();
    String file=("/images/")+ fileName;
    String description =request.getParameter("description");

 
       PubliciteDaoImp dao=new PubliciteDaoImp();
       EntrepriseDaoImpl daoEntr=new EntrepriseDaoImpl();
       Publicite pub = new Publicite(description,file);
       System.out.println(pub);
       Entreprise ent =daoEntr.findById(id);
        dao.create(pub, ent);      
  

   
   request.getRequestDispatcher("fairePub.jsp").forward(request, response);
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
          /* Receive file uploaded to the Servlet from the HTML5 form */
    Part filePart = request.getPart("file");
      String fileName = filePart.getSubmittedFileName();
    for (Part part : request.getParts()) {
        //je n'ai pas trouver un path relatif malheureusement
      part.write("C:\\Users\\gabri\\Desktop\\Netbeans\\web-2-projet-de-session\\Olivia\\web\\images\\" + fileName);
    }
    response.getWriter().print("The file uploaded sucessfully.");
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
