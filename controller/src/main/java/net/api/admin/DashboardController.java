package net.api.pelicula;

import net.business.pelicula.PeliculaService;
import net.entity.pelicula.Pelicula;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Esta clase actúa como un controlador en el framework Spring MVC, encargado de manejar
 * las solicitudes HTTP relacionadas con las películas. Es decir, se encarga de recibir peticiones
 * del cliente (por ejemplo, desde un navegador web), procesarlas y generar respuestas.
 *  <br><br>
 * <strong>@Controller</strong><br>
 *  Indica que esta clase es un componente de Spring y que se encargará de manejar las solicitudes
 *  HTTP. Spring escanea las clases anotadas con `@Controller` para encontrar los métodos que
 *  manejarán las diferentes peticiones (GET, POST, PUT, DELETE, etc.).
 */
@Controller
@RequestMapping("/dashboard")
public class DashboardController {

    /**
     * <strong>@Autowired</strong>
     * <br>
     * Inyecta una instancia de la clase PeliculaService en este bean.
     *
     * Spring Framework utiliza esta anotación para poder hacer
     * la inyección de dependencias, conectándose de forma automática
     * este controlador con el servicio de películas
     */
    @Autowired
    private PeliculaService peliculaService;

    /**
     * <strong>@GetMapping</strong><br>
     * Muestra una lista de todas las películas disponibles.
     *
     * <p>Este método recupera todas las películas de la base de datos a través del servicio de películas
     * y las agrega al modelo para ser renderizadas en la vista. La vista se encarga de presentar la lista
     * de películas al usuario en un formato legible.
     *
     * @param model El modelo utilizado para compartir datos entre el controlador y la vista.
     *              En este caso, se añade una lista de películas al modelo con la clave "listaPeliculas".
     * @return El nombre de la plantilla de vista que se utilizará para mostrar la lista de películas.
     *         En este caso, es "/peliculas/lista-peliculas".
     */
    // === Path for list movie === //
    @GetMapping
    public String mostrarPeliculas(Model model){

//        List<Pelicula> listaPeliculas = peliculaService.searchAllObjects();
//        model.addAttribute("listaPeliculas", listaPeliculas);

        return "/admin/dashboard";
    }

    /** <strong>@RequestMapping</strong> <br>
     * Maneja la solicitud para mostrar un formulario para crear una nueva película.
     *
     * <p>Este método es responsable de preparar un nuevo objeto {@link Pelicula} y agregarlo al modelo.
     * Luego, el modelo se utiliza para completar el formulario en la vista.
     *
     * @param model El modelo utilizado para compartir datos entre el controlador y la vista.
     * @return El nombre de la plantilla de vista a representar, que es "/peliculas/nueva-pelicula".
     */
    // === Path for a new movie === //
    @RequestMapping("/nuevo")
    public String nuevaPelicula( Model model ){
        Pelicula pelicula = new Pelicula();
        model.addAttribute("pelicula", pelicula);
        return "/peliculas/nueva-pelicula";
    }

    /**
     * <strong>@PostMapping</strong> <br>
     * Crea una nueva película a partir de los datos proporcionados en el formulario.
     *
     * <p>Este método recibe un objeto {@link Pelicula} que contiene los datos de la nueva película.
     * Luego, delega la creación de la película al servicio de películas, el cual se encarga de
     * persistir los datos en la base de datos. Finalmente, redirige al usuario a la lista de películas.
     *
     * @param pelicula La película a crear, obtenida del formulario.
     * @return La URL a la que se redirige después de crear la película.
     */
    // === Path for save a movie === //
    @PostMapping("/guardar")
    public String crearPelicula(@ModelAttribute("pelicula") Pelicula pelicula){
        peliculaService.createObject(pelicula);
        return "redirect:/peliculas";
    }



    /**
     * <strong>@DeleteMapping</strong><br>
     * Elimina una película por su id.
     *
     * <p>Este método delega la eliminación de la película al servicio de películas, el cual se encarga
     * de borrar los datos de la base de datos. Finalmente, redirige al usuario a la lista de películas.
     *
     * @param id El identificador de la película a eliminar.
     * @return La URL a la que se redirige después de eliminar la película.
     */
    // === Path for delete a movie by id === //
    @GetMapping("eliminar/{id}")
    public String eliminarPelicula(@PathVariable (name = "id") int id){
        peliculaService.deleteObjectById(id);
        return "redirect:/peliculas";
    }
}
