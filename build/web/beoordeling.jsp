<%-- 
    Document   : beoordeling
    Created on : 12-jun-2017, 9:39:34
    Author     : Sebastiaan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="newstyle.css">
        <link href="https://fonts.googleapis.com/css?family=El+Messiri" rel="stylesheet">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Beoordeling</title>
    </head>
    <body>
        <div class="container">
        <h1>Geef hier je beoordeling</h1>
        <form action="UitbereidingServlet">
            <p><label name="score">Score (op 10): </label> <input type="text"  name="score"></p>
            <p><label name="naam">Naam: </label> <input type="text" name="naam"></p>
            <p><label name="beoordeling">Beoordeling: </label> <input type="text" name="beoordeling"></p>
            <p><input type="submit" value="Bevestig" name="bevestigBeoordeling"</p>
        </form>
        </div>
    </body>
</html>
