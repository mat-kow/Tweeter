<%--
  Created by IntelliJ IDEA.
  User: teo
  Date: 10.05.2020
  Time: 14:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="../resources/css/style.css">
    <meta charset="UTF-8">
    <title>Napisz wiadomość</title>
</head>
<body>
<div id="header">
    <%@ include file="../fragments/header.jsp" %>
</div>
<div>
    <h3>Wiadomość do: ${receiverName}</h3>
    <form method="post">
        <textarea name="messageText" rows="20" cols="50" id="messageText" minlength="3" maxlength="500"></textarea>
        <input type="submit" value="Wyślij">
    </form>
</div>
</body>
</html>
