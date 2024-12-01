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
import pe.edu.certus.model.movie.dto.MovieDTO;
import pe.edu.certus.persistence.movie.adapters.MovieConvertersAdapter;
import pe.edu.certus.persistence.movie.dao.MovieDAO;

import java.util.List;

@Controller
@RequestMapping("/movies")
@SessionAttributes("selectedMovieId")
public class MovieController {

    private static final String MOVIE_PAGE = "movie/movie";
    private final String MOVIE_LIST_PAGE = "admin/movie/movie-list";
    private final String MOVIE_CREATE_PAGE = "admin/movie/movie-create";
    private final String MOVIE_EDIT_PAGE = "admin/movie/movie-edit";

    @Autowired
    private MovieMethodsAdapter movieMethodsAdapter;

    @Autowired
    private MovieConvertersAdapter forMovieConvertersAdapter;

    @GetMapping()
    public String displayMoviesPage(Model model){

        List<MovieDTO> moviesList = movieMethodsAdapter.findAllEntities();
        model.addAttribute("moviesList", moviesList);
        return MOVIE_PAGE;

    }

    @GetMapping("/select/{id}")
    public String selectMovie(@PathVariable(name = "id") Integer id, Model model){
        model.addAttribute("selectedMovieId", id);
        return "redirect:/movies/select/{id}";
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
