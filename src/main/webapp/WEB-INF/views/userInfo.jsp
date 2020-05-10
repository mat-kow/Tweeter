<%@ page import="pl.teo.entity.Tweet" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Iterator" %>
<%@ page import="java.text.SimpleDateFormat" %><%--
  Created by IntelliJ IDEA.
  User: teo
  Date: 03.05.2020
  Time: 16:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="../resources/css/style.css">
    <meta charset="UTF-8">
    <title>Profil użytkownika ${loggedUserName}</title>
</head>
<body>
<div id="header">
    <%@ include file="../fragments/header.jsp" %>
</div>
<h2>Tweety użytkownika ${userName}  <a href="${hrefParam}newmessage/${userName}">Wyślij wiadomość</a></h2>
<%@ include file="../fragments/tweetsList.jsp"%>

</body>
</html>
