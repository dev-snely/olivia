<%-- 
    Document   : creationOffreEntreprise
    Created on : 10-May-2022, 7:33:33 PM
    Author     : LysAd
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Création d'une nouvel offre</title>
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
            <h1>CRÉATION D'UN NOUVEL OFFRE</h1>
            <br>
            <form id="nouvOffre" action="nouvelOffreEntreprise" method="post">
                <label for="poste" >Nom du nouveau poste: </label><br>
                <input type="text" id="input_border" name="poste" value=""><br>
                <label for="description">Description: </label><br>
                <textarea rows="10" cols="30" id="input_border" name="description" value=""></textarea><br>
                <label for="renumeration">Rémunération du poste: </label><br>
                <input type="number" id="input_border" name="renumeration" value=""><br>
                <br>
                <input type="submit" class="search-btn-input" value="Créer la nouvelle offre">
            </form>
        </main>
    </body>
</html>
