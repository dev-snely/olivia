<%-- 
    Document   : pageModificationOffreEnt
    Created on : 12-May-2022, 6:49:28 PM
    Author     : LysAd
--%>

<%@page import="com.model.entities.Offre"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/style.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.1/css/all.min.css" integrity="sha512-KfkfwYDsLkIlwQp6LFnl8zNdLGxu9YAA1QvwINks4PhcElQSvqcyVLLD9aMhXd13uQjoXtEKNosOWaZqXgel0g==" crossorigin="anonymous" referrerpolicy="no-referrer" />
        <title>Modification de votre offre</title>
    </head>
    <body class="wrapper">

        <div class="wrapper-header">
            <jsp:include page="header.jsp"/>
        </div>
        <div class="wrapper-side">
            <jsp:include page="sidenav.jsp"/>
        </div>

        <main class="contenuPrincipal wrapper-main-content">

            <div class="page-offre-ent-titre">
                <h1>MODIFICATION DE VOTRE OFFRE</h1>
                <div class="page-offre-ent-btns">
                    <a href="pageOffresEntrepriseEdition.jsp" class="page-offre-ent-btns-1"><i class="fa-solid fa-left-long"></i></a>
                </div>
            </div>
            <br>
            <form action="modifierOffreEntreprisePartieDeux" method="post">
                <label for="poste" >Nom du nouveau poste: </label><br>
                <input type="text" id="input_border" name="poste" value="<%=request.getAttribute("posteActuel")%>"><br>
                <label for="description">Description: </label><br>
                <textarea rows="10" cols="30" id="input_border" name="description" ><%=request.getAttribute("descActuel")%></textarea><br>
                <label for="renumeration">Rémunération du poste: </label><br>
                <input type="number" id="input_border" name="renumeration" value="<%=request.getAttribute("renumActuel")%>"><br>
                <br>
                <input type="hidden" name="idAModifier" value="<%=request.getAttribute("idAModifier")%>">
                <input type="submit" class="search-btn-input" value="Modifier votre offre">
            </form>
        </main>
        <script>

        </script>
    </body>
</html>
