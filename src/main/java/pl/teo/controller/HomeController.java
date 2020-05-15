package pl.teo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.teo.repository.TweetRepository;

import java.util.List;

@Controller
public class HomeController {
    @Autowired
    public TweetRepository tweetRepository;

    @RequestMapping(value = {"", "home", "index"})
    public String homepage(Model model){
        List tweetList = tweetRepository.findAllByOrderByCreatedDesc();
        model.addAttribute("tweetList", tweetList);
        return "home.jsp";
    }
}
