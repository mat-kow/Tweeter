<%--
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
    <div id="header"><%@ include file="fragments/header.jsp"%></div>
    <h1>Lorem ipsum</h1>
    <%
        String loggedUserName = (String) session.getAttribute("loggedUserName");
        if(loggedUserName != null){%>
    <h2>Witaj ponownie ${loggedUserName}</h2>
        <%}
    %>
</body>
</html>
