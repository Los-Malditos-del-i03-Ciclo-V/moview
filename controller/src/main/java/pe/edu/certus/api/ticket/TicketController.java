package pe.edu.certus.api.ticket;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import pe.edu.certus.adapter.projection.ProjectionMethodsAdapter;
import pe.edu.certus.model.projection.dto.ProjectionDTO;
import pe.edu.certus.adapter.movie.MovieMethodsAdapter;
import pe.edu.certus.model.movie.dto.MovieDTO;

import java.time.LocalTime;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Controller
@SessionAttributes("selectedMovieId")

public class TicketController {

}