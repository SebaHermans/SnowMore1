<%-- 
    Document   : resultaat
    Created on : 12-jun-2017, 10:07:44
    Author     : Sebastiaan
--%>
<%@page import="fact.it.www.beans.UitgebreideBeoordeling"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="newstyle.css">
        <link href="https://fonts.googleapis.com/css?family=El+Messiri" rel="stylesheet">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Resultaat beoordeling</title>
    </head>
    <body>
        <div class="container">
            <%UitgebreideBeoordeling uitgebreidebeoordeling = (UitgebreideBeoordeling)request.getAttribute("uitgebreidebeoordeling");%>
            
            <p><%=uitgebreidebeoordeling.toString() %></p>
            
            <p>
                <% if (uitgebreidebeoordeling.isGoed() == true){%>
                    <p>Dit is een goede beoordeling</p>
                <%} else{%>
                    <p>Dit is een slechte beoordeling</p>
                <%}%>
                
            </p>
            <p>
                <a href="index.jsp">Terug naar de beginpagina</a>
            </p>
            
            
        </div>

    </body>
</html>
