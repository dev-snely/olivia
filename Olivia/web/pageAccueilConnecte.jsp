<%-- 
    Document   : pageAccueilConnecte
    Created on : 26-May-2022, 2:17:12 AM
    Author     : LysAd
--%>

<%@page import="java.util.ResourceBundle"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
    ResourceBundle msg = ResourceBundle.getBundle("ressources.MessageBundle");
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title></title>
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
        
            <h1><%=msg.getString("bonjour-etudiants")%><h1>
            <img  src="images/students-jumping-on-graduation-day.png" height="500px" alt='etudiants'>
            
            <%break;
        case "professeur":%>
        
            <h1><%=msg.getString("bonjour-prof")%></h1>
            <img  src="images/teaching.png" height="500px" alt='teacher'>
        
        <%break;
        case "entreprise":%>
        
            <h1><%=msg.getString("bonjour-entreprises")%></h1>
            <img  src="images/Lovepik_com-450094982-Branding flat outline icon corporate identity.png" height="500px" alt='teacher'>
        <%break;
        default:%>
        
            <h1><%=msg.getString("bonjour-hacker")%></h1>
        <%}%>
            <p style='font-weight: 300;'> Lorem ipsum dolor sit amet, consectetur adipiscing elit. Phasellus vitae pretium elit. Vivamus dictum lorem sit amet aliquet porta. Sed rhoncus nisi eu sapien condimentum, sed aliquam ipsum blandit. Mauris ultricies sem at mauris ultricies, a tristique eros lobortis. Curabitur ut felis ex. Donec dictum laoreet ex, vitae suscipit nibh molestie quis. Sed in lacus eu metus rutrum porta non vitae augue. Pellentesque ornare ligula ut justo rhoncus vestibulum. Pellentesque vulputate pulvinar tortor vitae accumsan. Nulla facilisi. Etiam rutrum vulputate ex condimentum lacinia. Pellentesque non libero viverra, finibus purus at, tristique lacus. Praesent rhoncus dictum nunc, in accumsan enim vulputate pellentesque.

                        Quisque pharetra mauris nibh, eget vestibulum urna finibus ac. </p>
                        <br>

            <p style='font-weight: 300;'> Lorem ipsum dolor sit amet, consectetur adipiscing elit. Phasellus vitae pretium elit. Vivamus dictum lorem sit amet aliquet porta. Sed rhoncus nisi eu sapien condimentum, sed aliquam ipsum blandit. Mauris ultricies sem at mauris ultricies, a tristique eros lobortis. Curabitur ut felis ex. Donec dictum laoreet ex, vitae suscipit nibh molestie quis. Sed in lacus eu metus rutrum porta non vitae augue. Pellentesque ornare ligula ut justo rhoncus vestibulum. Pellentesque vulputate pulvinar tortor vitae accumsan. Nulla facilisi. Etiam rutrum vulputate ex condimentum lacinia. Pellentesque non libero viverra, finibus purus at, tristique lacus. Praesent rhoncus dictum nunc, in accumsan enim vulputate pellentesque.

                        Quisque pharetra mauris nibh, eget vestibulum urna finibus ac. </p>

        </main>
    </body>
</html>
