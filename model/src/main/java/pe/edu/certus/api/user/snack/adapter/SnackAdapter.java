package pe.edu.certus.api.user.snack.adapter;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pe.edu.certus.api.user.snack.port.ForSnackPage;
import pe.edu.certus.api.utils.costants.UserEndpointsRoutes;
import pe.edu.certus.api.utils.costants.UserTemplateRoutes;

@Controller
@RequestMapping(UserEndpointsRoutes.SNACK_ENDPOINT)
public class SnackAdapter implements ForSnackPage {
    @GetMapping()
    @Override
    public String displaySnackPage() {
        return UserTemplateRoutes.SNACK_PAGE;
    }
}
