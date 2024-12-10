package pe.edu.certus.repository.orden;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.certus.entities.orden.OrdenEntity;

@Repository
public interface ForManagingOrden extends JpaRepository<OrdenEntity, Integer> {
}
