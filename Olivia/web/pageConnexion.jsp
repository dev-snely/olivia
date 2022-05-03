<%-- 
    Document   : pageConnexion
    Created on : 1-Apr-2022, 4:35:55 PM
    Author     : Lys, Snely Adam
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="UTF-8">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" type="text/css" href="css/stylePageConnexion.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.2/css/all.min.css" />
        <title>Connexion</title>
    </head>

    <body class="page">
        <header class="page-header">

            <div class="conteneur-du-logo">
                <img class="logo" src="images/logo.png" alt="logo">
                <a class="titre-du-site" href="pageAccueil.jsp">Olivia</a>
            </div>

            <a href="pageInscriptionEtudiant.html" class="btn-inscription">Inscription</a>

        </header>

        <main class="page-main">

            <form class="formulaire-connexion" id="formulaire-connexion" action="connexion" method="post">

                <div class="formulaire-connexion-titre">Tu es de retour!</div>

                <div class="controle-formulaire">
                    <label for="courriel">Courriel:</label><br>
                    <div class="entree">
                        <i class="fas fa-envelope"></i>
                        <input type="email" id="courriel" name="courriel" placeholder="Entre ton adresse courriel">
                    </div>
                    <small>Message Erreur</small>
                    <br>
                </div>

                <div class="controle-formulaire">
                    <label for="mdp">Mot de passe:</label><br>
                    <div class="entree">
                        <i class="fas fa-lock"></i>
                        <input type="password" id="mdp" name="mdp" placeholder="Entre ton mot de passe">
                        <span class="yeux" onclick="voirTexteMDP()">
                            <i id="hide1" class="fa fa-eye-slash"></i>
                            <i id="hide2" class="fa fa-eye"></i>
                        </span>
                    </div>
                    <small>Message Erreur</small>
                </div>
                <div class="checkbox-container pull-left">
                    <input id="cb" type="checkbox" name="sauvegarde" value="yes">
                    <label for="cb">Se souvenir</label>
                </div>
                <button class="btn-connexion" type="submit">
                    Se connecter</button>

            </form>

        </main>
        <footer class="page-footer">
            <div class="footer-contenu">
                <p>© Olivia 2022</p>
            </div>
        </footer>

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
        </script>
        <script src="js/validationConnexion.js">
        </script>  


    </body>

</html>