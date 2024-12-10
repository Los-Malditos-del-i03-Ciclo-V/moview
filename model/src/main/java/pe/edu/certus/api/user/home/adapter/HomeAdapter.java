package pe.edu.certus.api.user.home.adapter;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pe.edu.certus.api.user.home.port.ForHomePage;
import pe.edu.certus.api.utils.costants.UserEndpointsRoutes;
import pe.edu.certus.api.utils.costants.UserTemplateRoutes;

@Controller
@RequestMapping(UserEndpointsRoutes.HOME_ENDPOINT)
public class HomeAdapter implements ForHomePage {

    @Override
    @GetMapping
    public String displayHomePage(Model model) {
        return UserTemplateRoutes.HOME_PAGE;
    }
}
