<%--
    Document   : overzichtHotels
    Created on : 28-apr-2017, 14:21:31
    Author     : Gebruiker
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="fact.it.www.beans.Hotel"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%ArrayList<Hotel> hLijst = (ArrayList<Hotel>) request.getAttribute("hotelLijst");%>
<!DOCTYPE html>
<html>
    <head>
      <link rel="stylesheet" href="newstyle.css">
      <link href="https://fonts.googleapis.com/css?family=El+Messiri" rel="stylesheet">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Toon Hotels</title>
    </head>
    <body>
      <div class="container">
          <h1>Overzicht van hotels</h1>

        <table>
          <tr id="vet">
            <td>Hotelnaam</td>
            <td>Aantal sterren</td>
            <td>Skigebied</td>
          </tr>
          <% for (Hotel hot : hLijst){%>
            <tr>
              <td><a href="ManageServlet?details=<%=hot.getHotelnaam()%>"><%=hot.getHotelnaam()%></a></td>
              <td><%=hot.getAantalSterren()%></td>
              <td><%=hot.getSkigebied().getSkigebied()%></td>
            </tr>
        <%}%>
      </table>


        <p><a href="index.jsp">Terug naar index</a></p>
      </div>
    </body>
</html>
