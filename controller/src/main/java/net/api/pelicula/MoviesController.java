package net.api.pelicula;

import net.business.pelicula.PeliculaService;
import net.entity.pelicula.Pelicula;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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
}
