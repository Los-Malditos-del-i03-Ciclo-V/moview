package pe.edu.certus.persistence.ticket.adapters;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Component;
import pe.edu.certus.model.ticket.dto.TicketDTO;
import pe.edu.certus.persistence.essentials.factory.ForFactory;
import pe.edu.certus.persistence.ticket.dao.TicketDAO;
import pe.edu.certus.persistence.ticket.port.ForManagingTicket;
import pe.edu.certus.persistence.user.port.ForManagingUser;
import pe.edu.certus.persistence.movie.port.jpa.ForManagingMovie;

import java.time.LocalDateTime;
import java.util.List;

@Component
@DependsOn({"userFactoryAdapter", "movieFactoryAdapter"})
public class TicketFactoryAdapter implements ForFactory<TicketDAO, TicketDTO> {

    @Autowired
    ForManagingTicket forManagingTicket;

    @Autowired
    TicketConvertersAdapter forTicketConvertersAdapter;

    @Autowired
    ForManagingUser forManagingUser;

    @Autowired
    ForManagingMovie forManagingMovie;

    @Override
    public TicketDAO createAndSaveAnyDao(TicketDTO ticketDTO) {
        TicketDAO ticketDAO = forTicketConvertersAdapter.convertToDao(ticketDTO);
        return forManagingTicket.save(ticketDAO);
    }

    @PostConstruct
    public void init() {
        if (forManagingTicket.count() == 0) {
            createDefaultEntities();
        }
    }

    @Override
    public void createDefaultEntities() {
        List<Integer> userIds = forManagingUser.findAll().stream()
                .map(user -> user.getId())
                .toList();
        List<Integer> movieIds = forManagingMovie.findAll().stream()
                .map(movie -> movie.getId())
                .toList();

        // Asumiendo que tenemos al menos 2 usuarios y 8 películas
        createAndSaveAnyDao(TicketDTO.builder()
                .spaceCode("123456789")
                .price(50.00)
                .isUsed(false)
                .timestamp(LocalDateTime.now())
                .userId(userIds.get(0))
                .movieId(movieIds.get(0))
                .build());
        createAndSaveAnyDao(TicketDTO.builder()
                .spaceCode("987654321")
                .price(25.00)
                .isUsed(false)
                .timestamp(LocalDateTime.now())
                .userId(userIds.get(1))
                .movieId(movieIds.get(1))
                .build());
        createAndSaveAnyDao(TicketDTO.builder()
                .spaceCode("876543210")
                .price(35.00)
                .isUsed(false)
                .timestamp(LocalDateTime.now())
                .userId(userIds.get(2))
                .movieId(movieIds.get(0))
                .build());
        createAndSaveAnyDao(TicketDTO.builder()
                .spaceCode("098765432")
                .price(45.00)
                .isUsed(false)
                .timestamp(LocalDateTime.now())
                .userId(userIds.get(3))
                .movieId(movieIds.get(1))
                .build());
        createAndSaveAnyDao(TicketDTO.builder()
                .spaceCode("654321098")
                .price(35.00)
                .isUsed(false)
                .timestamp(LocalDateTime.now())
                .userId(userIds.get(4))
                .movieId(movieIds.get(2))
                .build());
        createAndSaveAnyDao(TicketDTO.builder()
                .spaceCode("432109876")
                .price(25.00)
                .isUsed(false)
                .timestamp(LocalDateTime.now())
                .userId(userIds.get(5))
                .movieId(movieIds.get(3))
                .build());
        createAndSaveAnyDao(TicketDTO.builder()
                .spaceCode("210987654")
                .price(15.00)
                .isUsed(true)
                .timestamp(LocalDateTime.now())
                .userId(userIds.get(6))
                .movieId(movieIds.get(4))
                .build());
        createAndSaveAnyDao(TicketDTO.builder()
                .spaceCode("321098765")
                .price(5.00)
                .isUsed(true)
                .timestamp(LocalDateTime.now())
                .userId(userIds.get(7))
                .movieId(movieIds.get(5))
                .build());
        createAndSaveAnyDao(TicketDTO.builder()
                .spaceCode("109876543")
                .price(10.00)
                .isUsed(true)
                .timestamp(LocalDateTime.now())
                .userId(userIds.get(8))
                .movieId(movieIds.get(6))
                .build());
        createAndSaveAnyDao(TicketDTO.builder()
                .spaceCode("765432109")
                .price(20.00)
                .isUsed(true)
                .timestamp(LocalDateTime.now())
                .userId(userIds.get(9))
                .movieId(movieIds.get(7))
                .build());
    }
}
