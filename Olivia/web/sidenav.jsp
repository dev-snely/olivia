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
        <li><a class="navcoteText" href="#"><i class="fa-solid fa-house"></i>admin</a></li>
    </ul>
    <%break;
        case "entreprise":%>
    <ul>
        <li><a class="navcoteText" href="HomePage"><i class="fa-solid fa-house-chimney-user"></i>Tableau de bord</a></li>
        <li><a class="navcoteText" href="listeOffre"><i class="fa-solid fa-handshake"></i></i>Vos offres</a></li>
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