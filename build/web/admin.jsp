<%--
    Document   : admin
    Created on : 31-mei-2017, 10:26:17
    Author     : Sebastiaan
--%>

<%@page import="fact.it.www.beans.Aanbod"%>
<%@page import="java.util.ArrayList"%>
<%@page import="fact.it.www.beans.Hotel"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
      <link rel="stylesheet" href="newstyle.css">
      <link href="https://fonts.googleapis.com/css?family=El+Messiri" rel="stylesheet">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Admin</title>
    </head>
    <body>
      <div class="container">
          <h1>Aan welk hotel wil je een periode toevoegen?</h1>
        <%ArrayList<Aanbod> overzicht = (ArrayList<Aanbod>) request.getAttribute("aanbod");%>
        <table>
            <tr id="vet">
                <td>Hotelnaam</td>
                <td>Aantal sterren</td>
                <td>Skigebied</td>
                <td>Periode</td>
            </tr>
            <% for (Aanbod aan : overzicht){%>
            <tr>
                <td><%=aan.getHotel().getHotelnaam()%></td>
                <td><%=aan.getHotel().getAantalSterren()%></td>
                <td><%=aan.getHotel().getSkigebied().getSkigebied()%></td>
                <td><%=aan.getPeriode().getPeriode()%></td>
                <td><a href="AdminServlet?details=<%=aan.getHotel().getHotelnaam()%>">Voeg periode toe</a></td>
            </tr>
        <%}%>
        </table>



        <p><a href="index.jsp">Terug naar index</a></p>

      </div>
    </body>
</html>
