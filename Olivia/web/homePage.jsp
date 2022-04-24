<%-- 
    Document    : homePage
    Created on  : 02-Apr-2022
    Author      : Mahmoud
    Modified by : Snely
    on          : 23rd-Apr-2022
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home Page</title>
        <link rel="stylesheet" href="css/style.css">
    </head>
    <body>
        <header class="alignerElementsHaut">

            <div class="titrePiLogo">
                <img class="tailleLogo" src="images/logo.png" />
                <a>Olivia</a>
            </div>

            <div class="buttonsConnexionInscription">
              
                <a href="#" class="nomCompte">
                    
                    Bonjour <%=session.getAttribute("prenom")%> <%=session.getAttribute("nom")%>  
                
                </a>
                <a href="#"><button class="InscriptionButon">Se déconnecter</button> </a>
            </div>

        </header>

        <nav class="sidenav">
            <ul>
                <li><a class="navcoteText" href="#">Accueil</a></li>
                <li><a class="navcoteText" href="#">Tableau de bord</a></li>
                <li><a class="navcoteText" href="#">Recherche d'occupations</a></li>
                <li><a class="navcoteText" href="#">Boite d'offres</a></li>
                <li><a class="navcoteText" href="#">Curriculum Vitae</a></li>
                <li><a class="navcoteText" href="#">Lettre motivation</a></li>
                <li><a class="navcoteText" href="#">Stages postulés</a></li>
            </ul>
        </nav>



        <main class="contenuPrincipal">
            <!-- Inserer la jsp ici-->



        </main>

    </body>
</html>

