<%--
  Created by IntelliJ IDEA.
  User: cathy
  Date: 07/03/2019
  Time: 12:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.*" %>
<%@ page import="domain.db.WoordenLijst" %>
<%@ page import="domain.HintWoord" %>


<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Woordenlijst</title>
    <link href="css/html5reset-1.6.1.css" rel="stylesheet">
    <link href="css/style.css" rel="stylesheet">
</head>
<body>
<header>
    <figure><h1>Beheerapplicatie woordenlijst</h1></figure>

    <nav>
        <ul>
            <li><a href="index.jsp">Home</a></li>
            <li><a href="formulier.jsp">Nieuw woord</a></li>
            <li><a class="active" href="Servlet">Toon woordenlijst</a></li>
        </ul>
    </nav>
</header>
<main>
    <h2>Woordenlijst</h2>
    <div  id="table">
        <table>
            <tr>
                <th>Woorden</th>
                <th>Niveau</th>

            </tr>
            <%

                List<HintWoord> woorden = (List<HintWoord>) request.getAttribute("woorden");

                for (HintWoord w : woorden){ %>
            <tr>
                <td> <%= w.getWoord()%></td>
                <td><%= w.getNiveau()%></td>
            </tr>

            <%
                }
            %>
        </table>


    </div>
</main>
<footer><address>Project 1 - woordenlijst - groep 24</address></footer>
</body>
</html>
