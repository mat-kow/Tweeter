<%@ page import="pl.teo.entity.Comment" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    ArrayList<Tweet> tweetList = (ArrayList) request.getAttribute("tweetList");
    if (tweetList != null){
        Iterator<Tweet> it = tweetList.iterator();
        while(it.hasNext()){
            Tweet tweet = it.next();
            String time = new SimpleDateFormat("HH:mm dd.MM.yyyy").format(tweet.getCreated());%>
            <hr/><h4><a class="username" href="${hrefParam}user/<%out.print(tweet.getUser().getUserName());%>">         <%--printing tweet--%>
                <%out.print(tweet.getUser().getUserName());%></a> <span class="tweetTime"><%out.print(time);%></span></h4>
            <p><%out.print(tweet.getTweetContent());%></p>
            <a href="${hrefParam}tweet/<%out.print(tweet.getId());%>">Szczegóły</a><br/><%

        }
    }

%>
