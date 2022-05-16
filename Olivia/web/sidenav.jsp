<%-- 
    Document   : sidenav
    Created on : 28-Apr-2022, 12:43:08 AM
    Author     : LysAd
--%>

<nav class="sidenav">
    <% switch ((String) session.getAttribute("typeCompte").toString().toLowerCase()) {
            case "etudiant":%>
    <ul>
        <li><a class="navcoteText" href="HomePage"><i class="fa-solid fa-house"></i>Accueil</a></li>
        <li><a class="navcoteText" href="HomePage"><i class="fa-solid fa-house-chimney-user"></i>Tableau de bord</a></li>
        <li><a class="navcoteText" href="recherche"><i class="fa-solid fa-magnifying-glass"></i>Recherche</a></li>
        <li><a class="navcoteText" href="#"><i class="fa-solid fa-box"></i>Boite d'offres</a></li>
        <li><a class="navcoteText" href="Cv"><i class="fa-solid fa-file-lines"></i>Curriculum Vitae</a></li>
        <li><a class="navcoteText" href="#"><i class="fa-solid fa-file-lines"></i>Lettre motivation</a></li>
        <li><a class="navcoteText" href="#"><i class="fa-solid fa-building"></i>Stages postulés</a></li>
    </ul>
    <%break;
        case "admin":%>
    <ul>
        <li><a class="navcoteText" href="Ajouter"><i class="fa-solid fa-plus-square"></i>Ajouter</a></li>
         <li><a class="navcoteText" href="Modifier"><i class="fa-solid fa fa-pencil"></i>Modifier</a></li>
          <li><a class="navcoteText" href="Supprimer"><i class="fa-solid fa-minus-square"></i>Supprimer</a></li>
    </ul>
    <%break;
        case "entreprise":%>
    <ul>
        <li><a class="navcoteText" href="#"><i class="fa-solid fa-house"></i>entreprise</a></li>
    </ul>
    <%break;
        case "professeur":%>
    <ul>
        <li><a class="navcoteText" href="#"><i class="fa-solid fa-house"></i>professeur</a></li>
    </ul>
    <%break;
        default:%>
    <ul>
        <li><a class="navcoteText" href="#"><i class="fa-solid fa-house"></i>hacker</a></li>
    </ul>
    <%}%>

</nav>