package pl.teo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.support.SessionStatus;

@Controller
public class LogoutController {
    @RequestMapping("logout")
    public String logout (SessionStatus status){
        status.setComplete();
        System.out.println("logout");
        return "redirect:home";
    }
}
