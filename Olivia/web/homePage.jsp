<%-- 
    Document    : homePage
    Created on  : 02-Apr-2022
    Author      : Mahmoud
    Modified by : Snely
    on          : 28th-Apr-2022
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="com.model.entities.Offre"%>
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

            <% switch ((String) session.getAttribute("typeCompte").toString().toLowerCase()) {
                    case "etudiant":%>
            <h1>TABLEAU DE BORD </h1><br>
            <h2>Vos informations</h2>
            <hr>
            <table class="tbd-table">
                <thead>
                    <tr>
                        <th>Nom</th>
                        <th>Prénom</th>
                        <th>Courriel</th>
                        
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td><%=session.getAttribute("nom")%></td>
                        <td><%=session.getAttribute("prenom")%></td>
                        <td><%=session.getAttribute("email")%></td>
                        
                        
                    </tr>
                </tbody>
            </table>
            <br>
            <h2>Statut du stage</h2>
            <hr>
            <table class="tbd-table">
                <thead>
                    <tr>
                        <th>Nom de l'entreprise</th>
                        <th>Retenu par l'entreprise</th>
                        <th>Date de début</th>
                        <th>Date de fin</th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td>CHUM</td>
                        <td>Decision non prise</td>
                        <td>2022-06-02</td>
                        <td>2022-09-02</td>
                    </tr>
                </tbody>
            </table>
            <%break;
                case "admin":%>
            <h1>TABLEAU DE BORD </h1><br>
            <h2>Vos informations</h2>
            <hr>
            <table class="tbd-table">
                <thead>
                    <tr>
                        <th>Nom</th>
                        <th>Prénom</th>
                        <th>Courriel</th>
                        <th>Lien vers Curriculum Vitae</th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td><%=session.getAttribute("nom")%></td>
                        <td><%=session.getAttribute("prenom")%></td>
                        <td><%=session.getAttribute("email")%></td>
                        <td>lien vers CV</td>
                    </tr>
                </tbody>
            </table>
            <%break;
                case "entreprise":%>
            <h1>TABLEAU DE BORD </h1><br>
            <h2>Vos informations</h2>
            <hr>
            <table class="tbd-table">
                <thead>
                    <tr>
                        <th>Nom de l'entreprise</th>
                        <th>Description</th>
                        <th>Personne Référence</th>
                        <th>Email</th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td><%=session.getAttribute("nom")%></td>
                        <td><%=session.getAttribute("description")%></td>
                        <td><%=session.getAttribute("personneReference")%></td>
                        <td><%=session.getAttribute("email")%></td>
                    </tr>
                </tbody>
            </table>
            <br>
            <h2>Vos offres de stage</h2>
            <hr>
            <table class="tbd-table">
                <thead>
                    <tr>
                        <th>Nom du poste</th>
                        <th>Description</th>
                        <th>Rémuneration</th>

                    </tr>
                </thead>
                <tbody>
                    <% List<Offre> lesOffre = (ArrayList<Offre>) session.getAttribute("lesOffres");
                  
                        for (int i = 0 ; lesOffre.size()>i;i++) {%>
                    <tr>
                        <%System.out.println(lesOffre.get(i).getDescription());%>
                        <td> <%=lesOffre.get(i).getPoste()%> </td>
                        <td><%=lesOffre.get(i).getDescription()%></td>
                        <td><%=lesOffre.get(i).getRemuneration()%>$/Heure</td>

                    </tr>
                    <%} %>
                </tbody>
            </table>
            <% break;
                case "professeur":%>
                      <h1>TABLEAU DE BORD </h1><br>
            <h2>Vos informations</h2>
            <hr>
            <table class="tbd-table">
                <thead>
                    <tr>
                        <th>Nom</th>
                        <th>Prénom</th>
                        <th>Courriel</th>
                        
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td><%=session.getAttribute("nom")%></td>
                        <td><%=session.getAttribute("prenom")%></td>
                        <td><%=session.getAttribute("email")%></td>
                     
                    </tr>
                </tbody>
                
            </table>
            <%break;
                default:%>
            <p>C'est pas normal que tu te sois rendu ici hacker</p>
            <%}%>
        </main>
    </body>
</html>

