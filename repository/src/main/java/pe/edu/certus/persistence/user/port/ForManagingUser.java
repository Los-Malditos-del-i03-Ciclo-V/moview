package pe.edu.certus.persistence.user.port;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.certus.persistence.user.dao.UserDAO;

@Repository
public interface ForManagingUser extends JpaRepository<UserDAO, Integer> {
}
