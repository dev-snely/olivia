<%@page import="com.model.entities.Compte"%>
<%@page import="com.dao.professeur.ProfesseurDaoImpl"%>
<%@page import="com.model.entities.Professeur"%>
<% Professeur prof =(Professeur)session.getAttribute("CompteModi");
Compte compte = prof.getCompte();%>
<main class="contenuPrincipal wrapper-main-content">

            <div class="page-offre-ent-titre">
                <h1>MODIFICATION DU COMPTE PROFESSEUR</h1>
                <div class="page-offre-ent-btns">
                    <a href="Modifier" class="page-offre-ent-btns-1"><i class="fa-solid fa-left-long"></i></a>
                </div>
            </div>
            <br>
            <form action="Modifier" method="post">
                <label for="Courriel" >Courriel: </label><br>
                <input type="text" id="input_border" name="Courriel" value="<%=compte.getCourriel()%>"><br>
                 <label for="DA" >Numero DA </label><br>
                <input type="text" id="input_border" name="DA" value="<%=prof.getNumeroDa()%>"><br>
                <label for="prenom">Prenom: </label><br>
                <input type="text" id="input_border" name="Prenom" value="<%=prof.getPrenom()%>"><br>
                <label for="nom">Nom: </label><br>
                <input type="text" id="input_border" name="Nom" value="<%=prof.getNom()%>"><br>
                <br>
                <input type="hidden" name="CompteAModifier" value="professeur">
                <input type="hidden" name="CompteId" value="<%=prof.getId()%>">
                <input type="submit" class="search-btn-input" value="Modifier votre le professeur">
            </form>
        </main>