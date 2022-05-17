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
        <title>Ajouter</title>
        <link rel="stylesheet" href="css/style.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.1/css/all.min.css" integrity="sha512-KfkfwYDsLkIlwQp6LFnl8zNdLGxu9YAA1QvwINks4PhcElQSvqcyVLLD9aMhXd13uQjoXtEKNosOWaZqXgel0g==" crossorigin="anonymous" referrerpolicy="no-referrer" />
    </head>
    <body>
        <jsp:include page="header.jsp"/>
        <jsp:include page="sidenav.jsp"/>
        <main class="contenuPrincipal">

           <% ArrayList<String> listCategory = (ArrayList) session.getAttribute("listCategory");%>
            <h2>Type de compte :</h2><br>
            <select name="category">
                <% for (int i = 0 ; listCategory.size()>i;i++) { %>
                <option value="<%=listCategory.get(i)%>" > <%=listCategory.get(i)%> </option>
                <%}%>
            </select>   
        </main>
    </body>
</html>

