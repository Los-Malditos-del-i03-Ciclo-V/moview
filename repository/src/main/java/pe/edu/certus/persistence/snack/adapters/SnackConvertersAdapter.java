package pe.edu.certus.persistence.snack.adapters;

import org.springframework.stereotype.Component;
import pe.edu.certus.model.snack.dto.SnackDTO;
import pe.edu.certus.persistence.essentials.converter.ForConvert;
import pe.edu.certus.persistence.snack.dao.SnackDAO;

@Component
public class SnackConvertersAdapter implements ForConvert<SnackDAO, SnackDTO> {
    @Override
    public SnackDAO convertToDao(SnackDTO dto) {
        return SnackDAO.builder()
                .name(dto.getName())
                .description(dto.getDescription())
                .image(dto.getImage())
                .price(dto.getPrice())
                .quantity(dto.getQuantity())
                .category(dto.getCategory())
                .build();

    }

    @Override
    public SnackDTO convertToDto(SnackDAO dao) {
        return SnackDTO.builder()
                .id(dao.getId())
                .name(dao.getName())
                .description(dao.getDescription())
                .image(dao.getImage())
                .price(dao.getPrice())
                .quantity(dao.getQuantity())
                .category(dao.getCategory())
                .build();
    }
}
