<%@page import="com.model.entities.Compte"%>
<%@page import="com.dao.entreprise.EntrepriseDaoImpl"%>
<%@page import="com.model.entities.Entreprise"%>
<% Entreprise entreprise = (Entreprise) session.getAttribute("CompteModi");
    Compte compte = entreprise.getCompte();%>
<main class="contenuPrincipal wrapper-main-content">

    <div class="page-offre-ent-titre">
        <h1>MODIFICATION DU COMPTE ADMINISTRATEUR</h1>
        <div class="page-offre-ent-btns">
            <a href="Modifier" class="page-offre-ent-btns-1"><i class="fa-solid fa-left-long"></i></a>
        </div>
    </div>
    <br>
    <form action="Modifier" method="post">
        <label for="Courriel" >Courriel: </label><br>
        <input type="text" id="input_border" name="Courriel" value="<%=compte.getCourriel()%>"><br>


        <label for="nom">Nom: </label><br>
        <input type="text" id="input_border" name="Nom" value="<%=entreprise.getNom()%>"><br>
        <label for="prenom">Personne référence: </label><br>
        <input type="text" id="input_border" name="personneReference" value="<%=entreprise.getPersonneReference()%>"><br>
        <label for="prenom">Description: </label><br>
        <input type="text" id="input_border" name="description" value="<%=entreprise.getDescription()%>"><br>
        <input type="hidden" name="CompteAModifier" value="entreprise">
        <input type="hidden" name="CompteId" value="<%=entreprise.getId()%>">
        <input type="submit" class="search-btn-input" value="Modifier votre l'entreprise">
    </form>
</main>