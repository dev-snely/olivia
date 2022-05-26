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
        <title>Liste des etudiants</title>
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
                    <h1>TABLEAU DES ÉTUDIANTS </h1><br>
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
                                          
                                          <th>Supprimer</th>
                                          
                                    </tr>
                                </thead>
                                <tbody>
                                
                                <%
                                for (int i = 0; lesEtudiants.size() > i; i++){

                                %>
                                
                                <tr>   
                        <td><%= lesEtudiants.get(i).getNom()%> </td>
                        <td><%= lesEtudiants.get(i).getPrenom()%> </td>
                         <td><%= lesEtudiants.get(i).getNumeroDa()%> </td>
                        <%if (lesEtudiants.get(i).getOccupation() == null) {%>
                        <td>non</td>

                            <%} else {%>
                        <td>    <%=lesEtudiants.get(i).getOccupation().isDisponible()%>
                               
                             </td>
   
                        <%}%>
                      

                     
                        <td style='text-align: center;vertical-align: middle;'>
                            <a href="deleteEtudiant?id=<%=lesEtudiants.get(i).getId()%>">
                                <i class="delete-icon fa-solid fa-trash-can"></i>
                            </a>
                        </td>
                    
                    </tr>   

                        <% }} } } %>
 
                        
                        
                         </tbody>
                         </table> 
                
            
            
            
            
            
        </main>
    </body>
</html>
