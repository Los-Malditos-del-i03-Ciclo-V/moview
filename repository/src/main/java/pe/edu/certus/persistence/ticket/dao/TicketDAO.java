package pe.edu.certus.persistence.ticket.dao;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

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

    private Integer userId;
    private Integer movieId;
    private Integer ticketId;

}
