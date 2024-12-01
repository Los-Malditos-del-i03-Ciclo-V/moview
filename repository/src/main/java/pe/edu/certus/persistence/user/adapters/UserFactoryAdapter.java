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
    UserConvertersAdapter forUserConvertersAdapter;

    @Override
    public UserDAO createAndSaveAnyDao(UserDTO dto) {
        UserDAO userDAO = forUserConvertersAdapter.convertToDao(dto);
        return forManagingUser.save(userDAO);
    }

    @PostConstruct
    public void init() {
        if (forManagingUser.count() == 0) {
            createDefaultEntities();
        }
    }

    @Override
    public void createDefaultEntities() {
        // Administrador del sistema
        createAndSaveAnyDao(UserDTO.builder()
                .username("admin")
                .password("admin123")
                .email("admin@moview.com")
                .phone("999888777")
                .build());

        // Usuarios regulares
        createAndSaveAnyDao(UserDTO.builder()
                .username("juan.perez")
                .password("juan123")
                .email("juan.perez@gmail.com")
                .phone("987654321")
                .build());

        createAndSaveAnyDao(UserDTO.builder()
                .username("maria.garcia")
                .password("maria123")
                .email("maria.garcia@hotmail.com")
                .phone("987123456")
                .build());

        createAndSaveAnyDao(UserDTO.builder()
                .username("carlos.rodriguez")
                .password("carlos123")
                .email("carlos.rodriguez@outlook.com")
                .phone("999555444")
                .build());

        createAndSaveAnyDao(UserDTO.builder()
                .username("ana.martinez")
                .password("ana123")
                .email("ana.martinez@yahoo.com")
                .phone("944555666")
                .build());

        createAndSaveAnyDao(UserDTO.builder()
                .username("pedro.sanchez")
                .password("pedro123")
                .email("pedro.sanchez@gmail.com")
                .phone("977888999")
                .build());

        createAndSaveAnyDao(UserDTO.builder()
                .username("lucia.torres")
                .password("lucia123")
                .email("lucia.torres@outlook.com")
                .phone("966777888")
                .build());

        createAndSaveAnyDao(UserDTO.builder()
                .username("diego.lopez")
                .password("diego123")
                .email("diego.lopez@gmail.com")
                .phone("955666777")
                .build());

        createAndSaveAnyDao(UserDTO.builder()
                .username("sofia.ruiz")
                .password("sofia123")
                .email("sofia.ruiz@hotmail.com")
                .phone("944333222")
                .build());

        createAndSaveAnyDao(UserDTO.builder()
                .username("miguel.castro")
                .password("miguel123")
                .email("miguel.castro@gmail.com")
                .phone("933222111")
                .build());
    }
}
