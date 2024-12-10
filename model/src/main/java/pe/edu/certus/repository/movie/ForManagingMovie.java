package pe.edu.certus.repository.movie;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.certus.entities.movie.MovieEntity;

@Repository
public interface ForManagingMovie extends JpaRepository<MovieEntity, Integer> {
}
