package pe.edu.certus.persistence.snack.port;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.certus.persistence.snack.dao.SnackDAO;

@Repository
public interface ForManagingSnack extends JpaRepository<SnackDAO, Integer> {
}
