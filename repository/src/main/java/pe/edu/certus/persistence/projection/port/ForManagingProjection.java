package pe.edu.certus.persistence.projection.port;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.certus.persistence.projection.dao.ProjectionDAO;

@Repository
public interface ForManagingProjection extends JpaRepository<ProjectionDAO, Integer> {
}
