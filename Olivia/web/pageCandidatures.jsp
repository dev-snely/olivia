<%-- 
    Document   : pageCandidatures
    Created on : 20-May-2022, 9:14:09 AM
    Author     : LysAd
--%>

<%@page import="com.model.entities.Offre"%>
<%@page import="com.model.entities.Postulation"%>
<%@page import="java.util.List"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Candidatures</title>
        <link rel="stylesheet" href="css/style.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.1/css/all.min.css" integrity="sha512-KfkfwYDsLkIlwQp6LFnl8zNdLGxu9YAA1QvwINks4PhcElQSvqcyVLLD9aMhXd13uQjoXtEKNosOWaZqXgel0g==" crossorigin="anonymous" referrerpolicy="no-referrer" />
    </head>
    <body class="wrapper">

        <div class="wrapper-header">
            <jsp:include page="header.jsp"/>
        </div>
        <div class="wrapper-side">
            <jsp:include page="sidenav.jsp"/>
        </div>

        <main class="contenuPrincipal wrapper-main-content">

            <%
                if ((boolean) request.getAttribute("lesCandidaturesVide") == true) {
            %>
            <h2>Aucune candidature n'a été déposée sur cet offre pour le moment...</h2>
            <img alt="boite-vide" src="images/empty-box.png" >

            <%
            } else if ((boolean) request.getAttribute("lesCandidaturesVide") == false) {
            %>
            <h1>Candidatures<h1>
                    <p>Vous pouvez mener vos entrevues avec les candidats en accédant au lien du CV.</p>
                    <h2>Infos sur le poste<h2>
                            <hr><br>
                            <%
                                Offre offre = (Offre) request.getAttribute("offreAuditionner");
                                List<Postulation> listePost = (List<Postulation>) request.getAttribute("listeCandidatures");

                            %>

                                <ul class='text-normal'> 
                                    <li>Nom du poste : <%=offre.getPoste()%></li>
                                    <li>Description du poste:<br><%=offre.getDescription()%></li>
                                    <li>Renumeration du poste:<%=offre.getRemuneration()%>(S/heure)</li>
                                </ul>
                                  
                            <br>
                    <h2>Les candidats</h2>
                    <hr>
                    <table class="tbd-table">
                        <thead>
                            <tr>
                                <th>Nom du candidat</th>
                                <th>Prenom du candidat</th>
                                <th>Numero DA</th>
                                <th>Courriel</th>
                                <th>Lien CV</th>
                            </tr>
                        </thead>
                        <tbody>
                            <% for (Postulation p : listePost) {%>

                            <tr>
                                <td><%=p.getEtudiant().getNom()%></td>
                                <td><%=p.getEtudiant().getPrenom()%></td>
                                <td><%=p.getEtudiant().getNumeroDa()%></td>
                                <td><%=p.getEtudiant().getCompte().getCourriel()%></td>
                                <td>
                                    <%if (p.getEtudiant().getCv() == null) {%>
                                        L'etudiant n'a pas de CV pour le moment.
                                    <%} else {%>
                                    <a href="afficherPageCvEtudiant?idEtudiant=<%=p.getEtudiant().getId()%>"><i style='color:#3C8D93;' class="fa-solid fa-up-right-from-square"></i></a>
                                    <%}%>
                                </td>
                            </tr>

                            <%}%>
                        </tbody>
                        <%
                            
                    }
                        %>
                        </main>

                        </body>
                        </html>
