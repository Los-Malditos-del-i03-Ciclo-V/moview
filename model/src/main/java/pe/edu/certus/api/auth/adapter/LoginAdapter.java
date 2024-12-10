package pe.edu.certus.api.auth.adapter;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pe.edu.certus.api.auth.port.ForLoginPage;
import pe.edu.certus.api.utils.costants.UserEndpointsRoutes;
import pe.edu.certus.api.utils.costants.UserTemplateRoutes;

@Controller
@RequestMapping(UserEndpointsRoutes.LOGIN_ENDPOINT)
public class LoginAdapter implements ForLoginPage {

    @Override
    @GetMapping
    public String displayLoginPage() {
        return UserTemplateRoutes.LOGIN_PAGE;
    }
}
