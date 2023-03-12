# Olivia

Olivia est le projet de session pour le cours d'application web 2 qui a comme thème la recherche de stages ou d'emploi pour les étudiants.

# Apreçu du projet

![Animation](/uploads/f025cdd16193f032535b44aca9ff3302/Animation.gif)

# Installation 

Voici une liste d'étape à suivre qui devrait vous permettre d'installer et de démarrer une instance d'Olivia: 

1. Je clone le projet depuis gitlab
2. J'utilise Netbeans IDE 8.2 RC
3. Dans Tools -> Java Platforms, j'utilise la JDK 1.8
4. Dans Tools -> Plugins, j'installe et active les plugins Java Web and EE s'ils ne sont pas activé.
5. Dans l'onglet Services -> Databases, j'active le connecteur jdbc qui permet de connecter mon localhost avec ma BD "instage" MySQL depuis Netbeans. 
6. Dans l'onglet Services -> Servers, j'utilise le conteneur Apache Tomcat 9.0.37
7. Dans l'onglet Projects, une fois le projet web Olivia ouvert, j'effectue un clic droit sur Olivia -> Properties -> Libraries et je m'assure d'avoir installé et activé les jar suivants : 
- javax.mail-1.6.1.jar 
- mysql-connector-java-8.0.21.jar 
8. Clean & build, puis le context Olivia devrait être en marche. http://localhost:8080/Olivia  

Il ne devrait pas avoir d'erreur de Base de Données. S'il en ait le cas, dans le package com.services.config, vous pouvez spécifier le port que vous utiliser pour votre machine, puis les identifiants qu'il faut pour vous connectez à la Base de Données MySQL.

# Contributions

Le projet à été réalisé dans le cadre d'un cours et est maintenant fermé. Cependant, il est libre d'utilisation.  

# Remerciements

Merci à nos développeurs pour les efforts fournis pour la réalisation du projet Olivia. 

1. Al Cheik, Ali Mahmoud
2. Boisvert, Gabriel
3. Lys, Snely Adam

Un bon merci à notre professeur Dini Ahamada pour nous avoir accompagné dans le développement de l'application.

# License

[MIT](https://choosealicense.com/licenses/mit/)







