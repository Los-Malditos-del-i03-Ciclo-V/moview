package pe.edu.certus.persistence.order.adapters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pe.edu.certus.model.order.dto.OrderDTO;
import pe.edu.certus.persistence.card.port.ForManagingCard;
import pe.edu.certus.persistence.essentials.converter.ForConvert;
import pe.edu.certus.persistence.movie.port.jpa.ForManagingMovie;
import pe.edu.certus.persistence.order.dao.OrderDAO;
import pe.edu.certus.persistence.snack.port.ForManagingSnack;
import pe.edu.certus.persistence.ticket.port.ForManagingTicket;
import pe.edu.certus.persistence.user.port.ForManagingUser;

@Component
public class OrderConvertersAdapter implements ForConvert<OrderDAO, OrderDTO> {
    
    @Autowired
    private ForManagingUser forManagingUser;
    
    @Autowired
    private ForManagingMovie forManagingMovie;
    
    @Autowired
    private ForManagingTicket forManagingTicket;
    
    @Autowired
    private ForManagingSnack forManagingSnack;
    
    @Autowired
    private ForManagingCard forManagingCard;

    @Override
    public OrderDAO convertToDao(OrderDTO orderDTO) {
        OrderDAO orderDAO = OrderDAO.builder()
                .orderDate(orderDTO.getOrderDate())
                .total(orderDTO.getTotal())
                .status(orderDTO.getStatus())
                .build();

        if (orderDTO.getUserId() != null) {
            orderDAO.setUser(forManagingUser.findById(orderDTO.getUserId()).orElse(null));
        }
        if (orderDTO.getMovieId() != null) {
            orderDAO.setMovie(forManagingMovie.findById(orderDTO.getMovieId()).orElse(null));
        }
        if (orderDTO.getTicketId() != null) {
            orderDAO.setTicket(forManagingTicket.findById(orderDTO.getTicketId()).orElse(null));
        }
        if (orderDTO.getSnackId() != null) {
            orderDAO.setSnack(forManagingSnack.findById(orderDTO.getSnackId()).orElse(null));
        }
        if (orderDTO.getCardId() != null) {
            orderDAO.setCard(forManagingCard.findById(orderDTO.getCardId()).orElse(null));
        }

        return orderDAO;
    }

    @Override
    public OrderDTO convertToDto(OrderDAO orderDAO) {
        return OrderDTO.builder()
                .id(orderDAO.getId())
                .userId(orderDAO.getUser() != null ? orderDAO.getUser().getId() : null)
                .movieId(orderDAO.getMovie() != null ? orderDAO.getMovie().getId() : null)
                .ticketId(orderDAO.getTicket() != null ? orderDAO.getTicket().getId() : null)
                .snackId(orderDAO.getSnack() != null ? orderDAO.getSnack().getId() : null)
                .cardId(orderDAO.getCard() != null ? orderDAO.getCard().getId() : null)
                .orderDate(orderDAO.getOrderDate())
                .total(orderDAO.getTotal())
                .status(orderDAO.getStatus())
                .build();
    }
}
