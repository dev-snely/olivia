<%-- 
    Document   : priseDeRDVParCourriel
    Created on : 25-May-2022, 6:12:03 PM
    Author     : LysAd
--%>

<%@page import="com.model.entities.Etudiant"%>
<%@page import="com.action.EtudiantAction"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Prise de RDV</title>
        <link rel="stylesheet" href="css/style.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.1/css/all.min.css" integrity="sha512-KfkfwYDsLkIlwQp6LFnl8zNdLGxu9YAA1QvwINks4PhcElQSvqcyVLLD9aMhXd13uQjoXtEKNosOWaZqXgel0g==" crossorigin="anonymous" referrerpolicy="no-referrer" />
    </head>
    <body class="wrapper">

        <div class="wrapper-header">
            <jsp:include page="../header.jsp"/>
        </div>
        <div class="wrapper-side">
            <jsp:include page="../sidenav.jsp"/>
        </div>


        <%
            int idEtudaint = (int) request.getAttribute("idEtudiant");
            Etudiant etu = EtudiantAction.findEtudiantById(idEtudaint);
        %>

        <main class="contenuPrincipal wrapper-main-content">

            <caption><h2>PROPOSER UNE DATE D'ENTREVUE A VOTRE CANDIDAT </h2></caption>
            <form action="planifierDateEntrevue" method="post" enctype="multipart/form-data">
                <table style="width:80%" border="0" align="center" >
                    <input type='hidden' name='idEtudiant' value=<%=etu.getId()%>>
                    <input type='hidden' name='emailEtudiant' value=<%=etu.getCompte().getCourriel()%>>
                    <br>
                    <tr>
                        <td width="20%">Adresse courriel du destinataire: </td>
                        <td><input type="text" id="input_border" name="destinataire" size="70" value="<%=etu.getCompte().getCourriel()%>"/></td>
                    </tr>
                    <tr>
                        <td>Objet:</td>
                        <td><input type="text" id="input_border" name="objet" size="50" value="Rendez-vous pour un entrevue"/></td>
                    </tr>
                    <tr>
                        <td>Planifier votre entrevue avec l'étudiant: </td>
                        <td><textarea rows="10" id="input_border" cols="39" name="contenu" >Bonjour <%=etu.getNom()%>, 

Nous avons reçu votre candidature et aimerions
prendre rendez-vous avec vous pour une entrevue le : 

xx/xx/xxxx

Au plaisir de vous rencontrer!


________________________________________________________________
Nom de l'entreprise : <%=session.getAttribute("nom")%>
Email de l'entreprise : <%=session.getAttribute("email")%>
</textarea> </td>
                    </tr>
                    <tr>
                        <td>Attacher fichier (Documents vierges à remplir par le candidat ) </td>
                        <td><input type="file" id="input_border" name="file" size="50" /></td>
                    </tr>
                    <br>
                    <tr>
                        <td colspan="2" align="center"><input class="search-btn-input" type="submit" value="Envoyer"/></td>
                    </tr>
                    
                </table>
            </form>

        </main>
    </body>
</html>
