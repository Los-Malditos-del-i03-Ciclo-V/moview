package pe.edu.certus.api.movie;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import pe.edu.certus.adapter.movie.MovieMethodsAdapter;
import pe.edu.certus.adapter.projection.ProjectionMethodsAdapter;
import pe.edu.certus.model.movie.dto.MovieDTO;
import pe.edu.certus.model.projection.dto.ProjectionDTO;

import java.util.List;

@Controller
public class MovieSelectionController {

    private static final String MOVIE_SELECTED_PAGE = "movie/movie-selected";


}
