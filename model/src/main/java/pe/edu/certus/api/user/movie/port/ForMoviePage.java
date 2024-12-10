package pe.edu.certus.api.user.movie.port;

import org.springframework.ui.Model;
import org.springframework.web.servlet.ModelAndView;

public interface ForMoviePage {
    String displayMoviePage(Model model);
    ModelAndView displayMovieDetailPage(Integer id, Model model);
}
