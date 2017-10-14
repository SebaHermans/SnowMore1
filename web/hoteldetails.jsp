<%--
    Document   : hoteldetails
    Created on : 28-apr-2017, 15:15:57
    Author     : Gebruiker
--%>
<%@page import="fact.it.www.beans.Hotel"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%Hotel hotel = (Hotel) request.getAttribute("detailsalles");%>

<!DOCTYPE html>
<html>
    <head>
      <link rel="stylesheet" href="newstyle.css">
      <link href="https://fonts.googleapis.com/css?family=El+Messiri" rel="stylesheet">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Hotel Details</title>
    </head>
    <body>
      <div class="container">
        
        <h1>Hotel Details</h1>
        <p>Hotelnaam: <%=hotel.getHotelnaam()%></p>
        <p>Aantal sterren: <%=hotel.getAantalSterren()%></p>
        <form action="AdminServlet">
            <input type="hidden" name="hotelid" value="<%=hotel.getId()%>"/>
            <label for="aanbodhotel">Skigebied: </label> <input class="linkButton" type="submit" name="aanbodhotel" value="<%=hotel.getSkigebied().getSkigebied()%>"/>
            
        </form>
        <img src="images/<%=hotel.getFoto()%>"/>

        <p><a href="index.jsp">Terug naar index</a></p>
      </div>
    </body>
</html>
