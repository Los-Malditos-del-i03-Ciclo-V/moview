package net.api.auth;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/autenticacion")
public class LoginController {
    
    @GetMapping("/login")
    public String mostrarLogin() {
        return "login/login";
    }
}
