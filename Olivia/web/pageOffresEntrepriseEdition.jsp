<%-- 
    Document   : pageOffresEntrepriseEdition
    Created on : 10-May-2022, 6:28:43 PM
    Author     : LysAd
--%>

<%@page import="com.model.entities.Offre"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/style.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.1/css/all.min.css" integrity="sha512-KfkfwYDsLkIlwQp6LFnl8zNdLGxu9YAA1QvwINks4PhcElQSvqcyVLLD9aMhXd13uQjoXtEKNosOWaZqXgel0g==" crossorigin="anonymous" referrerpolicy="no-referrer" />
        <title>Nouvel offre</title>
    </head>
    <body class="wrapper">

        <div class="wrapper-header">
            <jsp:include page="header.jsp"/>
        </div>
        <div class="wrapper-side">
            <jsp:include page="sidenav.jsp"/>
        </div>

        <main class="contenuPrincipal wrapper-main-content">
            <div class="page-offre-ent-titre">
                <h1>Vos offres d'emploi</h1>
                <div class="page-offre-ent-btns">
                    <a href="pageOffresEntreprise.jsp" class="page-offre-ent-btns-1">Retour</a>
                </div>
            </div>
            <hr>
            <table class="tbd-table">
                <thead>
                    <tr>
                        <th>Nom du poste</th>
                        <th>Description</th>
                        <th>Rémuneration($/Heure)</th>
                        <th>Modifier</th>
                        <th>Supprimer</th>
                    </tr>
                </thead>
                <tbody>

                    <%
                        List<Offre> lesOffre = (ArrayList<Offre>) session.getAttribute("lesOffres");
                        if (lesOffre != null) {
                            if (lesOffre.size() == 0) {
                    %>
                    <tr>
                        <td>Aucun poste.</td>
                        <td>Aucune description.</td>
                        <td>N/A</td>
                    </tr>
                    <%} else if (lesOffre.size() > 0) {
                        for (int i = 0; lesOffre.size() > i; i++) {
                    %>
                    <tr>
                        <td><%=lesOffre.get(i).getPoste()%> </td>
                        <td><%=lesOffre.get(i).getDescription()%></td>
                        <td style='text-align: center;vertical-align: middle;'>
                            <%=lesOffre.get(i).getRemuneration()%>
                        </td>
                        <td style='text-align: center;vertical-align: middle;'>
                            <a href="modifierOffreEntreprise?id=<%=lesOffre.get(i).getId()%>" >
                                <i class="edit-icon fa-solid fa-pen"></i>
                            </a>
                        </td>
                        <td style='text-align: center;vertical-align: middle;'>
                            <a href="supprimerOffreEntreprise?id=<%=lesOffre.get(i).getId()%>">
                                <i class="delete-icon fa-solid fa-trash-can"></i>
                            </a>
                        </td>
                    </tr>
                    <%}%>
                    <%} else {%>
                    <tr>
                        <td>Aucun poste.</td>
                        <td>Aucune description.</td>
                        <td>N/A</td>
                    </tr>
                    <%}%>
                    <%}%>
                </tbody>
            </table>    
        </main>

    </body>
</html>
