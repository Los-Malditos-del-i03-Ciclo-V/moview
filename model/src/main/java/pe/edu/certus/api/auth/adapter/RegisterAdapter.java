package pe.edu.certus.api.auth.adapter;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pe.edu.certus.api.auth.port.ForRegisterPage;
import pe.edu.certus.api.utils.costants.UserEndpointsRoutes;
import pe.edu.certus.api.utils.costants.UserTemplateRoutes;

@Controller
@RequestMapping(UserEndpointsRoutes.REGISTER_ENDPOINT)
public class RegisterAdapter implements ForRegisterPage {
    @Override
    @GetMapping
    public String displayRegisterPage() {
        return UserTemplateRoutes.REGISTER_PAGE;
    }
}
