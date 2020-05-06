<%@ page import="java.util.ArrayList" %>
<%@ page import="pl.teo.entity.Tweet" %>
<%@ page import="java.util.Iterator" %>
<%@ page import="java.text.SimpleDateFormat" %><%--
  Created by IntelliJ IDEA.
  User: teo
  Date: 29.04.2020
  Time: 21:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="resources/css/style.css">
    <meta charset="UTF-8">
    <title>Tweeter - Strona Główna</title>
</head>
<body>
    <div id="header"><%@ include file="../fragments/header.jsp"%></div>
    <%
        String loggedUserName = (String) session.getAttribute("loggedUserName");
        if(loggedUserName != null){%>                           <%--    only for logged in users--%>
            <h2>Witaj ponownie ${loggedUserName}</h2>
        <%}
    %>
    <br/>
    <form method="post" action="addTweet">
        <textarea name="tweetContent" cols="80" rows="2" id="tweetText" minlength="3" maxlength="140"
                  placeholder="Czym chcesz podzielić się ze światem?"></textarea>
        <input type="submit" value="Wyślij"/>
    </form>
    <h2>Ostatnie tweety</h2>
    <%@ include file="../fragments/tweetsList.jsp"%>
</body>
</html>
