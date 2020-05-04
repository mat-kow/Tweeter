<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: teo
  Date: 02.05.2020
  Time: 15:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="resources/css/style.css">
    <meta charset="UTF-8">
    <title>Rejestracja</title>
</head>
<body>
<div id="header"><%@ include file="../fragments/header.jsp"%></div>
<h3>Zarejestruj się</h3>
<div id="form">
    <form:form method="post" modelAttribute="user">
        Nazwa użytkownika:<form:input path="userName" type="text"/>
        <form:errors path="userName" style="color:red"/>
        <%String userNameFlag = (String)request.getAttribute("userNameFlag");
            if(userNameFlag == "true"){
                out.print("<span style=\"color:red\">Wprowadzona nazwa użytkownika jest już zajęta</span>");
            }%><br/><br>
        Hasło: <form:input path="password" type="password"/><form:errors path="password" style="color:red"/><br><br>
        Adres e-mail: <form:input path="email" type="email"/>
        <form:errors path="email" style="color:red"/>
        <%String emailFlag = (String)request.getAttribute("emailFlag");
            if(emailFlag == "true"){
                out.print("<span style=\"color:red\">Wprowadzony adres e-mail jest już używany.</span>");
            }%><br/><br>
        Imię: <form:input path="firstName"/><form:errors path="firstName" style="color:red"/><br/><br>
        Nazwisko: <form:input path="lastName"/><form:errors path="lastName" style="color:red"/><br/><br>
        <input type="submit" value="Załóż konto">
    </form:form>
</div>

</body>
</html>
