package pe.edu.certus.api.movie;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import pe.edu.certus.adapter.movie.MovieMethodsAdapter;
import pe.edu.certus.adapter.projection.ProjectionMethodsAdapter;
import pe.edu.certus.model.movie.dto.MovieDTO;
import pe.edu.certus.model.projection.dto.ProjectionDTO;
import pe.edu.certus.persistence.movie.adapters.MovieConvertersAdapter;
import pe.edu.certus.persistence.movie.dao.MovieDAO;

import java.time.LocalTime;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/movies")
@SessionAttributes("selectedMovieId")
public class MovieController {

    private static final String MOVIE_PAGE = "movie/movie";
    private static final String SELECTED_MOVIE_PAGE = "movie/selected-movie";
    private final String MOVIE_CREATE_PAGE = "admin/movie/movie-create";
    private final String MOVIE_EDIT_PAGE = "admin/movie/movie-edit";

    @Autowired
    private MovieMethodsAdapter movieMethodsAdapter;

    @Autowired
    private ProjectionMethodsAdapter projectionMethodsAdapter;

    @Autowired
    private MovieConvertersAdapter forMovieConvertersAdapter;

    @GetMapping()
    public String displayMoviesPage(Model model){
        List<MovieDTO> moviesList = movieMethodsAdapter.findAllEntities();
        model.addAttribute("moviesList", moviesList);
        return MOVIE_PAGE;
    }

    @GetMapping("/selected-movie/{id}")
    public ModelAndView displayMovieDetails(@PathVariable Integer id, Model model) {

        ModelAndView modelAndView = new ModelAndView(SELECTED_MOVIE_PAGE);

        // Guardar el ID de la película en la sesión
        model.addAttribute("selectedMovieId", id);
        
        // Obtener la película
        MovieDTO movie = movieMethodsAdapter.findEntityById(id);

        model.addAttribute("movie", movie);

        // Obtener las proyecciones de la película
        ProjectionDTO projectionDTO = projectionMethodsAdapter.findEntityById(id);

        model.addAttribute("projection", projectionDTO);

        return modelAndView;
    }

    @GetMapping("/create")
    public String displayMovieCreatePage(MovieDTO movieDTO){
        return MOVIE_CREATE_PAGE;
    }

    @PostMapping("/save")
    public String displaySaveMoviePage(@ModelAttribute("movie") MovieDAO movieDAO, BindingResult bindingResult, RedirectAttributes redirectAttributes){

        if (bindingResult.hasErrors()){
            for (ObjectError error : bindingResult.getAllErrors()){
                System.out.println("Ocurrió un error al guardar el movie: " + error.getDefaultMessage());
            }
            return MOVIE_EDIT_PAGE;
        }

        MovieDTO movieDTO = forMovieConvertersAdapter.convertToDto(movieDAO);
        movieMethodsAdapter.updateEntity(movieDTO);

        redirectAttributes.addFlashAttribute("mensaje", "Movie guardado correctamente");
        return "redirect:/movies";
    }

    @GetMapping("/edit/{id}")
    public ModelAndView displayMovieEditPage(@PathVariable(name = "id") Integer id){
        ModelAndView modelAndView = new ModelAndView(MOVIE_EDIT_PAGE);
        MovieDTO movieDTO = movieMethodsAdapter.findEntityById(id);
        modelAndView.addObject("movie", movieDTO);
        return modelAndView;
    }

    @DeleteMapping("/delete/{id}")
    public String deleteMovie(@PathVariable(name = "id") Integer id){
        movieMethodsAdapter.deleteEntityById(id);
        return "redirect:/movies";
    }
}
