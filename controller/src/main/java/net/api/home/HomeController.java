package net.api.home;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


/**
 * Este controlador maneja las solicitudes HTTP relacionadas con la página de inicio.
 */
@Controller
@RequestMapping("/home")
public class HomeController {

    /**
     * <strong>@GetMapping</strong><br>
     * Muestra la página de inicio.
     *
     * @return El nombre de la plantilla de vista que se utilizará para mostrar la página de inicio.
     *         En este caso, es "/home".
     */
    @GetMapping("")
    public String mostrarPaginaInicio() {
        return "/home";
    }
}
