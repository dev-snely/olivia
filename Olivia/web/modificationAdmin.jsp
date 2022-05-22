<%@page import="com.model.entities.Compte"%>
<%@page import="com.dao.admin.AdminDaoImpl"%>
<%@page import="com.model.entities.Admin"%>
<% Admin admin =(Admin)session.getAttribute("CompteModi");
Compte compte = admin.getCompte();%>
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

                <label for="prenom">Prenom: </label><br>
                <input type="text" id="input_border" name="Prenom" value="<%=admin.getPrenom()%>"><br>
                <label for="nom">Nom: </label><br>
                <input type="text" id="input_border" name="Nom" value="<%=admin.getNom()%>"><br>
            
                <input type="hidden" name="CompteAModifier" value="admin">
                <input type="hidden" name="CompteId" value="<%=admin.getId()%>">
                <input type="submit" class="search-btn-input" value="Modifier votre l'administrateur">
            </form>
        </main>