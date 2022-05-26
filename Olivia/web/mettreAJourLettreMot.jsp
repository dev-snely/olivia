<%-- 
    Document   : mettreAJourLettreMot
    Created on : 2022-05-25, 19:21:28
    Author     : Mahmo
--%>

<%@page import="com.model.entities.LettreMotivation"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        
         <link rel="stylesheet" href="css/style.css">
         <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.1/css/all.min.css" integrity="sha512-KfkfwYDsLkIlwQp6LFnl8zNdLGxu9YAA1QvwINks4PhcElQSvqcyVLLD9aMhXd13uQjoXtEKNosOWaZqXgel0g==" crossorigin="anonymous" referrerpolicy="no-referrer" />
         
        <title>Mise à jour</title>
    </head>
    <body class="wrapper">

        <div class="wrapper-header">
            <jsp:include page="header.jsp"/>
        </div>
        <div class="wrapper-side">
            <jsp:include page="sidenav.jsp"/>
        </div>

        <main class="contenuPrincipal wrapper-main-content">
        <h1>Page de mise à jour de la lettre de motivation</h1>
        <br>
        <h2>Sur cette page, vous pouvez mettre votre lettre de motivation à jour afin de pouvoir obtenir plus d'offres</h2>
        <br>
        
        <form action="mettreAjourLettre">
              <% LettreMotivation lettre = (LettreMotivation)session.getAttribute("LEttreMotivation");   %>
            <label   for="Resume" >Le titre </label><br>
            <input id="input_border" type="text"  name="titleLettre" value=" <%=lettre.getTitre()      %>"><br>
            <label   for="ExpTravail" >Contenu de votre Lettre: </label><br>
            <input id="input_border" type="text"  name="contenuLettre" value="<%=lettre.getContenu()      %>"><br>
            <br>
            <input type="submit" class="search-btn-input" value="Mettre à Jour">
            
            
        </form>
    </body>
</html>
