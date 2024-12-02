package pe.edu.certus.persistence.ticket.dao;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import pe.edu.certus.persistence.movie.dao.MovieDAO;
import pe.edu.certus.persistence.order.dao.OrderDAO;
import pe.edu.certus.persistence.user.dao.UserDAO;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "ticket")
public class TicketDAO {

    @Id
    @Column(name = "id")
    @Basic(optional = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String spaceCode;
    private Double price;
    private Boolean isUsed;
    private LocalDateTime timestamp;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_user_id", referencedColumnName = "id")
    private UserDAO user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_movie_id", referencedColumnName = "id")
    private MovieDAO movie;


}
