<%-- 
    Document    : homePage
    Created on  : 02-Apr-2022
    Author      : Mahmoud
    Modified by : Snely
    on          : 28th-Apr-2022
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="com.model.entities.Offre"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Ajouter</title>
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

            <div class="formulaire-inscripiton-titre-1">Créez votre compte</div>
            <p class="formlaire-inscription-paragraphe">Olivia augmente vos chances d’obtenir les employés qu'il vous faut!</p>
            <br>
            <div class="espace-btn-choix">
                <a href="Ajouter?inscription=etudiant" class="btn-choix ">
                    <img src="images/etudiant-icon-frepik.png" alt="etudiant" width="50" 
                         height="50">
                    <span class="btn-choix-titre">Étudiant</span>
                </a>
                <a href="Ajouter?inscription=professeur" class="btn-choix">
                    <img src="images/prof-icon-freepik.png" alt="prof" width="50" 
                         height="50"> 
                    <span class="btn-choix-titre">Professeur</span>
                </a>
                <a href="Ajouter?inscription=entreprise" class="btn-choix btn-choix-active" width="50" 
                   height="50">
                    <img src="images/enterprise-icon-surang.png" alt="entreprise" width="50" 
                         height="50">
                    <span class="btn-choix-titre">Entreprise</span>
                </a>
                <a href="Ajouter?inscription=admin" class="btn-choix btn-choix-active" >
                    <img src="images/admin.png" alt="admin" width="50" 
                         height="50">
                    <span class="btn-choix-titre">Entreprise</span>
                </a>
                <!--<a href="https://www.flaticon.com/free-icons/enterprise" title="enterprise icons">Enterprise icons created by surang - Flaticon</a>
                <a href="https://www.flaticon.com/free-icons/student" title="student icons">Student icons created by Freepik - Flaticon</a>
                <a href="https://www.flaticon.com/free-icons/teacher" title="teacher icons">Teacher icons created by Freepik - Flaticon</a> -->

            </div>

            <%  //String inscript=(String)session.getAttribute("inscription");
                //if(inscript.equals("etudiant")){%>
            <form class="formulaire-inscription" id="formulaire-inscription" action="inscription" method="post">
                <input name="typeForm" value="Entreprise" type="hidden">
                <div class="controle-formulaire ">
                    <label for="nom">Nom d'entreprise:</label><br>
                    <div class="entree">
                        <i class="fas fa-user"></i>
                        <input type="text" id="nom" name="nom" placeholder="Entrer votre nom d'entreprise">
                    </div>
                    <small>Message Erreur</small>
                </div>
                <div class="controle-formulaire">
                    <label for="courriel">Courriel:</label><br>
                    <div class="entree">
                        <i class="fas fa-envelope"></i>
                        <input type="email" id="courriel" name="courriel" placeholder="Entre votre adresse courriel">
                    </div>
                    <small>Message Erreur</small>
                    <br>
                </div>
                <div class="controle-formulaire">
                    <label for="mdp">Mot de passe:</label><br>
                    <div class="entree">
                        <i class="fas fa-lock"></i>
                        <input type="password" id="mdp" name="mdp" placeholder="Entrer votre mot de passe">
                        <span class="yeux" onclick="voirTexteMDP()">
                            <i id="hide1" class="fa fa-eye-slash"></i>
                            <i id="hide2" class="fa fa-eye"></i>
                        </span>
                    </div>
                    <small>Message Erreur</small>
                </div>
                <div class="controle-formulaire">
                    <label for="mdp">Confirmation:</label><br>
                    <div class="entree">
                        <i class="fas fa-key"></i>
                        <input type="password" id="mdp2" name="mdp2" placeholder="Confirmer votre mot de passe">
                        <span class="yeux" onclick="voirTexteMDP2()">
                            <i id="hide3" class="fa fa-eye-slash"></i>
                            <i id="hide4" class="fa fa-eye"></i>
                        </span>
                    </div>
                    <small>Message Erreur</small>
                </div>
                <button class="btn-inscription" type="submit">S'inscrire</button>
            </form>
            <% //}else{%>

            <% //}%>


        </main>


        <script>
            function voirTexteMDP() {
                var motDePasse = document.getElementById("mdp");
                const YEUXOUVERT = document.getElementById("hide1");
                const YEUXFERME = document.getElementById("hide2");

                if (motDePasse.type === "password") {
                    motDePasse.type = "text";
                    YEUXOUVERT.style.display = "inherit";
                    YEUXOUVERT.style.cursor = "pointer";
                    YEUXFERME.style.display = "none";
                } else {
                    motDePasse.type = "password";
                    YEUXOUVERT.style.display = "none";
                    YEUXFERME.style.display = "inherit";
                    YEUXFERME.style.cursor = "pointer";
                }
            }
            function voirTexteMDP2() {
                var motDePasse2 = document.getElementById("mdp2");
                const YEUXOUVERT = document.getElementById("hide3");
                const YEUXFERME = document.getElementById("hide4");

                if (motDePasse2.type === "password") {
                    motDePasse2.type = "text";
                    YEUXOUVERT.style.display = "inherit";
                    YEUXOUVERT.style.cursor = "pointer";
                    YEUXFERME.style.display = "none";
                } else {
                    motDePasse2.type = "password";
                    YEUXOUVERT.style.display = "none";
                    YEUXFERME.style.display = "inherit";
                    YEUXFERME.style.cursor = "pointer";
                }
            }
        </script>
        <script src="js/validationInscription_1.js">   
        </script>  

    </body>
</html>

