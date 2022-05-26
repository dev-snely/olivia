<%-- 
    Document   : StagesPostules
    Created on : 2022-05-25, 15:26:39
    Author     : Mahmo
--%>

<%@page import="com.action.EntrepriseAction"%>
<%@page import="com.model.entities.Offre"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.model.entities.Postulation"%>
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
           <!-- Vérifier si c'est vraiment un étudiant qui accède la page -->
           <% if ( session.getAttribute("typeCompte").toString().toLowerCase().equals("etudiant")) {
            List<Postulation> listePost = (ArrayList<Postulation>) session.getAttribute("listePostulations");
                    %>
                    <h1>Tableau des stages</h1>
                    <hr><br>
                    <p>Lorsqu'une entreprise vous <span style='color:purple;font-weight:bold'>retient</span>, vous pouvez <br>accepter l'offre en cliquant sur le <span style='color:green;font-weight:bolder'>bouton vert</span> <br>
                         ou la refuser en cliquant sur le <span style='color:red;font-weight:bold'>bouton rouge.</span></p>
                    <table class="tbd-table">
                <thead>
                    <tr>
                        <th>Nom du Poste</th>
                        <th>Nom de l'entreprise</th>
                        <th>Retenu par l'entreprise</th>
                        <th>Date de début</th>
                        <th>Date de fin</th>
                        <th>Accepter Offre</th>
                        <th>Refuser Offre</th>
                        <th>Votre état</th>
                    </tr>
                </thead>
                <tbody>
                    <%   for (int i = 0; i < listePost.size(); i++) { %>
                            
                    <tr>
                        <td><%= listePost.get(i).getOffre().getPoste() %></td>
                        <%
                        String nomEnt = EntrepriseAction.findEntrepriseParOffre(listePost.get(i).getOffre()).getNom();
                        %>
                        <td><%= nomEnt %></td>
                        <td><% if(listePost.get(i).isAcceptation()){
                             %> Retenu <%
                            }else{ %> Pas retenu <%  } %>
                             </td>                                       
                             <td><% if(listePost.get(i).getEtudiant().getOccupation()==null){  %>
                                 Aucune date inscrite <% }else{  %> <%=listePost.get(i).getEtudiant().getOccupation().getDateDebut()%> <%} %>
                                 </td>
                                       
                         <td><% if(listePost.get(i).getEtudiant().getOccupation()==null){  %>
                             Aucune Date inscrite <% }else{  %> <%=listePost.get(i).getEtudiant().getOccupation().getDatefin()%> <%} %>
                                 </td>
                                 
                                 
                        <td>  <% if(listePost.get(i).isAcceptation()){
                            %> <a <% Postulation post = listePost.get(i);
                                   session.setAttribute("postilationAaccepter", post);
                                   Offre loffre = listePost.get(i).getOffre(); 
                            session.setAttribute("offreAaccepter", loffre);%> href="acceptPostulation?idOffre=<%=listePost.get(i).getOffre().getId() %>"  >  <i class="fa-regular fa-circle-check " style='color: green'> </i>    </a> <%
                            }else{ %> <%  } %>
                              </td>
                         <td>  <% if(listePost.get(i).isAcceptation()){
                            %> <a <%  Offre loffre = listePost.get(i).getOffre(); 
                                session.setAttribute("offreArefuser", loffre);%> href="offreRefuse?idOffre=<%=listePost.get(i).getOffre().getId() %>"  >  <i class="fa-solid fa-ban" style='color: red'></i>  </i>    </a> <%
                            }else{ %> <%  } %>
                              </td>
                              <td><% if(listePost.get(i).isSignature()){ %>
                                  Vous avez accepté l'offre
                                  <%} else {%> Rien encore <% } 
                                  
                                  %>
                              </td>
                        
                    </tr>
                    <% } %>
                </tbody>
            </table>
                    
                    
            
            
            
                    <%}
else { %>   <h1>Vous n'etes pas supposé être ici Hacker</h1>

 <% } %>

                    
            
            
            
            
            
        </main>
        
        
        
        
        
    </body>
</html>
