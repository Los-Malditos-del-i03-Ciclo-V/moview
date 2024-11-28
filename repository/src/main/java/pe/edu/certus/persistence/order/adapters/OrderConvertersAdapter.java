package pe.edu.certus.persistence.order.adapters;

import org.springframework.stereotype.Component;
import pe.edu.certus.model.order.dto.OrderDTO;
import pe.edu.certus.persistence.essentials.converter.ForConvert;
import pe.edu.certus.persistence.order.dao.OrderDAO;

@Component
public class OrderConvertersAdapter implements ForConvert<OrderDAO, OrderDTO> {
    @Override
    public OrderDAO convertToDao(OrderDTO dto) {
        return OrderDAO.builder()
                .orderDate(dto.getOrderDate())
                .total(dto.getTotal())
                .status(dto.getStatus())
                .build();
    }

    @Override
    public OrderDTO convertToDto(OrderDAO dao) {
        return OrderDTO.builder()
                .id(dao.getId())
                .userId(dao.getUserId())
                .movieId(dao.getMovieId())
                .ticketId(dao.getTicketId())
                .snackId(dao.getSnackId())
                .cardId(dao.getCardId())
                .orderDate(dao.getOrderDate())
                .total(dao.getTotal())
                .status(dao.getStatus())
                .build();
    }
}
