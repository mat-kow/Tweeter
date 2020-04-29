package pl.teo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
    @RequestMapping(value = {"", "home", "index"})
    public String homepage(){
        return "home.jsp";
    }
}
