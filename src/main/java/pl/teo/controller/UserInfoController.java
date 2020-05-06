package pl.teo.controller;

import org.checkerframework.checker.units.qual.A;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.teo.entity.Comment;
import pl.teo.entity.Tweet;
import pl.teo.entity.User;
import pl.teo.repository.CommentRepository;
import pl.teo.repository.TweetRepository;
import pl.teo.repository.UserRepository;

import java.util.List;

@Controller
public class UserInfoController {
    @Autowired
    public UserRepository userRepository;
    @Autowired
    public TweetRepository tweetRepository;
    @Autowired
    public CommentRepository commentRepository;
    @RequestMapping("user/{userName}")
    public String userInfo(@PathVariable String userName, Model model){
        model.addAttribute("hrefParam", "../");
        User user = userRepository.findByUserNameIgnoreCase(userName);
        if (user == null){
            return "redirect:home";
        }
        List<Tweet> tweets = tweetRepository.findAllByUserIdOrderByCreatedDesc(user.getId());
        model.addAttribute("tweetList",tweets);
        List<Comment> commentList = commentRepository.findAllByOrderByCreatedAsc();
        model.addAttribute("commentList", commentList);
        return "userInfo";
    }

}
