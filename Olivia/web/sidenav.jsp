<%-- 
    Document   : sidenav
    Created on : 28-Apr-2022, 12:43:08 AM
    Author     : LysAd
--%>
<%@page import="java.util.ResourceBundle"%>
<%
    ResourceBundle msg = ResourceBundle.getBundle("ressources.MessageBundle");
%>
<nav class="sidenav">
    <% switch ((String) session.getAttribute("typeCompte").toString().toLowerCase()) {
            case "etudiant":%>
    <ul>
        <li><a class="navcoteText" href="pageAccueilConnecte.jsp"><i class="fa-solid fa-house"></i><%=msg.getString("sd-Accueil") %></a></li>
        <li><a class="navcoteText" href="HomePage"><i class="fa-solid fa-house-chimney-user"></i><%=msg.getString("tabord2") %></a></li>
        <li><a class="navcoteText" href="recherche"><i class="fa-solid fa-magnifying-glass"></i><%=msg.getString("recherche") %></a></li>
        <li><a class="navcoteText" href="afficherCV"><i class="fa-solid fa-file-lines"></i>Curriculum Vitae</a></li>
        <li><a class="navcoteText" href="formulaireCV.jsp"><i class="fa-solid fa-file-lines"></i><%=msg.getString("maj-cv") %></a></li>
        <li><a class="navcoteText" href="afficherLettreMotivation"><i class="fa-solid fa-file-lines"></i><%=msg.getString("lMotivation") %></a></li>
        <li><a class="navcoteText" href="pagePostulation"><i class="fa-solid fa-building"></i><%=msg.getString("stage-postules") %></a></li>
    </ul>
    <%break;
        case "admin":%>
    <ul>
        <li><a class="navcoteText" href="Ajouter"><i class="fa-solid fa-plus-square"></i><%=msg.getString("add") %></a></li>
         <li><a class="navcoteText" href="Modifier"><i class="fa-solid fa fa-pencil"></i><%=msg.getString("Modifier") %></a></li>
          <li><a class="navcoteText" href="Supprimer"><i class="fa-solid fa-minus-square"></i><%=msg.getString("Supprimer") %></a></li>
    </ul>
    <%break;
        case "entreprise":%>
    <ul>
        <li><a class="navcoteText" href="pageAccueilConnecte.jsp"><i class="fa-solid fa-house"></i><%=msg.getString("sd-Accueil") %></a></li>
        <li><a class="navcoteText" href="HomePage"><i class="fa-solid fa-house-chimney-user"></i><%=msg.getString("tabord2") %></a></li>
        <li><a class="navcoteText" href="listeOffre"><i class="fa-solid fa-handshake"></i></i><%=msg.getString("vos-ofre") %></a></li>
        <li><a class="navcoteText" href="listeOffreAvecLiensCandidatures"><i class="fa-solid fa-handshake"></i><%=msg.getString("candidatures") %></a></li>
        <li><a class="navcoteText" href="FairePub"><i class="fa-solid fa-pen-nib"></i><%=msg.getString("creation-publicite") %></a></li>
    </ul>
    <%break;
        case "professeur":%>
    <ul>
        <li><a class="navcoteText" href="pageAccueilConnecte.jsp"><i class="fa-solid fa-house"></i><%=msg.getString("sd-Accueil") %></a></li>
        <li><a class="navcoteText" href="HomePage"><i class="fa-solid fa-school"></i><%=msg.getString("prof") %></a></li>
        <li><a class="navcoteText" href="recherche"><i class="fa-solid fa-magnifying-glass"></i><%=msg.getString("recherche") %></a></li>
        <li><a class="navcoteText" href="listeDesEntreprises"><i class="fa-solid fa-briefcase"></i><%=msg.getString("liste-ent") %></a></li>
        <li><a class="navcoteText" href="listeDesEtudiants"><i class="fa-solid fa-graduation-cap"></i><%=msg.getString("liste-etu") %></a></li>
        <li><a class="navcoteText" href="listeDesPubs"><i class="fa-solid fa-sack-dollar"></i><%=msg.getString("list-pub")%></a></li>
        <li><a class="navcoteText" href="listeDesOccup"><i class="fa-solid fa-clock"></i><%=msg.getString("occupations")%></a></li>
         <li><a class="navcoteText" href="StagePostuler"><i class="fa-solid fa-building"></i><%=msg.getString("stage-postules") %></a></li>
    </ul>
    <%break;
        default:%>
    <ul>
        <li><a class="navcoteText" href="#"><i class="fa-solid fa-house"></i>hacker</a></li>
    </ul>
    <%}%>

</nav>