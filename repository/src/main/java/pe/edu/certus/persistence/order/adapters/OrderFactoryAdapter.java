package pe.edu.certus.persistence.order.adapters;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Component;
import pe.edu.certus.model.order.dto.OrderDTO;
import pe.edu.certus.persistence.card.port.ForManagingCard;
import pe.edu.certus.persistence.essentials.factory.ForFactory;
import pe.edu.certus.persistence.movie.port.jpa.ForManagingMovie;
import pe.edu.certus.persistence.order.dao.OrderDAO;
import pe.edu.certus.persistence.order.port.ForManagingOrder;
import pe.edu.certus.persistence.snack.port.ForManagingSnack;
import pe.edu.certus.persistence.ticket.port.ForManagingTicket;
import pe.edu.certus.persistence.user.port.ForManagingUser;

import java.time.LocalDateTime;
import java.util.List;

@Component
@DependsOn({"userFactoryAdapter", "movieFactoryAdapter", "snackFactoryAdapter", "cardFactoryAdapter", "ticketFactoryAdapter"})
public class OrderFactoryAdapter implements ForFactory<OrderDAO, OrderDTO> {

    @Autowired
    ForManagingOrder forManagingOrder;

    @Autowired
    ForManagingUser forManagingUser;

    @Autowired
    ForManagingMovie forManagingMovie;

    @Autowired
    ForManagingTicket forManagingTicket;

    @Autowired
    ForManagingSnack forManagingSnack;

    @Autowired
    ForManagingCard forManagingCard;

    @Autowired
    OrderConvertersAdapter forOrderConvertersAdapter;

    @Override
    public OrderDAO createAndSaveAnyDao(OrderDTO dto) {
        OrderDAO orderDAO = forOrderConvertersAdapter.convertToDao(dto);
        return forManagingOrder.save(orderDAO);
    }

    @PostConstruct
    public void init() {
        if (forManagingOrder.count() == 0) {
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
        List<Integer> ticketIds = forManagingTicket.findAll().stream()
                .map(ticket -> ticket.getId())
                .toList();
        List<Integer> snackIds = forManagingSnack.findAll().stream()
                .map(snack -> snack.getId())
                .toList();
        List<Integer> cardIds = forManagingCard.findAll().stream()
                .map(card -> card.getId())
                .toList();

        // Create only 5 default orders to avoid index out of bounds
        createAndSaveAnyDao(OrderDTO.builder()
                .userId(userIds.get(0))
                .movieId(movieIds.get(0))
                .ticketId(ticketIds.get(0))
                .snackId(snackIds.get(0))
                .cardId(cardIds.get(0))
                .orderDate(LocalDateTime.now())
                .total(50.00)
                .status("PENDING")
                .build());
        createAndSaveAnyDao(OrderDTO.builder()
                .userId(userIds.get(1))
                .movieId(movieIds.get(1))
                .ticketId(ticketIds.get(1))
                .snackId(snackIds.get(1))
                .cardId(cardIds.get(1))
                .orderDate(LocalDateTime.now())
                .total(45.00)
                .status("COMPLETED")
                .build());
        createAndSaveAnyDao(OrderDTO.builder()
                .userId(userIds.get(2))
                .movieId(movieIds.get(2))
                .ticketId(ticketIds.get(2))
                .snackId(snackIds.get(2))
                .cardId(cardIds.get(2))
                .orderDate(LocalDateTime.now())
                .total(35.00)
                .status("PENDING")
                .build());
        createAndSaveAnyDao(OrderDTO.builder()
                .userId(userIds.get(3))
                .movieId(movieIds.get(3))
                .ticketId(ticketIds.get(3))
                .snackId(snackIds.get(3))
                .cardId(cardIds.get(3))
                .orderDate(LocalDateTime.now())
                .total(25.00)
                .status("COMPLETED")
                .build());
        createAndSaveAnyDao(OrderDTO.builder()
                .userId(userIds.get(4))
                .movieId(movieIds.get(4))
                .ticketId(ticketIds.get(4))
                .snackId(snackIds.get(4))
                .cardId(cardIds.get(4))
                .orderDate(LocalDateTime.now())
                .total(15.00)
                .status("PENDING")
                .build());
    }
}
