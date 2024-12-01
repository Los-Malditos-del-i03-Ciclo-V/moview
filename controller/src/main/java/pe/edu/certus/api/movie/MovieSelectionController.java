package pe.edu.certus.api.movie;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;
import pe.edu.certus.adapter.movie.MovieMethodsAdapter;
import pe.edu.certus.adapter.projection.ProjectionMethodsAdapter;
import pe.edu.certus.model.movie.dto.MovieDTO;
import pe.edu.certus.model.projection.dto.ProjectionDTO;

import java.util.List;

@Controller
@RequestMapping("/selected-movie")
public class MovieSelectionController {
    @Autowired
    private MovieMethodsAdapter movieMethodsAdapter;

    private static final String SELECTED_MOVIE_PAGE = "movie/selected-movie";

    @GetMapping("/{id}")
    public ModelAndView selectedMovie(@PathVariable(name = "id") Integer id, Model model){

        ModelAndView modelAndView = new ModelAndView(SELECTED_MOVIE_PAGE);

        model.addAttribute("selectedMovieId", id);

        MovieDTO movieDTO = movieMethodsAdapter.findEntityById(id);

        modelAndView.addObject("movie", movieDTO);

        return modelAndView;
    }
}
