<%-- 
    Document   : pageRecherche
    Created on : 2-May-2022, 8:07:36 PM
    Author     : LysAd
--%>

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
            <form class="search-container">
                <input type="text" class="search-input" placeholder="Entrer un mot clé; ex: informatique ou santé" >
                <input type="submit" class="search-btn-input" value="Chercher">
            </form>

        </main>

    </body>
</html>
