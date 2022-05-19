<%-- 
    Document   : pageDePostulation
    Created on : 15-May-2022, 7:37:25 PM
    Author     : LysAd
--%>

<%@page import="com.model.entities.Entreprise"%>
<%@page import="com.model.entities.Offre"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Page De Postulation</title>
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
                Offre offre = (Offre) request.getAttribute("offreAAfficher");
                Entreprise ent = (Entreprise) request.getAttribute("entAAfficher");
            %>
            <h1>PAGE DE POSTULATION<h1>
            <br>
            <h2 style="color: #3C8D93;text-transform:uppercase;">
                <%=ent.getNom()%>
            </h2>
            <p>
                <%=ent.getDescription()%>
            </p>
            <br><br>
            <h2 style="color: #3C8D93;text-transform:uppercase;">
                Poste offert : 
            </h2>
            <p>
                Nomination du poste:<br>
                <%=offre.getPoste()%>
            </p>
            <br>
            <p>
                Description:<br>
                <%=offre.getDescription()%><br><br>
            </p>
            <p>
                Rénumération:<br>
                Le poste est présentement rémunéré : <%=offre.getRemuneration()%>($/heure)
            </p>
            <br><br>
            <h2 style="color: #3C8D93;text-transform:uppercase;">
                Personne à contacter : 
            </h2>
            <p>
                Nom:<br>
                <%=ent.getPersonneReference()%><br><br>
            </p>
            <br>
            
            <a href="envoyerDemandePostulation?idOffre=<%=offre.getId()%>&idEnt=<%=ent.getId()%>">
                <input type="submit" class="search-btn-input" value="Postuler cette offre par courriel">
            </a>
            
        </main>
    </body>
</html>
