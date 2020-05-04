<%@ page import="pl.teo.entity.Tweet" %>
<%@ page import="java.text.SimpleDateFormat" %><%--
  Created by IntelliJ IDEA.
  User: teo
  Date: 04.05.2020
  Time: 21:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="../resources/css/style.css">
    <meta charset="UTF-8">
    <title>Tweeter</title>
</head>
<body>
<div id="header">
    <%@ include file="../fragments/header.jsp" %>
</div>
<h3>Informacje o Tweecie</h3>
<%
    Tweet tweet = (Tweet) request.getAttribute("tweet");
    String time = new SimpleDateFormat("HH:mm dd.MM.yyyy").format(tweet.getCreated());%>
    <h4><a class="username" href="${hrefParam}user/<%out.print(tweet.getUser().getUserName());%>">         <%--printing tweet--%>
        <%out.print(tweet.getUser().getUserName());%></a> <span class="tweetTime"><%out.print(time);%></span></h4>
    <p><%out.print(tweet.getTweetContent());%></p>

</body>
</html>
