<%-- 
    Document   : vueCvDuCandidat
    Created on : 25-May-2022, 3:57:49 PM
    Author     : LysAd
--%>

<%@page import="com.model.entities.Etudiant"%>
<%@page import="com.model.entities.CV"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="css/style.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.1/css/all.min.css" integrity="sha512-KfkfwYDsLkIlwQp6LFnl8zNdLGxu9YAA1QvwINks4PhcElQSvqcyVLLD9aMhXd13uQjoXtEKNosOWaZqXgel0g==" crossorigin="anonymous" referrerpolicy="no-referrer" />
    </head>
    <body class="wrapper">

        <div class="wrapper-header">
            <jsp:include page="../header.jsp"/>
        </div>
        <div class="wrapper-side">
            <jsp:include page="../sidenav.jsp"/>
        </div>

        <main class="contenuPrincipal wrapper-main-content">


            <%
                CV cvAAfficher = (CV) request.getAttribute("CV");
                Etudiant etu = (Etudiant) request.getAttribute("Etu");
            %>


            <h2>Infos sur le candidat : </h2>
            <hr>
            <table class="tbd-table">
                <thead>
                    <tr>
                        <th>Nom</th>
                        <th>Prénom</th>
                        <th>Courriel</th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td><%=etu.getNom()%></td>
                        <td><%=etu.getPrenom()%></td>
                        <td><%=etu.getCompte().getCourriel()%></td>
                    </tr>
                </tbody>
            </table>
            <br>
            <h2>Curriculum Vitae du candidat :  </h2>
            <hr>
            <br>
            <h2> Résumé : </h2>
            <p> <%=cvAAfficher.getResume()%>  </p>
            <br>
            <h2>Expérience de travail: </h2>
            <p> <%=cvAAfficher.getExperienceTravail()%>  </p>
            <br>
            <h2>Éducation : </h2>
            <p> <%=cvAAfficher.getEducation()%>  </p>
            <br>
            <h2>Certification : </h2>
            <p> <%=cvAAfficher.getCertification()%>  </p>
            <br>
            <h2>Competences: : </h2>
            <p> <%=cvAAfficher.getCompetence()%>  </p>
            <br>
            <h2>Langues Parlés : </h2>
            <p> <%=cvAAfficher.getLangue()%>  </p>
            <br>
            
            <a href="priseDeRendezVousParCourriel?etudiantId=<%=etu.getId()%>">
            <input type="submit" class="search-btn-input" value="Planifier un rendez-vous">
            </a>
        </main>
    </body>
</html>
