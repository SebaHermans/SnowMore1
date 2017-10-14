<%--
    Document   : zoekuitgebreid
    Created on : 30-mei-2017, 19:28:36
    Author     : Sebastiaan
--%>

<%@page import="fact.it.www.beans.Aanbod"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%ArrayList<Aanbod> prijs = (ArrayList<Aanbod>) request.getAttribute("zoekprijs");%>
<!DOCTYPE html>
<html>
    <head>
      <link rel="stylesheet" href="newstyle.css">
      <link href="https://fonts.googleapis.com/css?family=El+Messiri" rel="stylesheet">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Gezochte Prijs</title>
    </head>
    <body>
      <div class="container">
          <h1>Hotel per prijs gesorteerd</h1>
        <table>
          <tr id="vet">
            <td>Hotelnaam</td>
            <td>Prijs</td>
            <td>Skigebied</td>
            <td>Periode</td>
          </tr>
            <% for (Aanbod gezochteprijs: prijs){%>
                <tr>
                    <td><%=gezochteprijs.getHotel().getHotelnaam()%></td>
                    <td><%=gezochteprijs.getPrijs()%></td>
                    <td><%=gezochteprijs.getHotel().getSkigebied().getSkigebied()%></td>
                    <td><%=gezochteprijs.getPeriode().getPeriode()%></td>
                </tr>
            <%}%>
        </table>
        <p><a href="index.jsp">Terug naar index</a></p>
      </div>
    </body>
</html>
