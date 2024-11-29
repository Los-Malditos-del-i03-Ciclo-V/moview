package pe.edu.certus.model.order.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderDTO {

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
