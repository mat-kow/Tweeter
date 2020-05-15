package pl.teo.controller;

import org.owasp.html.HtmlPolicyBuilder;
import org.owasp.html.PolicyFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import pl.teo.entity.Comment;
import pl.teo.entity.Tweet;
import pl.teo.entity.User;
import pl.teo.repository.CommentRepository;
import pl.teo.repository.TweetRepository;
import pl.teo.repository.UserRepository;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class TweetController {
    @Autowired
    public TweetRepository tweetRepository;
    @Autowired
    public UserRepository userRepository;
    @Autowired
    public CommentRepository commentRepository;

    @RequestMapping(method = RequestMethod.POST, value = "addTweet")
    public String addTweet (@RequestParam String tweetContent, HttpSession session){
        if (session.getAttribute("loggedUserName") == null){
            return "redirect:login";
        }
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
        String safeTweetContent = policy.sanitize(tweetContent);
        Tweet tweet = new Tweet(user, safeTweetContent.trim());
        tweetRepository.save(tweet);
        return "redirect:home";
    }

    @RequestMapping("tweet/{id}")
    public String tweetInfo(@PathVariable long id, Model model){
        model.addAttribute("hrefParam", "../");
        Tweet tweet = tweetRepository.findById(id);
        if(tweet == null){
            return "redirect:../home";
        }
        model.addAttribute("tweet", tweet);
        List<Comment> commentList = commentRepository.findAllByTweetIdOrderByCreatedDesc(id);
        model.addAttribute("commentList", commentList);
        return "tweetInfo";
    }
}
