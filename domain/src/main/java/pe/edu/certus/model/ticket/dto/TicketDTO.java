package pe.edu.certus.model.ticket.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TicketDTO {

    private Integer id;

    private String spaceCode;
    private Double price;
    private Boolean isUsed;
    private LocalDateTime timestamp;
    private Integer userId;
    private Integer movieId;


}
