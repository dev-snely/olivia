<%-- 
    Document   : listeEtudiants
    Created on : 2022-05-18, 22:44:41
    Author     : Mahmo
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="com.model.entities.Etudiant"%>
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
    <body>
        <jsp:include page="header.jsp"/>
        <jsp:include page="sidenav.jsp"/>
        <main class="contenuPrincipal">
            <% switch ((String) session.getAttribute("typeCompte").toString().toLowerCase()){
                case "professeur": %>
                    <h1>TABLEAU DES ENTREPRISES </h1><br>
                    <tbody>
                    <% 
                        List<Etudiant> lesEtudiants = (ArrayList<Etudiant>) session.getAttribute("listeEtudiant");
                        if (lesEtudiants != null){
                            if(lesEtudiants.size() == 0){
                            
                        %>
                         <tr>
                        <td>Aucun Etudiant.</td>
                        
                    </tr>
                        
                        <%
                        } else if(lesEtudiants.size() >0){
                            %> <table class="tbd-table">
                                <thead>
                                    <tr>
                                        <th>Nom Etudiant</th>
                                         <th>Pernom Etudiant   </th>
                                          <th>Numero DA</th>
                                          <th>Disponibilité</th>
                                          
                                    </tr>
                                </thead>
                                <tbody>
                                
                                <%
                                for (int i = 0; lesEtudiants.size() > i; i++){

                                %>
                                
                                <tr>   
                    <td><%= lesEtudiants.get(i).getNom() %> </td>
                    <td><%= lesEtudiants.get(i).getPrenom()%> </td>
                    <td><%= lesEtudiants.get(i).getNumeroDa()%> </td>
                    <td><%= lesEtudiants.get(i).getOccupation() %> </td>
                    
                    </tr>   

                        <% }} } } %>
 
                        
                        
                         </tbody>
                         </table> 
                
            
            
            
            
            
        </main>
    </body>
</html>
