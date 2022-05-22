<%@page import="com.model.entities.Compte"%>
<%@page import="com.dao.etudiant.EtudiantDaoImpl"%>
<%@page import="com.model.entities.Etudiant"%>
<% Etudiant etudiant =(Etudiant)session.getAttribute("CompteModi");
Compte compte = etudiant.getCompte();%>
<main class="contenuPrincipal wrapper-main-content">

            <div class="page-offre-ent-titre">
                <h1>MODIFICATION DU COMPTE ÉTUDIANT</h1>
                <div class="page-offre-ent-btns">
                    <a href="Modifier" class="page-offre-ent-btns-1"><i class="fa-solid fa-left-long"></i></a>
                </div>
            </div>
            <br>
            <form action="Modifier" method="post">
                <label for="Courriel" >Courriel: </label><br>
                <input type="text" id="input_border" name="Courriel" value="<%=compte.getCourriel()%>"><br>
                 <label for="DA" >Numero DA </label><br>
                <input type="text" id="input_border" name="DA" value="<%=etudiant.getNumeroDa()%>"><br>
                <label for="prenom">Prenom: </label><br>
                <input type="text" id="input_border" name="Prenom" value="<%=etudiant.getPrenom()%>"><br>
                <label for="nom">Nom: </label><br>
                <input type="text" id="input_border" name="Nom" value="<%=etudiant.getNom()%>"><br>
                <br>
                <input type="hidden" name="CompteAModifier" value="etudiant">
                <input type="hidden" name="CompteId" value="<%=etudiant.getId()%>">
                <input type="submit" class="search-btn-input" value="Modifier votre l'étudiant">
            </form>
        </main>