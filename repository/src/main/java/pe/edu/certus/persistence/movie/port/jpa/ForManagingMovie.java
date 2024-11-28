package pe.edu.certus.persistence.movie.port.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.certus.persistence.movie.dao.MovieDAO;

@Repository
public interface ForManagingMovie extends JpaRepository<MovieDAO, Integer> {
}
