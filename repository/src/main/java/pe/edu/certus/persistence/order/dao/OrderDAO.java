package pe.edu.certus.persistence.order.dao;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import pe.edu.certus.persistence.card.dao.CardDAO;
import pe.edu.certus.persistence.movie.dao.MovieDAO;
import pe.edu.certus.persistence.snack.dao.SnackDAO;
import pe.edu.certus.persistence.ticket.dao.TicketDAO;
import pe.edu.certus.persistence.user.dao.UserDAO;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "orden")
public class OrderDAO {

    @Id
    @Column(name = "id")
    @Basic(optional = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private LocalDateTime orderDate;
    private Double total;
    private String status;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_user_id", referencedColumnName = "id")
    private UserDAO user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_movie_id", referencedColumnName = "id")
    private MovieDAO movie;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_ticket_id", referencedColumnName = "id")
    private TicketDAO ticket;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_snack_id", referencedColumnName = "id")
    private SnackDAO snack;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_card_id", referencedColumnName = "id")
    private CardDAO card;

}
