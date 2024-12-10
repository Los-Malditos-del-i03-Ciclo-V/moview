package pe.edu.certus.repository.ticket;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.certus.entities.ticket.TicketEntity;

@Repository
public interface ForManagingTicket extends JpaRepository<TicketEntity, Integer> {
}
