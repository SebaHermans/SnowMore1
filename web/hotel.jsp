<%--
    Document   : hotel
    Created on : 21-apr-2017, 14:26:50
    Author     : Sebastiaan
--%>

<%@page import="fact.it.www.beans.Hotel"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%Hotel hotel = (Hotel) request.getAttribute("hotel");%>
<!DOCTYPE html>
<html>
    <head>
      <link rel="stylesheet" href="newstyle.css">
      <link href="https://fonts.googleapis.com/css?family=El+Messiri" rel="stylesheet">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Hotel</title>
    </head>
    <body>
      <div class="container">
          <h1>Hier ziet u een voorbeeld van een hotel. </h1>
        <p>Hotelnaam: <%=hotel.getHotelnaam()%></p>
        <p>Aantal Sterren: <%=hotel.getAantalSterren()%></p>
        <p><a href="index.jsp">Terug naar de home pagina</a></p>
      </div>
    </body>
</html>
