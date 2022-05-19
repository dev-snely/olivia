<%-- 
    Document   : formulaireCV
    Created on : 2022-05-03, 13:07:32
    Author     : Mahmo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        
         <link rel="stylesheet" href="css/style.css">
         <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.1/css/all.min.css" integrity="sha512-KfkfwYDsLkIlwQp6LFnl8zNdLGxu9YAA1QvwINks4PhcElQSvqcyVLLD9aMhXd13uQjoXtEKNosOWaZqXgel0g==" crossorigin="anonymous" referrerpolicy="no-referrer" />
         
        <title>Postulation CV</title>
    </head>
    <body class="wrapper">

        <div class="wrapper-header">
            <jsp:include page="header.jsp"/>
        </div>
        <div class="wrapper-side">
            <jsp:include page="sidenav.jsp"/>
        </div>

        <main class="contenuPrincipal wrapper-main-content">
        <h1>Page d'application du CV</h1>
        <br>
        <h2>Sur cette page, vous pouvez mettre vos renseignement de cv afin de mettre votre profil à jour.</h2>
        <br>
        
        <form action="Cv">
            <label   for="Resume" >Votre Résumé: </label><br>
            <input id="input_border" type="text"  name="leresume" value=""><br>
            <label   for="ExpTravail" >Votre Experience de travail: </label><br>
            <input type="text" id="input_border" name="experiencetravail" value=""><br>
            <label   for="Resume" >Votre Éducation </label><br>
            <input type="text" id="input_border" name="education" value=""><br>
            <label   for="Resume" >Votre Certification </label><br>
            <input type="text" id="input_border" name="certification" value=""><br>
            <label   for="Resume" >Votre Competences </label><br>
            <input type="text" id="input_border" name="competences" value=""><br>
            <label   for="Resume" >Vos langues parlés: </label><br>
            <input type="text" id="input_border"  name="langages" value=""><br>
            <br>
            <input type="submit" class="search-btn-input" value="Poster le CV">
            
            
        </form>
        


    </main>
    
</body>
</html>
