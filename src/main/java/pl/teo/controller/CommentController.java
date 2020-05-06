package pl.teo.controller;

import org.owasp.html.HtmlPolicyBuilder;
import org.owasp.html.PolicyFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import pl.teo.entity.Comment;
import pl.teo.entity.User;
import pl.teo.repository.CommentRepository;
import pl.teo.repository.TweetRepository;
import pl.teo.repository.UserRepository;

import javax.servlet.http.HttpSession;

@Controller
public class CommentController {
    @Autowired
    public CommentRepository commentRepository;
    @Autowired
    public UserRepository userRepository;
    @Autowired
    public TweetRepository tweetRepository;

    @RequestMapping(value = "newComment", method = RequestMethod.POST)
    public String newComment(@RequestParam long tweetId, @RequestParam String commentText, HttpSession session,
                             @RequestParam String url){
        User user = userRepository.findByUserNameIgnoreCase((String)session.getAttribute("loggedUserName"));
        if(user == null){
            return "redirect:login";
        }
        PolicyFactory policy = new HtmlPolicyBuilder()
                .allowElements("a")
                .allowUrlProtocols("https")
                .allowAttributes("href").onElements("a")
                .requireRelNofollowOnLinks()
                .toFactory();
        String safeCommentText = policy.sanitize(commentText);

        Comment comment = new Comment(tweetRepository.findById(tweetId), user, safeCommentText);
        commentRepository.save(comment);
        url = url.replace("/Tweeter/","");
        return "redirect:" + url;
    }
}
