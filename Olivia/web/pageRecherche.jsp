<%-- 
    Document   : pageRecherche
    Created on : 2-May-2022, 8:07:36 PM
    Author     : LysAd
--%>

<%@page import="com.model.entities.ObjetOffrEntr"%>
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
    <body class="wrapper">

        <div class="wrapper-header">
            <jsp:include page="header.jsp"/>
        </div>
        <div class="wrapper-side">
            <jsp:include page="sidenav.jsp"/>
        </div>

        <main class="contenuPrincipal wrapper-main-content">

            <h1>RECHERCHE</h1><br>
            <hr>
            <br>
            Nom du poste :
            <div class='search-container'>
                <input type="text" class="search-input" id="myInput" onkeyup="rechercheNomPoste()" placeholder="Filtrer par POSTE">
            </div>
            <br>
            Nom de l'entreprise :
            <div class='search-container'>
                <input type="text" class="search-input" id="myInput2" onkeyup="rechercheEntreprise()" placeholder="Filtrer par ENTREPRISE">
            </div>
            <table class="tbd-table" id="myTable">
                <thead>
                    <tr>
                        <th>Nom du poste</th>
                        <th>Description</th>
                        <th>Rémuneration ($/Heure)</th>
                        <th>Entreprise </th>
                        <th>Description Ent</th>
                        <th>Ouvrir l'offre</th>
                    </tr>
                </thead>
                <tbody>

                    <%
                        List<ObjetOffrEntr> lesOffreEnt = (ArrayList<ObjetOffrEntr>) session.getAttribute("listeOffres&Ent");
                        if (lesOffreEnt != null) {
                            if (lesOffreEnt.size() == 0) {
                    %>
                    <tr>
                        <td>Aucun poste.</td>
                        <td>Aucune description.</td>
                        <td>N/A</td>
                        <td>N/A</td>
                        <td>N/A</td>
                        <td>N/A</td>
                    </tr>
                    <%} else if (lesOffreEnt.size() > 0) {
                        for (int i = 0; lesOffreEnt.size() > i; i++) {
                    %>
                    <tr>
                        <td><%=lesOffreEnt.get(i).getOffre().getPoste()%> </td>
                        <td><%=lesOffreEnt.get(i).getOffre().getDescription()%></td>
                        <td><%=lesOffreEnt.get(i).getOffre().getRemuneration()%></td>
                        <td><%=lesOffreEnt.get(i).getEntreprise().getNom()%></td>
                        <td><%=lesOffreEnt.get(i).getEntreprise().getDescription()%></td>
                        <td><a style="color:#1F454D" href="afficherOffreEntreprise?idOffre=<%=lesOffreEnt.get(i).getOffre().getId()%>&idEnt=<%=lesOffreEnt.get(i).getEntreprise().getId()%>"> Détails 
                            </a>
                        </td>
                    </tr>
                    <%}
                    } else {%>
                    <tr>
                        <td>Aucun poste.</td>
                        <td>Aucune description.</td>
                        <td>N/A</td>
                        <td>N/A</td>
                        <td>N/A</td>
                        <td>N/A</td>
                    </tr>
                    <%}%>
                    <%}%>
                </tbody>
            </table> 

        </main>
        <script src="js/rechercheEmploi.js">
        </script>  
    </body>
</html>
