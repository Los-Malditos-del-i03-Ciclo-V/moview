package pe.edu.certus.entities.orden;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import pe.edu.certus.entities.snack.SnackEntity;
import pe.edu.certus.entities.ticket.TicketEntity;
import pe.edu.certus.entities.user.UserEntity;
import pe.edu.certus.entities.card.CardEntity;
import pe.edu.certus.entities.movie.MovieEntity;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "orden")
public class OrdenEntity {

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
    private UserEntity user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_movie_id", referencedColumnName = "id")
    private MovieEntity movie;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_ticket_id", referencedColumnName = "id")
    private TicketEntity ticket;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_snack_id", referencedColumnName = "id")
    private SnackEntity snack;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_card_id", referencedColumnName = "id")
    private CardEntity card;

}
