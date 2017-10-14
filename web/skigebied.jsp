<%--
    Document   : skigebied
    Created on : 31-mrt-2017, 13:55:21
    Author     : Sebastiaan
--%>

<%@page import="fact.it.www.beans.Skigebied"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%Skigebied skigebied = (Skigebied) request.getAttribute("skigebied");%>
<!DOCTYPE html>
<html>
    <head>
      <link rel="stylesheet" href="newstyle.css">
      <link href="https://fonts.googleapis.com/css?family=El+Messiri" rel="stylesheet">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Skigebied</title>
    </head>
    <body>
      <div class="container">
          <h1>Het gezochte skigebied</h1>

        <p>Skigebied: <%=skigebied.getSkigebied()%><p>
        <p><a href="index.jsp">Terug naar de home pagina</a></p>
      </div>
    </body>
</html>
