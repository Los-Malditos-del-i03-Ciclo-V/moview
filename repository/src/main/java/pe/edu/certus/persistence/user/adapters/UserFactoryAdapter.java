package pe.edu.certus.persistence.user.adapters;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pe.edu.certus.model.user.dto.UserDTO;
import pe.edu.certus.persistence.essentials.factory.ForFactory;
import pe.edu.certus.persistence.user.dao.UserDAO;
import pe.edu.certus.persistence.user.port.ForManagingUser;

@Component
public class UserFactoryAdapter implements ForFactory<UserDAO, UserDTO> {

    @Autowired
    ForManagingUser forManagingUser;

    @Autowired
    UserConvertersAdapter userConvertersAdapter;

    @Override
    public UserDAO createAndSaveAnyDao(UserDTO dto) {
        return forManagingUser.save(userConvertersAdapter.convertToDao(dto));
    }

    @PostConstruct
    public void init() {
        if (forManagingUser.count() == 0) {
            createDefaultEntities();
        }
    }

    @Override
    public void createDefaultEntities() {
        createAndSaveAnyDao(UserDTO.builder()
                .username("juan")
                .password("123456")
                .email("juan@gmail.com")
                .phone("123456789")
                .build());
        createAndSaveAnyDao(UserDTO.builder()
                .username("pedro")
                .password("123456")
                .email("pedro@gmail.com")
                .phone("123456789")
                .build());
        createAndSaveAnyDao(UserDTO.builder()
                .username("carlos")
                .password("123456")
                .email("carlos@gmail.com")
                .phone("123456789")
                .build());
        createAndSaveAnyDao(UserDTO.builder()
                .username("luis")
                .password("123456")
                .email("luis@gmail.com")
                .phone("123456789")
                .build());
        createAndSaveAnyDao(UserDTO.builder()
                .username("maria")
                .password("123456")
                .email("maria@gmail.com")
                .phone("123456789")
                .build());
        createAndSaveAnyDao(UserDTO.builder()
                .username("juan")
                .password("123456")
                .email("juan@gmail.com")
                .phone("123456789")
                .build());
        createAndSaveAnyDao(UserDTO.builder()
                .username("pedro")
                .password("123456")
                .email("pedro@gmail.com")
                .phone("123456789")
                .build());
        createAndSaveAnyDao(UserDTO.builder()
                .username("carlos")
                .password("123456")
                .email("carlos@gmail.com")
                .phone("123456789")
                .build());
        createAndSaveAnyDao(UserDTO.builder()
                .username("luis")
                .password("123456")
                .email("luis@gmail.com")
                .phone("123456789")
                .build());
        createAndSaveAnyDao(UserDTO.builder()
                .username("maria")
                .password("123456")
                .email("maria@gmail.com")
                .phone("123456789")
                .build());

    }
}
