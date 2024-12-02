package pe.edu.certus.api.order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import pe.edu.certus.adapter.orden.OrdenMethodsAdapter;
import pe.edu.certus.model.order.dto.OrderDTO;
import pe.edu.certus.persistence.order.adapters.OrderConvertersAdapter;
import pe.edu.certus.persistence.order.dao.OrderDAO;

@Controller
@RequestMapping("/orders")
public class OrdenController {

    private final String ORDER_PAGE = "orden/orden";

    @Autowired
    private OrdenMethodsAdapter ordenMethodsAdapter;

    @Autowired
    private OrderConvertersAdapter orderConvertersAdapter;

    @GetMapping
    public String showOrderPage() {
        return ORDER_PAGE;
    }


    @PostMapping("/save")
    public String saveOrderPage(@ModelAttribute ("order") OrderDAO orderDAO, RedirectAttributes redirectAttributes) {

        OrderDTO orderDTO = orderConvertersAdapter.convertToDto(orderDAO);
        ordenMethodsAdapter.updateEntity(orderDTO);
        
        redirectAttributes.addFlashAttribute("message", "Orden guardada con éxito!");
        return "redirect:/orders";

    }

    @DeleteMapping("/delete/{id}")
    public String deleteOrder(@PathVariable(name = "id") Integer id){
        ordenMethodsAdapter.deleteEntityById(id);
        return "redirect:/orders";
    }

}
