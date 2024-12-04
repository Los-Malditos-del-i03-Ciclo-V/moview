package pe.edu.certus.api.auth;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/register")
public class RegisterController {
    private static final String REGISTER_PAGE = "auth/register/register";

    @GetMapping("")
    public String displaRegisterPage() {
        return REGISTER_PAGE;
    }
}
