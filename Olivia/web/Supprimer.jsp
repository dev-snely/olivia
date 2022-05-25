<%-- 
    Document    : homePage
    Created on  : 02-Apr-2022
    Author      : Mahmoud
    Modified by : Snely
    on          : 28th-Apr-2022
--%>

<%@page import="com.model.entities.Compte"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="com.model.entities.Offre"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Ajouter</title>
        <link rel="stylesheet" href="css/style.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.1/css/all.min.css" integrity="sha512-KfkfwYDsLkIlwQp6LFnl8zNdLGxu9YAA1QvwINks4PhcElQSvqcyVLLD9aMhXd13uQjoXtEKNosOWaZqXgel0g==" crossorigin="anonymous" referrerpolicy="no-referrer" />
    </head>
    <body class="wrapper">

        <div class="wrapper-header">
            <jsp:include page="header.jsp"/>
        </div>
        <div class="wrapper-side">
            <jsp:include page="sidenav.jsp"/>
        </div>

         <main class="contenuPrincipal wrapper-main-content ">
            <form class="formulaire-inscription" id="formulaire-inscription" action="Supprimer" method="post">
                <%if ((boolean)session.getAttribute("retour")){
                    ArrayList<String> listCategory = (ArrayList) session.getAttribute("listCategory");%>
                <h2>Type de compte :</h2><br>
                <select name="typeCompte" id="typeCompte">
                    <% for (int i = 0; listCategory.size() > i; i++) {%>
                    <option value="<%=listCategory.get(i)%>" name = "typeCompte" > <%=listCategory.get(i)%> </option>
                    <%}%>
                </select>   
                <button class="btn-inscription" type="submit">Rechercher</button>
                <%
                } else {
                    ArrayList<Compte> listCompte = (ArrayList) session.getAttribute("compte");%>
                <h2>Compte à supprimer  :</h2><br>
                <select name="supprimer" id="supprimer">
                    <% for (int i = 0; listCompte.size() > i; i++) {
                    Compte unCompte=listCompte.get(i);%>
                    <option value="<%=unCompte.getId()%>" name = "compteSupprimer" > <%=unCompte.getCourriel()%> </option>
              
                <% }%>
                 </select>   
                <button class="btn-inscription" type="submit">Supprimer</button>
                <%}%>
 

            </form>
        </main>
    </body>

</html>

