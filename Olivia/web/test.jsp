<%-- 
    Document   : test
    Created on : 2022-05-26, 08:14:36
    Author     : gabri
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1><%=session.getAttribute("test")%>
    </body>
</html>
