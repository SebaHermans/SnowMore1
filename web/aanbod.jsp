<%--
    Document   : aanbod
    Created on : 5-mei-2017, 13:56:39
    Author     : Gebruiker
--%>
<%@page import="java.util.ArrayList"%>
<%@page import="fact.it.www.beans.Aanbod"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%ArrayList<Aanbod> overzicht = (ArrayList<Aanbod>) request.getAttribute("aanbod");%>
<!DOCTYPE html>
<html>
    <head>
      
      <link href="https://fonts.googleapis.com/css?family=El+Messiri" rel="stylesheet">
      <link rel="stylesheet" href="newstyle.css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Aanbod</title>
    </head>
    <body>
      <div class="container">
        <div class="center"><h1>Welke reizen kan ik maken? </h1>
        <form action="ManageServlet">
        <select name="dropdown">
            <option value="Kerstvakantie 1e week">Kerstvakantie 1e week</option>
            <option value="Kerstvakantie 2e week">Kerstvakantie 2e week</option>
            <option value="Krokusvakantie">Krokusvakantie</option>
            <option value="Paasvakantie 1e week">Paasvakantie 1e week</option>
            <option value="Paasvakantie 2e week">Paasvakantie 2e week</option>
        </select>
            <input type="submit" value="submit" name="dropdownaanbod"/>
        </form>
        
        <table>
          <tr id="vet">
            <td>Prijs</td>
            <td>Hotelnaam</td>
            <td>Periode</td>
          </tr>
            <% for (Aanbod aan : overzicht){%>
            <tr>
            <td><%=aan.getPrijs()%></td>
            <td><%=aan.getHotel().getHotelnaam()%></td>
            <td><%=aan.getPeriode().getPeriode()%></td>
            </tr>
        <%}%>
      </table>
      </div>


        <p><a href="index.jsp">Terug naar index</a></p>

      </div>
    </body> 
</html>
