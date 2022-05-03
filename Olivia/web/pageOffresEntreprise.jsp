<%-- 
    Document   : pageOffresEntreprise
    Created on : 3-May-2022, 5:50:00 PM
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
        <title>JSP Page</title>
    </head>
    <body>
        <jsp:include page="header.jsp"/>
        <jsp:include page="sidenav.jsp"/>

        <main class="contenuPrincipal">
            <h1>Vos offres</h1>
            <hr>
            <table class="tbd-table">
                <thead>
                    <tr>
                        <th>Nom du poste</th>
                        <th>Description</th>
                        <th>Rémuneration</th>
                    </tr>
                </thead>
                <tbody>
                    
                    <% if(session.getAttribute("listeOffres") != null){%>
                    
                        <% List<Offre> lesOffre = (ArrayList<Offre>) session.getAttribute("listeOffres");
                            for (int i = 0; lesOffre.size() > i; i++) {
                        %>
                        <tr>
                            <%System.out.println(lesOffre.get(i).getDescription());%>
                            <td> <%=lesOffre.get(i).getPoste()%> </td>
                            <td><%=lesOffre.get(i).getDescription()%></td>
                            <td><%=lesOffre.get(i).getRemuneration()%>$/Heure</td>
                        </tr>
                            <%}%>
                    <%} else {%>
                    <tr>
                        <td>Aucun poste.</td>
                        <td>Aucune description.</td>
                        <td>N/A</td>
                    </tr>
                    <%}%>
                </tbody>
        </main>
    </body>
</html>
