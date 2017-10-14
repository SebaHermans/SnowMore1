<%--
    Document   : toegevoegdeReis
    Created on : 31-mei-2017, 15:22:20
    Author     : Sebastiaan
--%>
<%@page import="fact.it.www.beans.Aanbod"%>
<%@page import="java.util.ArrayList"%>
<%ArrayList<Aanbod> toegevoegdhotel = (ArrayList<Aanbod>) request.getAttribute("toegevoegd");%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
      <link rel="stylesheet" href="newstyle.css">
      <link href="https://fonts.googleapis.com/css?family=El+Messiri" rel="stylesheet">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Hotel Toegevoegd</title>
    </head>
    <body>
      <div class="container">
          <h1>Overzicht van alle toegevoegde reizen</h1>
        <table>
            <tr id="vet">
                <td>Hotelnaam</td>
                <td>Aantal sterren</td>
                <td>Skigebied</td>
                <td>Periode</td>
                <td>Prijs</td
            </tr>
            <% for (Aanbod aan : toegevoegdhotel){%>
            <tr>
                <td><%=aan.getHotel().getHotelnaam()%></td>
                <td><%=aan.getHotel().getAantalSterren()%></td>
                <td><%=aan.getHotel().getSkigebied().getSkigebied()%></td>
                <td><%=aan.getPeriode().getPeriode()%></td>
                <td><%=aan.getPrijs()%></td>
                <td><a href="AdminServlet?verwijderreis">verwijder reis</a></td>
            </tr>
            <%}%>
        </table>
        
        <form action="AdminServlet">
            <input type="submit" value ="Terug naar de de adminpagina" name="adminbutton">
        </form>
        

      </div>
    </body>
</html>
