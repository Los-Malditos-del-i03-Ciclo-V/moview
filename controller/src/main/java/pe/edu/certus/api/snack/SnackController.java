package pe.edu.certus.api.snack;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/snacks")
public class SnackController {

    private final String SNACK_PAGE = "snack/snacks";

    @GetMapping()
    public String displaySnackPage(){
        return SNACK_PAGE;
    }

}
