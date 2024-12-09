package pe.edu.certus.api.order;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/payment")
public class OrdenController {
    private static final String ORDEN_PAGE = "payment/pasarela_pago";

    @GetMapping
    public String displayOrdenPage(){
        return ORDEN_PAGE;
    }

}