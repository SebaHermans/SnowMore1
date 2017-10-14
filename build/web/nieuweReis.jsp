<%--
    Document   : nieuweReis.jsp
    Created on : 31-mei-2017, 11:47:56
    Author     : Sebastiaan
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
          <title>Nieuwe Reis</title>
        </head>
        <body>
          <div class="container">
            <h1>Toevoegen periode</h1>
            <p>
              Hotelnaam:
              <%=hotel.getHotelnaam()%>
            </p>

            <form action="AdminServlet">
              <input type="hidden" name="hotelid" value="<%=hotel.getId()%>"/>
              <p>
                <label for="periode">
                  Periode:
                </label>
                <select name="dropdown">
                  <option value="1">Kerstvakantie 1e week</option>
                  <option value="2">Kerstvakantie 2e week</option>
                  <option value="5">Krokusvakantie</option>
                  <option value="3">Paasvakantie 1e week</option>
                  <option value="4">Paasvakantie 2e week</option>
                </select>
              </p>
              <p>
                <label for="prijs">Kostprijs:
                </label>
                <input type="text" name="prijs"/>
              </p>
              <p>
                <input type="submit" name="voegtoe" value="Voeg periode toe"/>
                <input type="submit" name="annuleren" value="annuleren"/>
              </p>

            </form>

          </div>
        </body>
      </html>
