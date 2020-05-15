<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<ul>
    <li><a href="${hrefParam}home">Strona główna</a></li>
    <c:if test="${empty loggedUserName}">
        <li><a href="${hrefParam}login">Zaloguj</a></li>
        <li><a href="${hrefParam}register">Rejestracja</a></li>
    </c:if>
    <c:if test="${!empty loggedUserName}">
        <li><a href="${hrefParam}messages">Wiadomości</a></li>
        <li><a href="${hrefParam}edit">Moje konto</a></li>
        <li><a href="${hrefParam}logout">Wyloguj</a></li>
    </c:if>
</ul><br>