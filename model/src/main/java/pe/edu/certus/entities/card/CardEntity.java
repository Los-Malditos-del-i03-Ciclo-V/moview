package pe.edu.certus.entities.card;

import  jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "card")
public class CardEntity {

    @Id
    @Column(name = "id")
    @Basic( optional = false )
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
