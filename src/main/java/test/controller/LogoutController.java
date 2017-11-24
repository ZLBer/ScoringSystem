package test.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.servlet.http.HttpSession;

/**
 * Created by libin on 2017/9/24.
 */
@Controller
public class LogoutController {
    @RequestMapping("/logout")
    public String login(HttpSession session){
     session.removeAttribute("user");
        session.removeAttribute("templateDir");
        return "login";
    }
}
