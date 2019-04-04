<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.*" %>

<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Woord toevoegen</title>
    <link href="css/html5reset-1.6.1.css" rel="stylesheet">
    <link href="css/style.css" rel="stylesheet">
</head>
<body>
<header>
    <figure><h1>Beheerapplicatie woordenlijst</h1></figure>
    <nav>
        <ul>
            <li><a href="index.jsp">Home</a></li>
            <li><a class="active" href="formulier.jsp">Nieuw woord</a></li>
            <li><a href="Servlet">Toon woordenlijst</a></li>
        </ul>
    </nav>
</header>
<main>
    <h2>Voeg woorden toe</h2>
    <form method="POST" action="Servlet">
        <p>
            <label for="woord">Woord*:</label>
            <input type="text" name="woord" id="woord" required autofocus>
        </p>
        <p><label for="niveau">Niveau:</label>
            <select id="niveau" name="niveau">
                <option value="not specified" selected="selected"> - Not Specified - </option>
                <option value="beginner">Beginner</option>
                <option value="expert">Expert</option>
            </select>
        </p>
        <p><input type="submit" value="Submit" id="submit"></p>
    </form>
    <p>*required to fill in</p>
    <p><a href="overzicht.jsp">Terug naar woordenlijst</a></p>
</main>
<footer><address>Project 1 - woordenlijst - groep 24</address></footer>
</body>
</html>