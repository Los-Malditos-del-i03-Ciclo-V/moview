package pe.edu.certus.persistence.card.adapters;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pe.edu.certus.model.card.dto.CardDTO;
import pe.edu.certus.persistence.card.dao.CardDAO;
import pe.edu.certus.persistence.card.port.ForManagingCard;
import pe.edu.certus.persistence.essentials.factory.ForFactory;

@Component
public class CardFactoryAdapter implements ForFactory<CardDAO, CardDTO> {

    @Autowired
    ForManagingCard forManagingCard;

    @Autowired
    CardConvertersAdapter forCardConvertersAdapter;
    @Override
    public CardDAO createAndSaveAnyDao(CardDTO dto) {
        CardDAO cardDAO = forCardConvertersAdapter.convertToDao(dto);
        return forManagingCard.save(cardDAO);
    }

    @PostConstruct
    public void init() {
        if (forManagingCard.count() == 0) {
            createDefaultEntities();
        }
    }

    @Override
    public void createDefaultEntities() {
        createAndSaveAnyDao(CardDTO.builder()
                .fullName("Juan")
                .documentType("DNI")
                .documentNumber(123456789)
                .cardNumber(123456789)
                .expirationDate("12/12")
                .cvc("123")
                .emailAddress("juan@gmail.com")
                .isActive(true)
                .build());
        createAndSaveAnyDao(CardDTO.builder()
                .fullName("Pedro")
                .documentType("DNI")
                .documentNumber(987654321)
                .cardNumber(987654321)
                .expirationDate("12/12")
                .cvc("123")
                .emailAddress("pedro@gmail.com")
                .isActive(true)
                .build());
        createAndSaveAnyDao(CardDTO.builder()
                .fullName("Carlos")
                .documentType("DNI")
                .documentNumber(876543210)
                .cardNumber(876543210)
                .expirationDate("12/12")
                .cvc("123")
                .emailAddress("carlos@gmail.com")
                .isActive(true)
                .build());
        createAndSaveAnyDao(CardDTO.builder()
                .fullName("Luis")
                .documentType("DNI")
                .documentNumber(98765432)
                .cardNumber(98765432)
                .expirationDate("12/12")
                .cvc("123")
                .emailAddress("luis@gmail.com")
                .isActive(true)
                .build());
        createAndSaveAnyDao(CardDTO.builder()
                .fullName("Maria")
                .documentType("DNI")
                .documentNumber(654321098)
                .cardNumber(654321098)
                .expirationDate("12/12")
                .cvc("123")
                .emailAddress("maria@gmail.com")
                .isActive(true)
                .build());
        createAndSaveAnyDao(CardDTO.builder()
                .fullName("Juan")
                .documentType("DNI")
                .documentNumber(432109876)
                .cardNumber(432109876)
                .expirationDate("12/12")
                .cvc("123")
                .emailAddress("juan@gmail.com")
                .isActive(true)
                .build());
        createAndSaveAnyDao(CardDTO.builder()
                .fullName("Pedro")
                .documentType("DNI")
                .documentNumber(210987654)
                .cardNumber(210987654)
                .expirationDate("12/12")
                .cvc("123")
                .emailAddress("pedro@gmail.com")
                .isActive(true)
                .build());
        createAndSaveAnyDao(CardDTO.builder()
                .fullName("Carlos")
                .documentType("DNI")
                .documentNumber(321098765)
                .cardNumber(321098765)
                .expirationDate("12/12")
                .cvc("123")
                .emailAddress("carlos@gmail.com")
                .isActive(true)
                .build());
        createAndSaveAnyDao(CardDTO.builder()
                .fullName("Luis")
                .documentType("DNI")
                .documentNumber(109876543)
                .cardNumber(109876543)
                .expirationDate("12/12")
                .cvc("123")
                .emailAddress("luis@gmail.com")
                .isActive(true)
                .build());
        createAndSaveAnyDao(CardDTO.builder()
                .fullName("Maria")
                .documentType("DNI")
                .documentNumber(654321098)
                .cardNumber(654321098)
                .expirationDate("12/12")
                .cvc("123")
                .emailAddress("maria@gmail.com")
                .isActive(true)
                .build());
    }
}
