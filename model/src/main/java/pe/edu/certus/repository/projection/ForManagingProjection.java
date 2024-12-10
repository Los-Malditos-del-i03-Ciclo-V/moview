package pe.edu.certus.repository.projection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.certus.entities.projection.ProjectionEntity;

@Repository
public interface ForManagingProjection extends JpaRepository<ProjectionEntity, Integer> {
}
