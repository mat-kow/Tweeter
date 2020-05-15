<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
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
<div id="singleTweet">
    <fmt:formatDate pattern="HH:mm dd.MM.yyyy" value="${tweet.getCreated()}" type="BOTH" var="time" />
    <hr/><h4><a class="username" href="${hrefParam}user/${tweet.getUser().getUserName()}">         <%--printing tweet--%>
    ${tweet.getUser().getUserName()}</a> <span class="tweetTime">${time}</span></h4>
    <p>${tweet.getTweetContent()}</p>
</div>
<div>
    <form method="post" action="${hrefParam}newComment">
        <input type="hidden" name="tweetId" value="${tweet.getId()}"/>
        <input type="hidden" name="url" value="<%out.print(request.getAttribute("javax.servlet.forward.request_uri"));%>">
        <textarea id="commentText" name="commentText" cols="50" rows="1" maxlength="40" minlength="0"></textarea>
        <input type="submit" value="Dodaj"/>
    </form>
</div>
<div>
    <c:forEach var="comment" items="${commentList}">
        ${comment.getText()} <a class="username" href="user/${comment.getUser().getUserName()}">${comment.getUser().getUserName()}</a><br/>
    </c:forEach>
</div>
</body>
</html>
