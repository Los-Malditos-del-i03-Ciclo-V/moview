package pe.edu.certus.persistence.projection.port;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pe.edu.certus.persistence.projection.dao.ProjectionDAO;

import java.util.List;

@Repository
public interface ForManagingProjection extends JpaRepository<ProjectionDAO, Integer> {
    @Query("SELECT p FROM ProjectionDAO p WHERE p.movie.id = :movieId")
    List<ProjectionDAO> findByMovieId(@Param("movieId") Integer movieId);
}
