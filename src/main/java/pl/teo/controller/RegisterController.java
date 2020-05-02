package pl.teo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.teo.entity.User;
import pl.teo.repository.UserRepository;
import org.mindrot.jbcrypt.BCrypt;

import javax.validation.Valid;

@Controller
public class RegisterController {
    @Autowired
    public UserRepository userRepository;

    @RequestMapping (method = RequestMethod.GET, value = "register")
    public String registerForm(Model model){
        model.addAttribute("user", new User());
        return "register.jsp";
    }

    @RequestMapping (method = RequestMethod.POST, value = "register")
    public String registration (@Valid User user, BindingResult result, Model model){
        if(result.hasErrors()){
            return "register.jsp";
        }
        if(userRepository.findByUserNameIgnoreCase(user.getUserName()) != null){
            model.addAttribute("userNameFlag", "true");
            return "register.jsp";
        }
        if(userRepository.findByEmailIgnoreCase(user.getEmail()) != null){
            model.addAttribute("emailFlag", "true");
            return "register.jsp";
        }
        user.setPassword(BCrypt.hashpw(user.getPassword(), BCrypt.gensalt()));
        userRepository.save(user);

        return "registerOk.jsp";
    }
}
