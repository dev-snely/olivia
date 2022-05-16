<%-- 
    Document   : pageFormulaireDePostulation
    Created on : 16-May-2022, 11:51:12 AM
    Author     : LysAd
--%>

<%@page import="com.model.entities.Offre"%>
<%@page import="com.model.entities.Entreprise"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Formulaire de postulation</title>
        <link rel="stylesheet" href="css/style.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.1/css/all.min.css" integrity="sha512-KfkfwYDsLkIlwQp6LFnl8zNdLGxu9YAA1QvwINks4PhcElQSvqcyVLLD9aMhXd13uQjoXtEKNosOWaZqXgel0g==" crossorigin="anonymous" referrerpolicy="no-referrer" />
    </head>
    <body>
        <jsp:include page="header.jsp"/>
        <jsp:include page="sidenav.jsp"/>

        <main class="contenuPrincipal">
            <%
                Offre offre = (Offre) request.getAttribute("offreAAfficher");
                Entreprise ent = (Entreprise) request.getAttribute("entAAfficher");
            %>
            <caption><h2>ENVOYER UNE DEMANDE DE POSTULATION</h2></caption>
            <form action="envoyerEmail" method="post" enctype="multipart/form-data">
                <table style="width:120%" border="0" align="center" >
                    
                    <br>
                    <tr>
                        <td width="20%">Destinataire: </td>
                        <td><input type="text" id="input_border" name="destinataire" size="70" value="<%=ent.getCompte().getCourriel()%>"/></td>
                    </tr>
                    <tr>
                        <td>Objet:</td>
                        <td><input type="text" id="input_border" name="objet" size="50" value="Demande de postulation pour le poste de <%=offre.getPoste()%>"/></td>
                    </tr>
                    <tr>
                        <td>Demande de postulation : </td>
                        <td><textarea rows="10" id="input_border" cols="39" name="contenu"></textarea> </td>
                    </tr>
                    <tr>
                        <td>Attacher fichier </td>
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
