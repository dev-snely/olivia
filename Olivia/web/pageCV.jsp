<%-- 
    Document   : pageCV
    Created on : 2022-05-23, 14:58:10
    Author     : Mahmo
--%>

<%@page import="com.model.entities.CV"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Page de Cv</title>
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
            <% CV lecv = (CV)session.getAttribute("leCV");   %>
            
            <h2>Résumé : </h2>
            <p> <%=lecv.getResume()      %>  </p>
            <br>
            <h2>Expérience de travail: </h2>
            <p> <%=lecv.getExperienceTravail()      %>  </p>
            <br>
            <h2>Éducation : </h2>
            <p> <%=lecv.getEducation()      %>  </p>
            <br>
            <h2>Certification : </h2>
            <p> <%=lecv.getCertification()     %>  </p>
            <br>
            <h2>Competences: : </h2>
            <p> <%=lecv.getCompetence()      %>  </p>
            <br>
            <h2>Langues Parlés : </h2>
            <p> <%=lecv.getLangue()      %>  </p>
            <br>
            
            
        </main>
        
        
    </body>
</html>
