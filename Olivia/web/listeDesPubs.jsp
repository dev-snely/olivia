<%-- 
    Document   : listeDesPubs
    Created on : 2022-05-21, 11:40:20
    Author     : Mahmo
--%>

<%@page import="com.model.entities.Publicite"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
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
                    <h1>TABLEAU DES PUBLICITÉS </h1><br>
                    <tbody>
                    <% 
                        List<Publicite> lesPubs = (ArrayList<Publicite>) session.getAttribute("listePubs");
                        if (lesPubs != null){
                            if(lesPubs.size() == 0){
                            
                        %>
                         <tr>
                        <td>Aucun Entreprise.</td>
                        
                    </tr>
                        
                        <%
                        } else if(lesPubs.size() >0){
                            %> <table class="tbd-table">
                                <thead>
                                    <tr>
                                        
                                         <th>Contenu</th>
                                          <th>IMG Link</th>
                                          <th> Supprimer </th>
                                    </tr>
                                </thead>
                                <tbody>
                                
                                <%
                                for (int i = 0; lesPubs.size() > i; i++){

                                %>
                                
                                <tr>   
                    <td><%= lesPubs.get(i).getContenu() %> </td>
                    <td><img src="<%= lesPubs.get(i).getImgLink() %>" alt="pub" height="250px"> </td>
                   
                    <td style='text-align: center;vertical-align: middle;'>
                            <a href="deletePublicite?id=<%=lesPubs.get(i).getId()%>">
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
