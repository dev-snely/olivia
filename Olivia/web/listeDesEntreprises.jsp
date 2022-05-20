<%-- 
    Document   : listeDesEntreprises
    Created on : 2022-05-17, 14:41:09
    Author     : Mahmo
--%>

<%@page import="com.model.entities.Entreprise"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Tableau de bord</title>
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

        <main class="contenuPrincipal wrapper-main-content">
            <% switch ((String) session.getAttribute("typeCompte").toString().toLowerCase()){
                case "professeur": %>
                    <h1>TABLEAU DES ENTREPRISES </h1><br>
                    <tbody>
                    <% 
                        List<Entreprise> lesEntreprises = (ArrayList<Entreprise>) session.getAttribute("liste");
                        if (lesEntreprises != null){
                            if(lesEntreprises.size() == 0){
                            
                        %>
                         <tr>
                        <td>Aucun Entreprise.</td>
                        
                    </tr>
                        
                        <%
                        } else if(lesEntreprises.size() >0){
                            %> <table class="tbd-table">
                                <thead>
                                    <tr>
                                        <th>Nom Entreprise</th>
                                         <th>Description</th>
                                          <th>Personne Reference</th>
                                    </tr>
                                </thead>
                                <tbody>
                                
                                <%
                                for (int i = 0; lesEntreprises.size() > i; i++){

                                %>
                                
                                <tr>   
                    <td><%= lesEntreprises.get(i).getNom() %> </td>
                    <td><%= lesEntreprises.get(i).getDescription() %> </td>
                    <td><%= lesEntreprises.get(i).getPersonneReference() %> </td>
                    </tr>   

                        <% }} } } %>
 
                        
                        
                         </tbody>
                         </table> 
                
            
            
            
            
            
        </main>
    </body>
</html>
