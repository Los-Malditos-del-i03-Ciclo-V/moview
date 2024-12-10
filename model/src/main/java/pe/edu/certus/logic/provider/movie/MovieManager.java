package pe.edu.certus.logic.provider.movie;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.certus.entities.movie.MovieEntity;
import pe.edu.certus.logic.contract.ForCrudMethods;
import pe.edu.certus.repository.movie.ForManagingMovie;

import java.util.List;

@Service
public class MovieManager implements ForCrudMethods<MovieEntity, Integer> {

    @Autowired
    ForManagingMovie forManagingMovie;;

    @Override
    public MovieEntity createEntity(MovieEntity entity) {
        return forManagingMovie.save(entity);
    }

    @Override
    public MovieEntity findEntityById(Integer id) {
        return forManagingMovie.findById(id).get();
    }

    @Override
    public List<MovieEntity> findAllEntities() {
        return forManagingMovie.findAll();
    }

    @Override
    public MovieEntity updateEntity(MovieEntity entity) {
        return forManagingMovie.save(entity);
    }

    @Override
    public void deleteEntityById(Integer id) {
        forManagingMovie.deleteById(id);
    }
}
