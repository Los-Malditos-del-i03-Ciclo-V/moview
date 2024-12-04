package pe.edu.certus.api.auth;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/login")
public class LoginController {
    private static final String LOGIN_PAGE = "auth/login/login"; //

    @GetMapping("")
    public String displayLoginPage() {
        return LOGIN_PAGE;
    }
}
