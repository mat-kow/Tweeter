package pl.teo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import pl.teo.entity.Tweet;
import pl.teo.entity.User;
import pl.teo.repository.TweetRepository;
import pl.teo.repository.UserRepository;

import javax.servlet.http.HttpSession;

@Controller
public class TweetController {
    @Autowired
    public TweetRepository tweetRepository;
    @Autowired
    public UserRepository userRepository;

    @RequestMapping(method = RequestMethod.POST, value = "addTweet")
    public String addTweet (@RequestParam String tweetContent, HttpSession session){
        User user = userRepository.findByUserNameIgnoreCase((String)session.getAttribute("loggedUserName"));
        if (user != null){
            Tweet tweet = new Tweet(user, tweetContent);
            tweetRepository.save(tweet);
        }
        return "redirect:home";
    }
}