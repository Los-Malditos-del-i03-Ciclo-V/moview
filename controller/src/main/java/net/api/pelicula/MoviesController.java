package net.api.pelicula;

import net.business.pelicula.PeliculaService;
import net.entity.pelicula.Pelicula;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/peliculas")

public class MoviesController {


    @Autowired
    private PeliculaService service;

    @GetMapping
    public String mostrarMovies(Model model) {
        List<Pelicula> listaMovies = service.searchAllObjects();

        model.addAttribute("listaMovies", listaMovies);
        return "movies/movies";
    }


    // === Path for update a movie by id === //
    @GetMapping("/actualizar/{id}")
    public ModelAndView editarPelicula (@PathVariable(name = "id") int id){
        ModelAndView modelAndView = new ModelAndView("/peliculas/editar-pelicula");
        Pelicula pelicula = service.searchObjectById(id);
        modelAndView.addObject("pelicula", pelicula);
        return modelAndView;
    }

}
