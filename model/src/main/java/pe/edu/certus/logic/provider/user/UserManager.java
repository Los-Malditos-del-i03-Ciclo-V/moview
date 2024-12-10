package pe.edu.certus.logic.provider.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.certus.entities.user.UserEntity;
import pe.edu.certus.logic.contract.ForCrudMethods;
import pe.edu.certus.repository.user.ForManagingUser;

import java.util.List;

@Service
public class UserManager implements ForCrudMethods<UserEntity, Integer> {

    @Autowired
    ForManagingUser forManagingUser;

    @Override
    public UserEntity createEntity(UserEntity entity) {
        return forManagingUser.save(entity);
    }

    @Override
    public UserEntity findEntityById(Integer id) {
        return forManagingUser.findById(id).get();
    }

    @Override
    public List<UserEntity> findAllEntities() {
        return forManagingUser.findAll();
    }

    @Override
    public UserEntity updateEntity(UserEntity entity) {
        return forManagingUser.save(entity);
    }

    @Override
    public void deleteEntityById(Integer id) {
        forManagingUser.deleteById(id);
    }
}
