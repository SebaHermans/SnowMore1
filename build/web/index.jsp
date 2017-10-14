<%--
    Document   : index
    Created on : 31-mrt-2017, 13:37:21
    Author     : Sebastiaan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>

        <link rel="stylesheet" href="newstyle.css">
        <link href="https://fonts.googleapis.com/css?family=El+Messiri" rel="stylesheet">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Miniproject SnowMore</title>
    </head>
    <body>
        <div class="container">

        <h1>Zoek je skigebied/hotel</h1>
        <p id="vet">Build by Sebastiaan Hermans</p>
        <form action="ManageServlet" >
          <h2>Wil je de details van een ski gebied bekijken?</h2>
          <p>
              <label for="ski">Type de eerste letters van het skigebied.</label>
              <input type="text" name="ski" />
              <input type="submit" value="zoek skigebied" name="skigebied"/>
          </p>
          <h2>Wil je de details van een hotel bekijken? </h2>
          <input type="submit" value="één enkel hotel" name="hotel"/>
          <input type="submit" value="toon alle hotels" name="toonhotel"/>
          <input type="submit" value="bekijk het aanbod" name="aanbod"/>
        </form>
        <form action="zoek.jsp">
            <h2>Wil je naar een specifiek hotel zoeken?</h2>
            <input type="submit" value="Uitgebreid zoeken" naam="uitgebreidzoeken"/>
        </form>
        <form action="AdminServlet">
            <h2>Wil je info toevoegen?</h2>
            <input type="submit" value="admin" name="adminbutton"/>
        </form>
        <div class="center">
        <a href="ManageServlet?toonhotel"><img src="images/skivakantie.jpg"</a>
        </div>
        <form action="beoordeling.jsp">
            <input type="submit" value="Verdere uitbereiding" name="verdereUitbereiding">
        </form>
        </div>
    </body>
</html>
