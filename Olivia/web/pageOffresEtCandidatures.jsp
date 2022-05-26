<%-- 
    Document   : pageOffresEtCandidatures
    Created on : 20-May-2022, 8:09:58 AM
    Author     : LysAd
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="com.model.entities.Offre"%>
<%@page import="java.util.List"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/style.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.1/css/all.min.css" integrity="sha512-KfkfwYDsLkIlwQp6LFnl8zNdLGxu9YAA1QvwINks4PhcElQSvqcyVLLD9aMhXd13uQjoXtEKNosOWaZqXgel0g==" crossorigin="anonymous" referrerpolicy="no-referrer" />
        <title>Pages d'offres et candidatures</title>
    </head>
    <body class="wrapper">

        <div class="wrapper-header">
            <jsp:include page="header.jsp"/>
        </div>
        <div class="wrapper-side">
            <jsp:include page="sidenav.jsp"/>
        </div>

        <main class="contenuPrincipal wrapper-main-content">
            
            <h1>VOS OFFRES ET CANDIDATURES</h1>
            <table class="tbd-table">
                <thead>
                    <tr>
                        <th>Nom du poste</th>
                        <th>Description</th>
                        <th>Rémuneration($/Heure)</th>
                        <th>Candidatures</th>
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
                            <a href="listeCandidaturesPourOffre?idOffre=<%=lesOffre.get(i).getId()%>" >
                                <i style='color:#3C8D93;' class="fa-solid fa-up-right-from-square"></i> 
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
