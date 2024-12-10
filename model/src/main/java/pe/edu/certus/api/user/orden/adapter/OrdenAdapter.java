package pe.edu.certus.api.user.orden.adapter;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pe.edu.certus.api.user.orden.port.ForOrdenPage;
import pe.edu.certus.api.utils.costants.UserEndpointsRoutes;
import pe.edu.certus.api.utils.costants.UserTemplateRoutes;

@Controller
@RequestMapping(UserEndpointsRoutes.ORDER_ENDPOINT)
public class OrdenAdapter implements ForOrdenPage {

    @Override
    @GetMapping()
    public String displayOrdenPage() {
        return UserTemplateRoutes.ORDER_PAGE;
    }
}
