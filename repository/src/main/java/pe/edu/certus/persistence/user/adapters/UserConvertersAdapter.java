package pe.edu.certus.persistence.user.adapters;

import org.springframework.stereotype.Component;
import pe.edu.certus.model.user.dto.UserDTO;
import pe.edu.certus.persistence.essentials.converter.ForConvert;
import pe.edu.certus.persistence.user.dao.UserDAO;

@Component
public class UserConvertersAdapter implements ForConvert<UserDAO, UserDTO> {
    @Override
    public UserDAO convertToDao(UserDTO dto) {
        return UserDAO.builder()
                .username(dto.getUsername())
                .password(dto.getPassword())
                .email(dto.getEmail())
                .phone(dto.getPhone())
                .build();
    }

    @Override
    public UserDTO convertToDto(UserDAO dao) {
        return UserDTO.builder()
                .id(dao.getId())
                .username(dao.getUsername())
                .password(dao.getPassword())
                .email(dao.getEmail())
                .phone(dao.getPhone())
                .build();
    }
}
