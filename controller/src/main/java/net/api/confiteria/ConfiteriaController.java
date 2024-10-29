    package net.api.confiteria;

    import org.springframework.stereotype.Controller;
    import org.springframework.web.bind.annotation.GetMapping;
    import org.springframework.web.bind.annotation.RequestMapping;


    @Controller
    @RequestMapping("/confiteria")
    public class ConfiteriaController {

        @GetMapping
        public String mostrarConfiteria() {
            return "confiteria/confiteria";
        }

        @GetMapping("/carrito")
        public String mostrarCarrito() {
            return "confiteria/cart";
        }

    }
