package pe.edu.certus.api.user.movie.adapter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import pe.edu.certus.api.user.movie.port.ForMoviePage;
import pe.edu.certus.api.utils.costants.UserEndpointsRoutes;
import pe.edu.certus.api.utils.costants.UserTemplateRoutes;
import pe.edu.certus.entities.movie.MovieEntity;
import pe.edu.certus.entities.projection.ProjectionEntity;
import pe.edu.certus.logic.provider.movie.MovieManager;
import pe.edu.certus.logic.provider.projection.ProjectionManager;


import java.util.List;

@Controller
@RequestMapping(UserEndpointsRoutes.MOVIE_ENDPOINT)
public class MovieAdapter implements ForMoviePage {

    @Autowired
    MovieManager movieManager;

    @Autowired
    ProjectionManager projectionManager;

    @Override
    @GetMapping()
    public String displayMoviePage(Model model) {
        List<MovieEntity> moviesList = movieManager.findAllEntities();
        model.addAttribute("moviesList", moviesList);
        return UserTemplateRoutes.MOVIE_PAGE;
    }

    @Override
    @GetMapping(UserEndpointsRoutes.SELECTED_MOVIE_ENDPOINT + "/{id}")
    public ModelAndView displayMovieDetailPage(@PathVariable Integer id, Model model) {
        ModelAndView modelAndView = new ModelAndView(UserTemplateRoutes.SELECTED_MOVIE_PAGE);

        MovieEntity selected_movie = movieManager.findEntityById(id);
        model.addAttribute("selected_movie", selected_movie);

        List<ProjectionEntity> projectionsList = projectionManager.findAllEntities();
        model.addAttribute("projectionsList", projectionsList);

        return modelAndView;

    }
}
