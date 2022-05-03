<%-- 
    Document   : deconnexionPage
    Created on : 28-Apr-2022, 5:45:51 PM
    Author     : LysAd
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" type="text/css" href="css/stylePageDeconnexion.css">
    </head>
    <body class="page">
        <header class="page-header">

            <div class="conteneur-du-logo">
                <img class="logo" src="images/logo.png" alt="logo">
                <a class="titre-du-site" href="pageAccueil.html">Olivia</a>
            </div>

        </header>

        <main class="page-main">
            <div class="formulaire-deconnexion">
                <div class="conteneur-message-deconnexion-titre">
                    <p>
                        M.Mme <%=request.getAttribute("nomUserDeconnecte")%>,<br>
                        Vous avez fermé votre session en toute sécurité.<br><br>
                        Au revoir! 👋 <br><br>
                    <p>
                </div>
                <br>
                <div class='centrage-choix-btn'>
                    <a class="connexion-button" type="button" href="pageAccueil.jsp" >
                        Retourner dans la page d'accueil</a>
                    OU
                    <a class="connexion-button" type="button" href="pageConnexion.jsp">
                        Retourner dans la page de connexion</a>
                </div>
            </div>
        </main>
                        
        <footer>
            <div class="footer-contenu">
                <p>© Olivia 2022</p>
            </div>
        </footer>

    </body>
</html>
