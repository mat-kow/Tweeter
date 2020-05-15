<%--<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>--%>
<%--<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<c:forEach var="tweet" items="${tweetList}">
    <fmt:formatDate pattern="HH:mm dd.MM.yyyy" value="${tweet.getCreated()}" type="BOTH" var="time" />
    <hr/><h4><a class="username" href="${hrefParam}user/${tweet.getUser().getUserName()}">         <%--printing tweet--%>
        ${tweet.getUser().getUserName()}</a> <span class="tweetTime">${time}</span></h4>
    <p>${tweet.getTweetContent()}</p>
    <a href="${hrefParam}tweet/${tweet.getId()}">Szczegóły</a><br/>
</c:forEach>
