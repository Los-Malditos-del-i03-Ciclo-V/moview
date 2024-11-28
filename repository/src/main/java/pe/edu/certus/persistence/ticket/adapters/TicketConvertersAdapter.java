package pe.edu.certus.persistence.ticket.adapters;

import org.springframework.stereotype.Component;
import pe.edu.certus.model.ticket.dto.TicketDTO;
import pe.edu.certus.persistence.essentials.converter.ForConvert;
import pe.edu.certus.persistence.ticket.dao.TicketDAO;

@Component
public class TicketConvertersAdapter implements ForConvert<TicketDAO, TicketDTO> {
    @Override
    public TicketDAO convertToDao(TicketDTO dto) {
        return TicketDAO.builder()
                .spaceCode(dto.getSpaceCode())
                .isUsed(dto.getIsUsed())
                .timestamp(dto.getTimestamp())
                .build();
    }

    @Override
    public TicketDTO convertToDto(TicketDAO dao) {
        return TicketDTO.builder()
                .userId(dao.getUserId())
                .spaceCode(dao.getSpaceCode())
                .isUsed(dao.getIsUsed())
                .timestamp(dao.getTimestamp())
                .ticketId(dao.getTicketId())
                .userId(dao.getUserId())
                .movieId(dao.getMovieId())
                .build();
    }
}
