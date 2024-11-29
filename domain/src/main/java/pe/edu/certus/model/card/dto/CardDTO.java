package pe.edu.certus.model.card.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CardDTO {

    private Integer id;
    private String fullName;
    private String documentType;
    private Integer documentNumber;
    private Integer cardNumber;
    private String expirationDate;
    private String cvc;
    private String emailAddress;
    private Boolean isActive;

}
