<%-- 
    Document   : ajoutEtudiant
    Created on : 2022-05-24, 18:19:56
    Author     : gabri
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
        <head>
        <meta charset="UTF-8">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" type="text/css" href="css/stylePageInscription.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.2/css/all.min.css" />
        <title>Inscription</title>
    </head>
    <body>
        <h1>INSCRIPTION ÉTUDIANT</h1>
        <br>
                  <form class="formulaire-inscription" id="formulaire-inscription"  action="Ajouter" method="post">
                    <!-- POUR GET LE TYPE DE FORMULAIRE -->
                    <input name="typeForm" value="etudiant" type="hidden">
                    
                    <div class="controle-formulaire ">
                        <label for="nom">Nom:</label><br>
                        <div class="entree">
                            <i class="fas fa-user"></i>
                            <input type="text" id="nom" name="nom" placeholder="Entre ton nom">
                        </div>
                        <small>Message Erreur</small>
                    </div>
                    <div class="controle-formulaire">
                        <label for="prenom">Prenom:</label><br>
                        <div class="entree">
                            <i class="fas fa-user"></i>
                            <input type="text" id="prenom" name="prenom" placeholder="Entre ton prenom">
                        </div>
                        <small>Message Erreur</small>
                    </div>
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
                        <label for="numDA">Numero DA:</label><br>
                        <div class="entree">
                            <i class="fas fa-hashtag"></i>
                            <input type="text" id="numDA" name="numDA" placeholder="Entre ton numero DA">
                        </div>
                        <small>Message Erreur</small>
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
                    <div class="controle-formulaire">
                        <label for="mdp">Confirmation:</label><br>
                        <div class="entree">
                            <i class="fas fa-key"></i>
                            <input type="password" id="mdp2" name="mdp2" placeholder="Confirme ton mot de passe">
                             <input type="hidden"  name="inscrire" value="3487">
                            <span class="yeux" onclick="voirTexteMDP2()">
                                <i id="hide3" class="fa fa-eye-slash"></i>
                                <i id="hide4" class="fa fa-eye"></i>
                            </span>
                        </div>
                        <small>Message Erreur</small>
                    </div>


                    <button class="btn-inscription" type="submit">S'inscrire</button>
                </form>
          </script>
        <script src="js/validationInscription.js"></script>  
    </body>

</html>
