package pe.edu.certus.repository.snack;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.certus.entities.snack.SnackEntity;

@Repository
public interface ForManagingSnack extends JpaRepository<SnackEntity, Integer> {
}
