<%-- 
    Document    : homePage
    Created on  : 02-Apr-2022
    Author      : Mahmoud
    Modified by : Snely
    on          : 28th-Apr-2022
--%>

<%@page import="java.util.ResourceBundle"%>
<%@page import="com.model.entities.Compte"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="com.model.entities.Offre"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    ResourceBundle msg = ResourceBundle.getBundle("ressources.MessageBundle");
%>
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
            <form class="formulaire-inscription" id="formulaire-inscription" action="Modifier" method="post">
                <%if ((boolean) session.getAttribute("retourDebut") && (boolean) session.getAttribute("retour")) {
                        ArrayList<String> listCategory = (ArrayList) session.getAttribute("listCategory");%>
                <h2>Type de compte :</h2><br>
                <select name="typeCompte" id="typeCompte">
                    <% for (int i = 0; listCategory.size() > i; i++) {%>
                    <option value="<%=listCategory.get(i)%>" name = "typeCompte" > <%=listCategory.get(i)%> </option>
                    <%}%>
                </select>   
                <button class="btn-inscription" type="submit">Rechercher</button>
                <%
                } else if ((boolean) session.getAttribute("retour")) {%>
                <%  switch ((String) session.getAttribute("typeCompteModif")) {
                        case "etudiant": {
                %>
                <jsp:include page="modificationEtudiant.jsp"/>
                <%
                        break;
                    }
                    case "entreprise": {
                %>
                <jsp:include page="modificationEntreprise.jsp"/>
                <%
                        break;
                    }
                    case "admin": {
                %>
                <jsp:include page="modificationAdmin.jsp"/>
                <%
                        break;
                    }
                    case "professeur": {
                %>
                <jsp:include page="modificationProf.jsp"/>
                <%
                            break;
                        }
                        default:
                            break;
                    }%>
                <%} else {
                    ArrayList<Compte> listCompte = (ArrayList) session.getAttribute("compte");%>
                <h2><%= msg.getString("acctToDelete") %></h2><br>
                <select name="modifier" id="modifier">
                    <% for (int i = 0; listCompte.size() > i; i++) {
                            Compte unCompte = listCompte.get(i);%>
                    <option value="<%=unCompte.getId()%>" name = "modifier" > <%=unCompte.getCourriel()%> </option>

                    <% }%>
                </select>   
                <button class="btn-inscription" type="submit"><%= msg.getString("Modifier") %></button>
                <%}%>


            </form>
        </main>
    </body>
 
</html>

