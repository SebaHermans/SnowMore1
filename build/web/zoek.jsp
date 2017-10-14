<%--
    Document   : zoek
    Created on : 29-mei-2017, 13:48:20
    Author     : Sebastiaan
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="fact.it.www.beans.Hotel"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
      <link rel="stylesheet" href="newstyle.css">
      <link href="https://fonts.googleapis.com/css?family=El+Messiri" rel="stylesheet">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Uitgebreid zoeken</title>
    </head>
    <body>
      <div class="container">
          <h1>Zoek Criteria</h1>
        <form action="ZoekServlet">
            <p>Hoeveel sterren moet het hotel minstens hebben? </p>
            <input type="radio" name="sterren" value="2" >2 Sterren<br>
            <input type="radio" name="sterren" value="3" >3 Sterren<br>
            <input type="radio" name="sterren" value="4" >4 Sterren<br>
            <input type="radio" name="sterren" value="5" >5 Sterren<br>
            <input type="submit" name="sterrenKiezen" value="Zoek op aantal sterren">
            <br>
            <br>
            <input type="text" name="hotelnaam">
            <input type="submit" name="hotelzoeken" value="Zoek op hotelnaam">
            <br>
            <br>
            <input type="text" name="prijs">
            <input type="submit" name="prijslijst" value="Zoek op prijs">
        </form>

        <p><a href="index.jsp">Terug naar index</a></p>
      </div>
    </body>
</html>
