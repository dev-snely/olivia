<%-- 
    Document   : faire pub
    Created on : 2022-05-25, 11:40:20
    Author     : gabri
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
            <form class="formulaire-inscription" id="formulaire-inscription"  action="FairePub" enctype="multipart/form-data" method="POST">
                <tr>

                <label   for="Description" >Votre Description </label><br>
                <input type="text" id="input_border" name="description" value=""><br>
                <td>Attacher votre image </td>
                <td><input type="file" id="input_border" name="file" size="50" /></td>
                </tr>     

                <button class="btn-inscription" type="submit">Créer</button>
            </form>



        </main>
    </body>
</html>
