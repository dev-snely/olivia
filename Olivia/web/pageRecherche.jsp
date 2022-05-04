<%-- 
    Document   : pageRecherche
    Created on : 2-May-2022, 8:07:36 PM
    Author     : LysAd
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="com.model.entities.Offre"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Recherche</title>
        <link rel="stylesheet" href="css/style.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.1/css/all.min.css" integrity="sha512-KfkfwYDsLkIlwQp6LFnl8zNdLGxu9YAA1QvwINks4PhcElQSvqcyVLLD9aMhXd13uQjoXtEKNosOWaZqXgel0g==" crossorigin="anonymous" referrerpolicy="no-referrer" />
    </head>
    <body>

        <jsp:include page="header.jsp"/>
        <jsp:include page="sidenav.jsp"/>

        <main class="contenuPrincipal">

            <h1>RECHERCHE</h1><br>
            <hr>
            <table class="tbd-table">
                <thead>
                    <tr>
                        <th>Nom du poste</th>
                        <th>Description</th>
                        <th>Rémuneration</th>
                        <th>Entreprise</th>
                    </tr>
                </thead>
                <tbody>

                    <%
                        List<Offre> lesOffre = (ArrayList<Offre>) session.getAttribute("listeOffres");
                        if (lesOffre != null) {
                            if (lesOffre.size() == 0) {
                    %>
                    <tr>
                        <td>Aucun poste.</td>
                        <td>Aucune description.</td>
                        <td>N/A</td>
                        <td>N/A</td>
                    </tr>
                    <%} else if (lesOffre.size() > 0) {
                        for (int i = 0; lesOffre.size() > i; i++) {
                    %>
                    <tr>
                        <td><%=lesOffre.get(i).getPoste()%> </td>
                        <td><%=lesOffre.get(i).getDescription()%></td>
                        <td><%=lesOffre.get(i).getRemuneration()%>$/Heure</td>
                        <td><%=lesOffre.get(i)%></td>
                    </tr>
                    <%}
                    } else {%>
                    <tr>
                        <td>Aucun poste.</td>
                        <td>Aucune description.</td>
                        <td>N/A</td>
                        <td>N/A</td>
                    </tr>
                    <%}%>
                    <%}%>
                </tbody>
            </table> 

        </main>

    </body>
</html>
