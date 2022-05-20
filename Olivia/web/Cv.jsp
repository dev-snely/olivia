<%-- 
    Document    : homePage
    Created on  : 02-Apr-2022
    Author      : Mahmoud
    Modified by : Snely
    on          : 28th-Apr-2022
--%>

<%@page import="com.model.entities.CV"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="com.model.entities.Offre"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Curriculum Vitae</title>
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
            
        <% CV cv=(CV)session.getAttribute("cv");%>
            <h1>Curriculum Vitae </h1><br>
            <h2>Vos informations</h2>
            <hr>
            <table class="tbd-table">
                <thead>
                    <tr>
                        <th>Résume</th>
                        <th>Experience de travail</th>
                        <th>Éducation</th>
                        <th>Certification</th>
                        <th>Compétence</th>
                        <th>Langue(s) parlés</th>
                        
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td><%=cv.getResume()%></td>
                        <td><%=cv.getExperienceTravail()%></td>
                        <td><%=cv.getEducation()%></td>
                        <td><%=cv.getCertification()%></td>
                         <td><%=cv.getCompetence()%></td>
                          <td><%=cv.getLangue()%></td>
                    </tr>
                </tbody>
            </table>
         
        </main>
    </body>
</html>

