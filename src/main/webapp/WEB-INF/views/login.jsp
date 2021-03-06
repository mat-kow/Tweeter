<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: teo
  Date: 01.05.2020
  Time: 22:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="resources/css/style.css">
    <meta charset="UTF-8">
    <title>Zaloguj się</title>
</head>
<body>
    <div id="header"><%@ include file="../fragments/header.jsp"%></div>
    <h3>Zaloguj się</h3>
    <div id="form">
        <form method="post">
            <c:if test="${errorFlag == true}">
                <span style="color:#ff0000">Niepoprawny login lub hasło</span><br/><br>
            </c:if>
            Nazwa użytkownika:<input type="text" name="userName"><br/><br/>
            Hasło: <input type="password" name="password"><br/><br/>
            <input type="submit" value="Zaloguj">
        </form>
    </div>

</body>
</html>
