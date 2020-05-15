<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>
<%--
  Created by IntelliJ IDEA.
  User: teo
  Date: 10.05.2020
  Time: 14:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="resources/css/style.css">
    <meta charset="UTF-8">
    <title>Wiadomości</title>
</head>
<body>
<div id="header">
    <%@ include file="../fragments/header.jsp" %>
</div>
<div id="inbox">
    <h2>Odebrane</h2>
    <c:if test="${empty inbox}">
        <p>Brak wiadomości</p>
    </c:if>
    <c:if test="${!empty inbox}">
        <table>
            <tr>
                <th>Od:</th>
                <th>Odebrano:</th>
                <th>Treść</th>
            </tr>
            <c:forEach var="message" items="${inbox}">
                <c:set var="text" value="${fn:substring(message.getText(),0,30)}"/>
                <fmt:formatDate pattern="HH:mm dd.MM.yyyy" value="${message.getSent()}" type="BOTH" var="time" />
                <tr
                        <c:if test="${message.isNew()}">
                            class="newMessage"
                        </c:if>>
                    <td><a class="message" href="message/${message.getId()}">${message.getSender().getUserName()}</a></td>
                    <td><a class="message" href="message/${message.getId()}">${time}</a></td>
                    <td><a class="message" href="message/${message.getId()}">${text}</a></td>
                </tr>
            </c:forEach>
        </table>
    </c:if>
</div>
<div id="outbox">
    <h2>Wysłane</h2>
    <c:if test="${empty outbox}">
        <p>Brak wiadomości</p>
    </c:if>
    <c:if test="${!empty outbox}">
        <table>
            <tr>
                <th>Do:</th>
                <th>Wysłano:</th>
                <th>Treść</th>
            </tr>
            <c:forEach var="message" items="${outbox}">
                <c:set var="text" value="${fn:substring(message.getText(),0,30)}"/>
                <fmt:formatDate pattern="HH:mm dd.MM.yyyy" value="${message.getSent()}" type="BOTH" var="time" />
                <tr>
                    <td><a class="message" href="message/${message.getId()}">${message.getSender().getUserName()}</a></td>
                    <td><a class="message" href="message/${message.getId()}">${time}</a></td>
                    <td><a class="message" href="message/${message.getId()}">${text}</a></td>
                </tr>
            </c:forEach>
        </table>
    </c:if>
</div>
</body>
</html>
