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
        <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">

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
                <li><a class="navcoteText" href="#">Recherche</a></li>
                <li><a class="navcoteText" href="#">Boite d'offres</a></li>
                <li><a class="navcoteText" href="#">Curriculum Vitae</a></li>
                <li><a class="navcoteText" href="#">Lettre motivation</a></li>
                <li><a class="navcoteText" href="#">Stages postulés</a></li>
            </ul>
        </nav>



        <main class="contenuPrincipal">
            <!-- Transformer le code du main en jsp pour les trois type de compte-->
            <h1 class="tbd-titre">TABLEAU DE BORD</h1><br>
            <h2 class="tbd-sous-titre">Vos informations</h2>
            <hr>
            <table class="tbd-table">
                <thead>
                    <tr>
                        <th>Nom</th>
                        <th>Prénom</th>
                        <th>Courriel</th>
                        <th>Lien vers Curriculum Vitae</th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td><%=session.getAttribute("nom")%></td>
                        <td><%=session.getAttribute("prenom")%></td>
                        <td>courriel@gmail.com</td>
                        <td>lien vers CV</td>
                    </tr>
                </tbody>
            </table>
            <br>
            <h2 class="tbd-sous-titre">Statut du stage</h2>
            <hr>
            <table class="tbd-table">
                <thead>
                    <tr>
                        <th>Nom de l'entreprise</th>
                        <th>Retenu par l'entreprise</th>
                        <th>Date de début</th>
                        <th>Date de fin</th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td>CHUM</td>
                        <td>Decision non prise</td>
                        <td>2022-06-02</td>
                        <td>2022-09-02</td>
                    </tr>
                </tbody>
            </table>            
        </main>

    </body>
</html>

