package pe.edu.certus.persistence.ticket.port;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.certus.persistence.ticket.dao.TicketDAO;

@Repository
public interface ForManagingTicket extends JpaRepository<TicketDAO, Integer> {
}
