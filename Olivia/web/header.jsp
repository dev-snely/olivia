<%-- 
    Document   : header
    Created on : 28-Apr-2022, 12:41:14 AM
    Author     : LysAd
--%>

<header class="alignerElementsHaut">

    <div class="titrePiLogo">
        <img class="tailleLogo" src="images/logo.png" />
        <a>Olivia</a>
    </div>

    <div class="buttonsConnexionInscription">

        <a href="#" class="nomCompte">
            <% if (session.getAttribute("typeCompte").equals("entreprise")) {%>
            Bonjour <%=session.getAttribute("nom")%>
            <%} else {%>

            Bonjour <%=session.getAttribute("prenom")%> <%=session.getAttribute("nom")%>  
            <%}%>
        </a>
        <a href="deconnexion"><button class="InscriptionButon">Se déconnecter</button> </a>
    </div>

</header>