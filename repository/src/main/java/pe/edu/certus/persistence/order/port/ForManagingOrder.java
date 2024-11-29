package pe.edu.certus.persistence.order.port;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.certus.persistence.order.dao.OrderDAO;

@Repository
public interface ForManagingOrder extends JpaRepository<OrderDAO, Integer> {
}
