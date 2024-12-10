package pe.edu.certus.repository.card;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.certus.entities.card.CardEntity;

@Repository
public interface ForManagingCard extends JpaRepository<CardEntity, Integer> {
}
