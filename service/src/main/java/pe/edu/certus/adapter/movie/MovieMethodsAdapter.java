package pe.edu.certus.adapter.movie;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.certus.crud.ForCrudMethods;
import pe.edu.certus.model.movie.dto.MovieDTO;
import pe.edu.certus.model.projection.dto.ProjectionDTO;
import pe.edu.certus.persistence.movie.adapters.MovieConvertersAdapter;
import pe.edu.certus.persistence.movie.dao.MovieDAO;
import pe.edu.certus.persistence.movie.port.jpa.ForManagingMovie;
import pe.edu.certus.persistence.projection.adapters.ProjectionConvertersAdapter;
import pe.edu.certus.persistence.projection.dao.ProjectionDAO;

import java.util.List;

@Service
public class MovieMethodsAdapter implements ForCrudMethods<MovieDTO, Integer> {

    @Autowired
    private ForManagingMovie forManagingMovie;

    @Autowired
    private MovieConvertersAdapter movieConvertersAdapter;

    @Autowired
    private ProjectionConvertersAdapter projectionConvertersAdapter;

    @Override
    public MovieDTO createEntity(MovieDTO movieDTO) {
        MovieDAO movieDAO = movieConvertersAdapter.convertToDao(movieDTO);
        MovieDAO savedMovieDAO = forManagingMovie.save(movieDAO);
        return movieConvertersAdapter.convertToDto(savedMovieDAO);
    }

    @Override
    public MovieDTO findEntityById(Integer id) {
        MovieDAO movieDAO = forManagingMovie.findById(id)
                .orElseThrow(() -> new RuntimeException("Movie not found"));
        return movieConvertersAdapter.convertToDto(movieDAO);
    }

    @Override
    public List<MovieDTO> findAllEntities() {
        List<MovieDAO> movieDAOs = forManagingMovie.findAll();
        return movieDAOs.stream()
                .map(movieConvertersAdapter::convertToDto)
                .toList();
    }

    @Override
    public MovieDTO updateEntity(MovieDTO movieDTO) {
        if (!forManagingMovie.existsById(movieDTO.getId())) {
            throw new RuntimeException("Movie not found");
        }
        MovieDAO movieDAO = movieConvertersAdapter.convertToDao(movieDTO);
        MovieDAO updatedMovieDAO = forManagingMovie.save(movieDAO);
        return movieConvertersAdapter.convertToDto(updatedMovieDAO);
    }

    @Override
    public void deleteEntityById(Integer id) {
        if (!forManagingMovie.existsById(id)) {
            throw new RuntimeException("Movie not found");
        }
        forManagingMovie.deleteById(id);
    }

    public MovieDTO addProjection(Integer movieId, ProjectionDTO projectionDTO) {
        MovieDAO movieDAO = forManagingMovie.findById(movieId)
                .orElseThrow(() -> new RuntimeException("Movie not found"));
        
        ProjectionDAO projectionDAO = projectionConvertersAdapter.convertToDao(projectionDTO);
        projectionDAO.setMovie(movieDAO);
        movieDAO.getProjections().add(projectionDAO);
        
        MovieDAO savedMovieDAO = forManagingMovie.save(movieDAO);
        return movieConvertersAdapter.convertToDto(savedMovieDAO);
    }
}
