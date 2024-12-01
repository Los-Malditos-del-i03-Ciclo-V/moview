package pe.edu.certus.persistence.card.adapters;

import org.springframework.stereotype.Component;
import pe.edu.certus.model.card.dto.CardDTO;
import pe.edu.certus.persistence.card.dao.CardDAO;
import pe.edu.certus.persistence.essentials.converter.ForConvert;

@Component
public class CardConvertersAdapter implements ForConvert<CardDAO, CardDTO> {
    @Override
    public CardDAO convertToDao(CardDTO dto) {
        return CardDAO.builder()
                .fullName(dto.getFullName())
                .documentType(dto.getDocumentType())
                .documentNumber(dto.getDocumentNumber())
                .cardNumber(dto.getCardNumber())
                .expirationDate(dto.getExpirationDate())
                .cvc(dto.getCvc())
                .emailAddress(dto.getEmailAddress())
                .isActive(dto.getIsActive())
                .build();
    }

    @Override
    public CardDTO convertToDto(CardDAO dao) {
        return CardDTO.builder()
                .id(dao.getId())
                .fullName(dao.getFullName())
                .documentType(dao.getDocumentType())
                .documentNumber(dao.getDocumentNumber())
                .cardNumber(dao.getCardNumber())
                .expirationDate(dao.getExpirationDate())
                .cvc(dao.getCvc())
                .emailAddress(dao.getEmailAddress())
                .isActive(dao.getIsActive())
                .build();
    }
}
