<%-- 
    Document   : pageFormulaireDePostulationResultat
    Created on : 17-May-2022, 5:10:18 PM
    Author     : LysAd
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Résultat de l'envoi</title>
        <link rel="stylesheet" href="css/style.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.1/css/all.min.css" integrity="sha512-KfkfwYDsLkIlwQp6LFnl8zNdLGxu9YAA1QvwINks4PhcElQSvqcyVLLD9aMhXd13uQjoXtEKNosOWaZqXgel0g==" crossorigin="anonymous" referrerpolicy="no-referrer" />
    </head>
    <body>
        <jsp:include page="header.jsp"/>
        <jsp:include page="sidenav.jsp"/>
        
        
        <main class="contenuPrincipal">
            <h1>Résultat de l'envoi</h1>
            <br>
            <%
                if ((boolean)request.getAttribute("Success") == true){
            %>
                <h3><%=request.getAttribute("Message")%> 😀</h3>
            <%
                
                }else{
            %>
                <h3><%=request.getAttribute("Message")%> 😬</h3>
            <%    
                }
            %>
            
        </main> 
    </body>
</html>
