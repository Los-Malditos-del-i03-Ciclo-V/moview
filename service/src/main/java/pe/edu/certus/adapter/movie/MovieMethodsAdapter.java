package pe.edu.certus.adapter.movie;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.certus.crud.ForCrudMethods;
import pe.edu.certus.model.movie.dto.MovieDTO;
import pe.edu.certus.persistence.movie.adapters.MovieConvertersAdapter;
import pe.edu.certus.persistence.movie.dao.MovieDAO;
import pe.edu.certus.persistence.movie.port.jpa.ForManagingMovie;

import java.util.List;

@Service
public class MovieMethodsAdapter implements ForCrudMethods<MovieDTO, Integer> {

    @Autowired
    ForManagingMovie forManagingMovie;

    @Autowired
    MovieConvertersAdapter movieConvertersAdapter;


    @Override
    public MovieDTO createEntity(MovieDTO movieDTO) {
        MovieDAO movieDAO = movieConvertersAdapter.convertToDao(movieDTO);

        MovieDAO savedMovieDAO = forManagingMovie.save(movieDAO);

        return movieConvertersAdapter.convertToDto(savedMovieDAO);
    }

    @Override
    public MovieDTO findEntityById(Integer id) {
        MovieDAO movieDAO = forManagingMovie.findById(id).get();
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
            throw new RuntimeException("Movie with ID " + movieDTO.getId() + " not found.");
        }
        MovieDAO movieDAO = movieConvertersAdapter.convertToDao(movieDTO);
        MovieDAO updatedMovieDAO = forManagingMovie.save(movieDAO);
        return movieConvertersAdapter.convertToDto(updatedMovieDAO);
    }


    @Override
    public void deleteEntityById(Integer id) {
        if (!forManagingMovie.existsById(id)) {
            throw new RuntimeException("Movie with ID " + id + " not found.");
        }
        forManagingMovie.deleteById(id);
    }

}
