<%-- 
    Document   : header
    Created on : 28-Apr-2022, 12:41:14 AM
    Author     : LysAd
--%>

<%@page import="java.util.ResourceBundle"%>
<header class="alignerElementsHaut">

    <%
        ResourceBundle messages = ResourceBundle.getBundle("ressources.MessageBundle");
    %>
    
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
    <div class="lang-menu">
        <div class="selected-lang">
            <%= messages.getString("changer-langue") %>
        </div>
        <ul>
            <li>
                <a href="changerLangue?langue=EN"><%=messages.getString("langEN") %></a>
            </li>
            <li>
                <a href="changerLangue?langue=FR" ><%= messages.getString("langFR") %></a>
            </li>
        </ul>

    </div>

</header>