package pl.teo.controller;

import org.owasp.html.HtmlPolicyBuilder;
import org.owasp.html.PolicyFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.teo.entity.Message;
import pl.teo.entity.User;
import pl.teo.repository.MessageRepository;
import pl.teo.repository.UserRepository;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class MessageController {
    @Autowired
    public MessageRepository messageRepository;
    @Autowired
    public UserRepository userRepository;

    @RequestMapping("messages")
    public String getMessages(Model model, HttpSession session){
        String loggedUserName = (String) session.getAttribute("loggedUserName");
        User user = userRepository.findByUserNameIgnoreCase(loggedUserName);
        if(user == null || loggedUserName.equals("")){
            return "redirect:login";
        }
        List<Message> inbox = messageRepository.findAllByReceiverIdOrderBySentDesc(user.getId());
        model.addAttribute("inbox", inbox);
        List<Message> outbox = messageRepository.findAllBySenderIdOrderBySentDesc(user.getId());
        model.addAttribute("outbox", outbox);
        return "messages.jsp";
    }

    @RequestMapping("message/{id}")
    public String getSingleMessage(@PathVariable long id, Model model, HttpSession session){
        model.addAttribute("hrefParam", "../");
        User user = userRepository.findByUserNameIgnoreCase((String)session.getAttribute("loggedUserName"));
        if(user == null){
            return "redirect:../login";
        }
        Message message = messageRepository.findById(id);
        if(message == null){
            return "redirect:../home";
        }
        if(user.getId() != message.getSender().getId() && user.getId() != message.getReceiver().getId()){
            return "redirect:../home";
        }
        if(user.getId() != message.getReceiver().getId() || message.isNew()){
            message.setNew(false);
            messageRepository.save(message);
        }
        model.addAttribute("message", message);
        return "messageInfo";
    }

    @RequestMapping(value = "newmessage/{receiverName}", method = RequestMethod.GET)
    private String newMessage(@PathVariable String receiverName, Model model, HttpSession session){
        User sender = userRepository.findByUserNameIgnoreCase((String)session.getAttribute("loggedUserName"));
        if(sender == null){
            return "redirect:../login";
        }
        User receiver = userRepository.findByUserNameIgnoreCase(receiverName);
        if(receiver == null){
            return "redirect:../home";
        }
        if (receiver.getId() == sender.getId()){ // try to send message to himself
            return "redirect:../messages";
        }
        model.addAttribute("receiverName", receiverName);
        return "newMessage";
    }
    @RequestMapping(value = "newmessage/{receiverName}", method = RequestMethod.POST)
    private String sendMessage(@PathVariable String receiverName, HttpSession session, @RequestParam String messageText){
        User sender = userRepository.findByUserNameIgnoreCase((String)session.getAttribute("loggedUserName"));
        if(sender == null){
            return "redirect:../login";
        }
        User receiver = userRepository.findByUserNameIgnoreCase(receiverName);
        if(receiver == null){
            return "redirect:../home";
        }
        if (receiver.getId() == sender.getId()){ // try to send message to himself
            return "redirect:../messages";
        }
        PolicyFactory policy = new HtmlPolicyBuilder()
                .allowElements("a")
                .allowUrlProtocols("https")
                .allowAttributes("href").onElements("a")
                .requireRelNofollowOnLinks()
                .toFactory();
        String safeMessageText = policy.sanitize(messageText);
        Message message = new Message(safeMessageText, receiver, sender);
        messageRepository.save(message);
        return "redirect:../messages";
    }

}
