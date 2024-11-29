package pe.edu.certus.persistence.ticket.adapters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pe.edu.certus.model.ticket.dto.TicketDTO;
import pe.edu.certus.persistence.essentials.converter.ForConvert;
import pe.edu.certus.persistence.movie.port.jpa.ForManagingMovie;
import pe.edu.certus.persistence.ticket.dao.TicketDAO;
import pe.edu.certus.persistence.user.port.ForManagingUser;

@Component
public class TicketConvertersAdapter implements ForConvert<TicketDAO, TicketDTO> {

    @Autowired
    private ForManagingUser forManagingUser;

    @Autowired
    private ForManagingMovie forManagingMovie;

    @Override
    public TicketDAO convertToDao(TicketDTO ticketDTO) {
        TicketDAO ticketDAO = TicketDAO.builder()
                .spaceCode(ticketDTO.getSpaceCode())
                .price(ticketDTO.getPrice())
                .isUsed(ticketDTO.getIsUsed())
                .timestamp(ticketDTO.getTimestamp())
                .build();

        if (ticketDTO.getUserId() != null) {
            ticketDAO.setUser(forManagingUser.findById(ticketDTO.getUserId()).orElse(null));
        }
        if (ticketDTO.getMovieId() != null) {
            ticketDAO.setMovie(forManagingMovie.findById(ticketDTO.getMovieId()).orElse(null));
        }

        return ticketDAO;
    }

    @Override
    public TicketDTO convertToDto(TicketDAO ticketDAO) {
        return TicketDTO.builder()
                .id(ticketDAO.getId())
                .spaceCode(ticketDAO.getSpaceCode())
                .price(ticketDAO.getPrice())
                .isUsed(ticketDAO.getIsUsed())
                .timestamp(ticketDAO.getTimestamp())
                .userId(ticketDAO.getUser()
                        != null ? ticketDAO.getUser().getId() : null)
                .movieId(ticketDAO.getMovie()
                        != null ? ticketDAO.getMovie().getId() : null)
                .build();
    }
}
