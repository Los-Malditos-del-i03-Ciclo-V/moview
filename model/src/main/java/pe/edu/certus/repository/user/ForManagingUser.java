package pe.edu.certus.repository.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.certus.entities.user.UserEntity;

@Repository
public interface ForManagingUser extends JpaRepository<UserEntity, Integer> {
}
