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
public class MovieAdapter implements ForCrudMethods<MovieDTO, Integer> {

    @Autowired
    ForManagingMovie forManagingMovie;

    @Autowired
    MovieConvertersAdapter forMovieConvertersAdapter;


    @Override
    public MovieDTO createEntity(MovieDTO movieDTO) {
        MovieDAO movieDAO = forMovieConvertersAdapter.convertToDao(movieDTO);

        MovieDAO savedMovieDAO = forManagingMovie.save(movieDAO);

        return forMovieConvertersAdapter.convertToDto(savedMovieDAO);
    }

    @Override
    public MovieDTO findEntityById(Integer id) {
        MovieDAO movieDAO = forManagingMovie.findById(id).get();
        return forMovieConvertersAdapter.convertToDto(movieDAO);
    }

    @Override
    public List<MovieDTO> findAllEntities() {
        List<MovieDAO> movieDAOs = forManagingMovie.findAll();
        return movieDAOs.stream()
                .map(forMovieConvertersAdapter::convertToDto)
                .toList();
    }


    @Override
    public MovieDTO updateEntity(MovieDTO movieDTO) {
        if (!forManagingMovie.existsById(movieDTO.getId())) {
            throw new RuntimeException("Movie with ID " + movieDTO.getId() + " not found.");
        }
        MovieDAO movieDAO = forMovieConvertersAdapter.convertToDao(movieDTO);
        MovieDAO updatedMovieDAO = forManagingMovie.save(movieDAO);
        return forMovieConvertersAdapter.convertToDto(updatedMovieDAO);
    }


    @Override
    public void deleteEntityById(Integer id) {
        if (!forManagingMovie.existsById(id)) {
            throw new RuntimeException("Movie with ID " + id + " not found.");
        }
        forManagingMovie.deleteById(id);
    }

}
