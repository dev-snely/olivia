<%@page pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/stylePageAcceuil.css">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Accueil</title>
    </head>

    <body class="PageAccueil">
        <header class="alignerElementsHaut">

            <div class="titrePiLogo">
                <img class="tailleLogo" src="images/logo.png" />
                <a href="pageAccueil.jsp">Olivia</a>
            </div>



            <div class="buttonsConnexionInscription">
                <a href="pageConnexion.jsp" class="ConnexionButon">Connexion</a>
                <a href="pageInscriptionEtudiant.html" class="InscriptionButon">Inscription</a>
            </div>

        </header>



        <main>
            <div class="TextPrincipalAccueil">
                <h1 class="recherche">Bonjour à tous 👋</h1>
                <h1 class="whitey">Chers étudiants, <br />les entreprises n’attendent que vous.</h1>
                <p class="recherche">La recherche de stages ou d’emploi n’est pas forcément une chose aisée. Olivia sera votre

                    guide
                    vers l’embauche.
                </p>


                <h1 class="whitey"> &gt;&gt;&gt;&gt;&gt;&gt;&gt;&gt;&gt;&gt;&gt;&gt;&gt;&gt;&gt;&gt;&gt;&gt;&gt;&gt;&gt;</h1>

                <h1 class="whitey">Postulez dès aujourd’hui.</h1>

            </div>


            <img class="imageacc" src="images/image-accueil-1@1x.png" alt="">


        </main>




        <script>
            var compteCreerAvecSucces = <%=request.getAttribute("succes")%>;
            if (compteCreerAvecSucces === true) {
                alert("Inscription effectué avec succèes! Vous pouvez maintenant vous connecter! ?");
            } else if (compteCreerAvecSucces === false) {
                alert("? L'inscription n'a pas fonctionné. Veuillez nous contacter via courriel pour de l'assistance.");
            }
            console.log(document.characterSet);

        </script>
    </body>

</html>