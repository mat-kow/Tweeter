<%@ page import="java.util.ArrayList" %>
<%@ page import="pl.teo.entity.Message" %>
<%@ page import="java.util.Iterator" %>
<%@ page import="java.text.SimpleDateFormat" %><%--
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
    <%
        ArrayList<Message> inbox = (ArrayList) request.getAttribute("inbox");
        if(inbox.isEmpty()){%>
    <p>Brak wiadomości</p>
    <%}
    else{%>
    <table>
        <tr>
            <th>Od:</th>
            <th>Odebrano:</th>
            <th>Treść</th>
        </tr>
        <%for (Message message : inbox) {
            String text = message.getText();
            text = text.substring(0, Math.min(text.length(), 30));;
            String time = new SimpleDateFormat("HH:mm dd.MM.yyyy").format(message.getSent());%>
        <tr <%
                    if (message.isNew()) {
                        %>class="newMessage"<%
            }%>>
            <td><a class="message" href="message/<%out.print(message.getId());%>"><%out.print(message.getSender().getUserName());%></a></td>
            <td><a class="message" href="message/<%out.print(message.getId());%>"><%out.print(time);%></a></td>
            <td><a class="message" href="message/<%out.print(message.getId());%>"><%out.print(text);%></a></td>
        </tr>
        <%}%>
    </table>
    <%}
    %>
</div>
<div id="outbox">
    <h2>Wysłane</h2>
    <%
        ArrayList<Message> outbox = (ArrayList) request.getAttribute("outbox");
        if(outbox.isEmpty()){%>
    <p>Brak wiadomości</p>
    <%}
    else{%>
    <table>
        <tr>
            <th>Do:</th>
            <th>Wysłano:</th>
            <th>Treść</th>
        </tr>
        <%for (Message message : outbox) {
            String text = message.getText();
            text = text.substring(0, Math.min(text.length(), 30));;
            String time = new SimpleDateFormat("HH:mm dd.MM.yyyy").format(message.getSent());%>
        <tr>
            <td><a class="message" href="message/<%out.print(message.getId());%>"><%out.print(message.getReceiver().getUserName());%></a></td>
            <td><a class="message" href="message/<%out.print(message.getId());%>"><%out.print(time);%></a></td>
            <td><a class="message" href="message/<%out.print(message.getId());%>"><%out.print(text);%></a></td>
        </tr>
        <%}%>
    </table>
    <%}
    %>
</div>
</body>
</html>
