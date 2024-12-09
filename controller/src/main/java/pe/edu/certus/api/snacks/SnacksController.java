package pe.edu.certus.api.snacks;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/snacks")
public class SnacksController {
    private static final String SNACKS_PAGE = "snacks/snack";

    @GetMapping
    public String displaySnacksPage(){
        return SNACKS_PAGE;
    }

}