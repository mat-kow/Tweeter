package pl.teo.controller;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import pl.teo.entity.User;
import pl.teo.repository.UserRepository;

import javax.servlet.http.HttpSession;

@Controller
public class EditUserController {
    @Autowired
    public UserRepository userRepository;

    @RequestMapping(value = "edit", method = RequestMethod.GET)
    public String editUserForm(HttpSession session, Model model){
        User user = userRepository.findByUserNameIgnoreCase((String)session.getAttribute("loggedUserName"));
        if(user == null){
            return "redirect:login";
        }
        model.addAttribute("firstName", user.getFirstName());
        model.addAttribute("lastName", user.getLastName());
        model.addAttribute("user", new User());
        return "editUser.jsp";
    }
    @RequestMapping(value = "edit", method = RequestMethod.POST)
    public String editUser(@RequestParam String firstName, @RequestParam String lastName, HttpSession session){
        User user = userRepository.findByUserNameIgnoreCase((String)session.getAttribute("loggedUserName"));
        if(user == null){
            return "redirect:login";
        }
        user.setFirstName(firstName);
        user.setLastName(lastName);
        userRepository.save(user);
        return "redirect:edit";
    }

    @RequestMapping (value = "newPassword", method = RequestMethod.POST)
    public String changePassword (@RequestParam String newPass, @RequestParam String oldPass, HttpSession session, Model model){
        User user = userRepository.findByUserNameIgnoreCase((String)session.getAttribute("loggedUserName"));
        if(user == null){
            return "redirect:login";
        }
        if(!BCrypt.checkpw(oldPass, user.getPassword())){   // wrong old password
            model.addAttribute("oldPassFlag", "true");
        } else if (newPass.length() < 3){ // new pass too short
            model.addAttribute("newPassFlag", "true");
        }else{
            user.setPassword(BCrypt.hashpw(newPass, BCrypt.gensalt()));
            userRepository.save(user);
            model.addAttribute("changeSuccessFlag", "true");
        }
        return "editUser.jsp";
    }
}
