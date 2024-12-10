package pe.edu.certus.api.user.ticket.adapter;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import pe.edu.certus.api.user.ticket.port.ForTicketPage;
import pe.edu.certus.api.utils.costants.UserEndpointsRoutes;
import pe.edu.certus.api.utils.costants.UserTemplateRoutes;

@Controller
@RequestMapping(UserEndpointsRoutes.TICKET_ENDPOINT)
public class TicketAdapter implements ForTicketPage {
    @Override
    public String displayTicketPage() {
        return UserTemplateRoutes.TICKET_PAGE;
    }
}
