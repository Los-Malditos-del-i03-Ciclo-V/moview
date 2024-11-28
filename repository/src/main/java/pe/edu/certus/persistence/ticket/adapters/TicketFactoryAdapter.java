package pe.edu.certus.persistence.ticket.adapters;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pe.edu.certus.model.ticket.dto.TicketDTO;
import pe.edu.certus.persistence.essentials.factory.ForFactory;
import pe.edu.certus.persistence.ticket.dao.TicketDAO;
import pe.edu.certus.persistence.ticket.port.ForManagingTicket;

@Component
public class TicketFactoryAdapter implements ForFactory<TicketDAO, TicketDTO> {

    @Autowired
    ForManagingTicket forManagingTicket;

    @Autowired
    TicketConvertersAdapter forTicketConvertersAdapter;

    @Override
    public TicketDAO createAndSaveAnyDao(TicketDTO ticketDTO) {
        return forManagingTicket.save(forTicketConvertersAdapter.convertToDao(ticketDTO));
    }

    @PostConstruct
    public void init() {
        if (forManagingTicket.count() == 0) {
            createDefaultEntities();
        }
    }

    @Override
    public void createDefaultEntities() {
        createAndSaveAnyDao(TicketDTO.builder()
                .spaceCode("123456789")
                .price(1.00)
                .isUsed(false)
                .timestamp(null)
                .build());
        createAndSaveAnyDao(TicketDTO.builder()
                .spaceCode("987654321")
                .price(1.00)
                .isUsed(false)
                .timestamp(null)
                .build());
        createAndSaveAnyDao(TicketDTO.builder()
                .spaceCode("876543210")
                .price(1.00)
                .isUsed(false)
                .timestamp(null)
                .build());
        createAndSaveAnyDao(TicketDTO.builder()
                .spaceCode("098765432")
                .price(1.00)
                .isUsed(false)
                .timestamp(null)
                .build());
        createAndSaveAnyDao(TicketDTO.builder()
                .spaceCode("654321098")
                .price(1.00)
                .isUsed(false)
                .timestamp(null)
                .build());
        createAndSaveAnyDao(TicketDTO.builder()
                .spaceCode("432109876")
                .price(1.00)
                .isUsed(false)
                .timestamp(null)
                .build());
        createAndSaveAnyDao(TicketDTO.builder()
                .spaceCode("210987654")
                .price(1.00)
                .isUsed(true)
                .timestamp(null)
                .build());
        createAndSaveAnyDao(TicketDTO.builder()
                .spaceCode("321098765")
                .price(1.00)
                .isUsed(true)
                .timestamp(null)
                .build());
        createAndSaveAnyDao(TicketDTO.builder()
                .spaceCode("109876543")
                .price(1.00)
                .isUsed(true)
                .timestamp(null)
                .build());
        createAndSaveAnyDao(TicketDTO.builder()
                .spaceCode("765432109")
                .price(1.00)
                .isUsed(true)
                .timestamp(null)
                .build());
    }
}
