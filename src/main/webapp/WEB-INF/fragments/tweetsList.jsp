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
            <a href="${hrefParam}tweet/<%out.print(tweet.getId());%>">Szczegóły</a><br/>
            <form method="post" action="${hrefParam}newComment">
                <input type="hidden" name="tweetId" value="<%out.print(tweet.getId());%>"/>
                <input type="hidden" name="url" value="<%out.print(request.getAttribute("javax.servlet.forward.request_uri"));%>">
                <textarea id="commentText" name="commentText" cols="50" rows="1" maxlength="40" minlength="0"></textarea>
                <input type="submit" value="Dodaj"/>
            </form>
<%
            ArrayList<Comment> commentList = (ArrayList) request.getAttribute("commentList");
            if (commentList != null){
                Iterator<Comment> itComment = commentList.iterator();
                while (itComment.hasNext()){                        //print comment for tweet
                    Comment comment = itComment.next();
                    if(comment.getTweet().getId() == tweet.getId()) {
                        //                    String commentTime = new SimpleDateFormat("HH:mm dd.MM.yyyy").format(tweet.getCreated());
                        %><div class="comment">
                            <%out.print(comment.getText());%><a class="username"
                                                                href="user/<%out.print(comment.getUser().getUserName());%>"><%out.print(comment.getUser().getUserName());%></a>
                        </div><%

                    }
                }

            }

        }
    }

%>
