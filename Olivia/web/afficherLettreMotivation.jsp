<%-- 
    Document   : afficherLettreMotivation
    Created on : 2022-05-25, 19:06:42
    Author     : Mahmo
--%>

<%@page import="com.model.entities.LettreMotivation"%>
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
            <% LettreMotivation lettre = (LettreMotivation)session.getAttribute("LEttreMotivation");   %>
            
            <h2>Titre : </h2>
            <p> <%=lettre.getTitre()      %>  </p>
            <br>
            <h2>Contenu: </h2>
            <p> <%=lettre.getContenu()      %>  </p>
            
            <br>
             
            <a href="mettreAJourLettreMot.jsp"> <button  class="search-btn-input">  Mettre à jour Votre Lettre  </button></a>
        </main>
    </body>
</html>
