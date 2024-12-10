package pe.edu.certus.logic.provider.ticket;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.certus.entities.ticket.TicketEntity;
import pe.edu.certus.logic.contract.ForCrudMethods;
import pe.edu.certus.repository.ticket.ForManagingTicket;

import java.util.List;

@Service
public class TicketManager implements ForCrudMethods<TicketEntity, Integer> {

    @Autowired
    ForManagingTicket forManagingTicket;

    @Override
    public TicketEntity createEntity(TicketEntity entity) {
        return forManagingTicket.save(entity);
    }

    @Override
    public TicketEntity findEntityById(Integer id) {
        return forManagingTicket.findById(id).get();
    }

    @Override
    public List<TicketEntity> findAllEntities() {
        return forManagingTicket.findAll();
    }

    @Override
    public TicketEntity updateEntity(TicketEntity entity) {
        return forManagingTicket.save(entity);
    }

    @Override
    public void deleteEntityById(Integer id) {
        forManagingTicket.deleteById(id);
    }
}
