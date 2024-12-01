package pe.edu.certus.api.home;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/home")
public class HomeController {
    private static final String HOME_PAGE = "home/home";

    @GetMapping
    public String displayHomePage(){
        return HOME_PAGE;
    }

}
