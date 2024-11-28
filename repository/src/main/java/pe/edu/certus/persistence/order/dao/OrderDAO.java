package pe.edu.certus.persistence.order.dao;

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
@Table(name = "order")
public class OrderDAO {

    @Id
    @Column(name = "id")
    @Basic( optional = false )
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer userId;
    private Integer movieId;
    private Integer ticketId;
    private Integer snackId;
    private Integer cardId;

    private LocalDateTime orderDate;
    private Double total;
    private String status;

}
