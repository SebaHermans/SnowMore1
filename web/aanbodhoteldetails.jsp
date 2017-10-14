<%-- 
    Document   : aanbodhoteldetails
    Created on : 12-jun-2017, 8:56:35
    Author     : Sebastiaan
--%>

<%@page import="fact.it.www.beans.Hotel"%>
<%@page import="fact.it.www.beans.Aanbod"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
    <head>
        <link rel="stylesheet" href="newstyle.css">
        <link href="https://fonts.googleapis.com/css?family=El+Messiri" rel="stylesheet">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Aanbod hoteldetails</title>
        <%ArrayList<Aanbod> toegevoegdhotel = (ArrayList<Aanbod>) request.getAttribute("toegevoegd");%>
        
    </head>
    <body>
        <div class="container">
            <% if (toegevoegdhotel != null){%>
            <table>
            <tr id="vet">
                <td>Hotelnaam</td>
                <td>Periode</td>
                <td>Prijs</td
            </tr>
            <% for (Aanbod aan : toegevoegdhotel){%>
            <tr>
                <td><%=aan.getHotel().getHotelnaam()%></td>
                <td><%=aan.getPeriode().getPeriode()%></td>
                <td><%=aan.getPrijs()%></td>
            </tr>
            <%}%>
            </table>
            <%} else{%>
            <h1>Geen aanbod voor dit hotel! </h1>
            <%}%>
        </div>
    </body>
</html>
