package pe.edu.certus.api.movie;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import pe.edu.certus.adapter.movie.MovieAdapter;
import pe.edu.certus.model.movie.dto.MovieDTO;
import pe.edu.certus.persistence.movie.adapters.MovieConvertersAdapter;
import pe.edu.certus.persistence.movie.dao.MovieDAO;

import java.util.List;

@Controller
@RequestMapping("/movies")
public class MovieController {

    private static final String MOVIE_PAGE = "movie/movie";
    private static final String MOVIE_CREATE_PAGE = "movie/create";
    private static final String MOVIE_EDIT_PAGE = "movie/edit";

    @Autowired
    private MovieAdapter movieAdapter;

    @Autowired
    private MovieConvertersAdapter forMovieConvertersAdapter;

    @GetMapping()
    public String displayMoviesPage(Model model){

        List<MovieDTO> moviesList = movieAdapter.findAllEntities();
        model.addAttribute("moviesList", moviesList);
        return MOVIE_PAGE;

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
        movieAdapter.updateEntity(movieDTO);

        redirectAttributes.addFlashAttribute("mensaje", "Movie guardado correctamente");
        return "redirect:/movies";
    }

    @GetMapping("/edit/{id}")
<<<<<<< HEAD
    public ModelAndView displayMovieEditPage(@PathVariable(name = "id") Long id){
=======
    public ModelAndView displayMovieEditPage(@PathVariable(name = "id") Integer id){
>>>>>>> 238ea821ce6955909cf6544365bdee9815fa5c38
        ModelAndView modelAndView = new ModelAndView(MOVIE_EDIT_PAGE);
        MovieDTO movieDTO = movieAdapter.findEntityById(id);
        modelAndView.addObject("movie", movieDTO);
        return modelAndView;
    }

    @DeleteMapping("/delete/{id}")
<<<<<<< HEAD
    public String deleteMovie(@PathVariable(name = "id") Long id){
=======
    public String deleteMovie(@PathVariable(name = "id") Integer id){
>>>>>>> 238ea821ce6955909cf6544365bdee9815fa5c38
        movieAdapter.deleteEntityById(id);
        return "redirect:/movies";
    }
}
