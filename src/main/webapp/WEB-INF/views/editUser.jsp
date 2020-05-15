<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: teo
  Date: 10.05.2020
  Time: 21:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="resources/css/style.css">
    <meta charset="UTF-8">
    <title>Edycja danych użytkownika</title>
</head>
<body>
<div id="header">
    <%@ include file="../fragments/header.jsp" %>
</div><br/>
<c:if test="${changeSuccessFlag == true}">
    <span style="color:#ff0000">Hasło zostało zmienione</span><br/><br>
</c:if>

<div>
    <form method="post">
        Imię: <input type="text" name="firstName" value="${firstName}"><br/>
        Nazwisko: <input type="text" name="lastName" value="${lastName}"><br/>
        <input type="submit" value="Zmień">
    </form>
</div><br/>
<div>
    <form method="post" action="newPassword">
        <c:if test="${oldPassFlag == true}">
            <span style="color:#ff0000">Niepoprawne hasło</span><br/><br>
        </c:if>
        Stare hasło <input type="password" name="oldPass"><br/>
        <c:if test="${newPassFlag == true}">
            <span style="color:#ff0000">Hasło musi zawierać co najmniej 3 znaki</span><br/><br>
        </c:if>
        Nowe hasło: <input type="password" name="newPass"><br/>
        <input type="submit" value="Zmień hasło">
    </form>
</div>
</body>
</html>
