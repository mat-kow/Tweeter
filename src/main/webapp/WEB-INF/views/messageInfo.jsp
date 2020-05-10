<%@ page import="pl.teo.entity.Message" %><%--
  Created by IntelliJ IDEA.
  User: teo
  Date: 10.05.2020
  Time: 14:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="../resources/css/style.css">
    <meta charset="UTF-8">
    <title>Szczegóły wiadomości</title>
</head>
<body>
<div id="header">
    <%@ include file="../fragments/header.jsp" %>
</div>
<div>
    <h3>Od: <a class="username" href="${hrefParam}user/${message.getSender().getUserName()}">${message.getSender().getUserName()}</a></h3>
    <h3>Do: <a class="username" href="${hrefParam}user/${message.getReceiver().getUserName()}">${message.getReceiver().getUserName()}</a></h3>
    <h3>Treść:</h3>
    <p>${message.getText()}</p>

</div>
</body>
</html>
