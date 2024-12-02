package pe.edu.certus.persistence.card.port;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.certus.persistence.card.dao.CardDAO;

@Repository
public interface ForManagingCard extends JpaRepository<CardDAO, Integer> {
}
