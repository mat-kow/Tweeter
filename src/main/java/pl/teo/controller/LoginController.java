package pl.teo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import pl.teo.entity.User;
import pl.teo.repository.UserRepository;
import org.mindrot.jbcrypt.BCrypt;

@Controller
@SessionAttributes("loggedUserName")
public class LoginController {
    @Autowired
    public UserRepository userRepository;

    @RequestMapping(method = RequestMethod.GET, value = "login")
    public String loginForm() {
        return "login.jsp";
    }

    @RequestMapping(method = RequestMethod.POST, value = "login")
    public String login(@RequestParam String userName, @RequestParam String password, Model model) {
        if (userName == null || userName.equals("")){
            model.addAttribute("errorFlag", "true");
            return "login.jsp";
        }
        User user = userRepository.findByUserNameIgnoreCase(userName);
        if (user == null){
            model.addAttribute("errorFlag", "true");
            return "login.jsp";
        }
        if(BCrypt.checkpw(password, user.getPassword())){
            model.addAttribute("loggedUserName", user.getUserName());
            return "loginOk.jsp";
        }
        model.addAttribute("errorFlag", "true");
        return "login.jsp";
    }

    @RequestMapping("logout")
    public String logout (SessionStatus status){
        status.setComplete();
        System.out.println("logout");
        return "redirect:home";
    }


}