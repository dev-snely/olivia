/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mv2.controllers;

import com.dao.admin.AdminDaoImpl;
import com.dao.compte.CompteDaoImpl;
import com.dao.entreprise.EntrepriseDaoImpl;
import com.dao.etudiant.EtudiantDaoImpl;
import com.dao.professeur.ProfesseurDaoImpl;
import com.model.entities.Admin;
import com.model.entities.Compte;
import com.model.entities.Entreprise;
import com.model.entities.Etudiant;
import com.model.entities.Professeur;
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
public class Modifier extends HttpServlet {

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

        HttpSession session = request.getSession(true);
        String typeCompte = request.getParameter("typeCompte");
        String CompteModifier = request.getParameter("modifier");

        if (request.getParameter("typeCompte") == null && CompteModifier == null) {
            session.setAttribute("retourDebut", true);
            session.setAttribute("retour", true);
        } else if (CompteModifier != null) {
            session.setAttribute("retour", true);
            session.setAttribute("retourDebut", false);
        } else {
            session.setAttribute("retour", false);
            session.setAttribute("retourDebut", false);
        }

        listCategory.add("etudiant");
        listCategory.add("entreprise");
        listCategory.add("professeur");
        listCategory.add("admin");
        session.setAttribute("listCategory", listCategory);

        CompteDaoImpl daoCompte = new CompteDaoImpl();
        ArrayList<Compte> Compte = (ArrayList) daoCompte.findByTypeCompte(typeCompte);
        session.setAttribute("compte", Compte);

        if (CompteModifier != null) {
            Compte unCompte = daoCompte.findById(Integer.parseInt(CompteModifier));

            switch (unCompte.getTypeCompte()) {
                case "etudiant": {
                    EtudiantDaoImpl dao = new EtudiantDaoImpl();
                    Etudiant CompteModi = dao.findByIdCompte(Integer.parseInt(CompteModifier));

                    session.setAttribute("CompteModi", CompteModi);
                    session.setAttribute("typeCompteModif", "etudiant");
                    break;
                }
                case "entreprise": {
                    EntrepriseDaoImpl dao = new EntrepriseDaoImpl();
                    Entreprise CompteModi = dao.findByIdCompte(Integer.parseInt(CompteModifier));
                    session.setAttribute("CompteModi", CompteModi);
                    session.setAttribute("typeCompteModif", "entreprise");
                    break;
                }
                case "admin": {
                    AdminDaoImpl dao = new AdminDaoImpl();
                    Admin CompteModi = dao.findByIdCompte(Integer.parseInt(CompteModifier));
                    session.setAttribute("CompteModi", CompteModi);
                    session.setAttribute("typeCompteModif", "admin");
                    break;
                }
                case "professeur": {
                    ProfesseurDaoImpl dao = new ProfesseurDaoImpl();
                    Professeur CompteModi = dao.findByIdCompte(Integer.parseInt(CompteModifier));
                    session.setAttribute("CompteModi", CompteModi);
                    session.setAttribute("typeCompteModif", "professeur");
                    break;
                }
                default:
                    break;
            }

        }
        String CompteAModifier = request.getParameter("CompteAModifier");

        if (CompteAModifier != null) {
            switch (CompteAModifier) {
                case "etudiant": {
                    String courriel = request.getParameter("Courriel");
                    String nom = request.getParameter("Nom");
                    String prenom = request.getParameter("Prenom");
                    int DA = Integer.parseInt(request.getParameter("DA"));
                    System.out.println("=========================" + DA);
                    int id = Integer.parseInt(request.getParameter("CompteId"));
                    EtudiantDaoImpl dao = new EtudiantDaoImpl();
                    CompteDaoImpl daoCompte1 = new CompteDaoImpl();
                    Etudiant EtudModi = dao.findById(id);
                    System.out.println("=========================" + EtudModi);
                    Compte compte = daoCompte1.findById(EtudModi.getCompte().getId());
                    compte.setCourriel(courriel);
                    EtudModi.setNom(nom);
                    EtudModi.setNumeroDa(DA);
                    EtudModi.setPrenom(prenom);
                    EtudModi.setCompte(compte);
                    dao.update(EtudModi);
                    daoCompte1.update(compte);
                    break;
                }
                case "entreprise": {
                    String courriel = request.getParameter("Courriel");
                    String nom = request.getParameter("Nom");
                    String personneReference = request.getParameter("personneReference");
                    String description = request.getParameter("description");
                    int id = Integer.parseInt(request.getParameter("CompteId"));
                    EntrepriseDaoImpl dao = new EntrepriseDaoImpl();
                    CompteDaoImpl daoCompte1 = new CompteDaoImpl();
                    Entreprise entreModi = dao.findById(id);

                    Compte compte = daoCompte1.findById(entreModi.getCompte().getId());
                    compte.setCourriel(courriel);
                    entreModi.setNom(nom);
                    entreModi.setPersonneReference(personneReference);
                    entreModi.setDescription(description);
                    entreModi.setCompte(compte);
                    dao.update(entreModi);
                    daoCompte1.update(compte);
                    break;

                }
                case "admin": {
                    String courriel = request.getParameter("Courriel");
                    String nom = request.getParameter("Nom");
                    String prenom = request.getParameter("Prenom");

                    int id = Integer.parseInt(request.getParameter("CompteId"));
                    AdminDaoImpl dao = new AdminDaoImpl();
                    CompteDaoImpl daoCompte1 = new CompteDaoImpl();
                    Admin adminModi = dao.findById(id);

                    Compte compte = daoCompte1.findById(adminModi.getCompte().getId());
                    compte.setCourriel(courriel);
                    adminModi.setNom(nom);

                    adminModi.setPrenom(prenom);
                    adminModi.setCompte(compte);
                    dao.update(adminModi);
                    daoCompte1.update(compte);
                    break;
                }
                case "professeur": {
                    String courriel = request.getParameter("Courriel");
                    String nom = request.getParameter("Nom");
                    String prenom = request.getParameter("Prenom");
                    int DA = Integer.parseInt(request.getParameter("DA"));

                    int id = Integer.parseInt(request.getParameter("CompteId"));
                    ProfesseurDaoImpl dao = new ProfesseurDaoImpl();
                    CompteDaoImpl daoCompte1 = new CompteDaoImpl();
                    Professeur profModi = dao.findById(id);

                    Compte compte = daoCompte1.findById(profModi.getCompte().getId());
                    compte.setCourriel(courriel);
                    profModi.setNom(nom);
                    profModi.setNumeroDa(DA);
                    profModi.setPrenom(prenom);
                    profModi.setCompte(compte);
                    dao.update(profModi);
                    daoCompte1.update(compte);
                    break;
                }
                default:
                    break;
            }
        }

        request.getRequestDispatcher("Modifier.jsp").forward(request, response);

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
