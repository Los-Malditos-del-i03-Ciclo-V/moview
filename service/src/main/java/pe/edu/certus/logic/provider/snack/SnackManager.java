package pe.edu.certus.logic.provider.snack;

import org.springframework.beans.factory.annotation.Autowired;
import pe.edu.certus.entities.snack.SnackEntity;
import pe.edu.certus.logic.contract.ForCrudMethods;
import pe.edu.certus.repository.snack.ForManagingSnack;

import java.util.List;

public class SnackManager implements ForCrudMethods<SnackEntity, Integer> {

    @Autowired
    ForManagingSnack forManagingSnack;

    @Override
    public SnackEntity createEntity(SnackEntity entity) {
        return forManagingSnack.save(entity);
    }

    @Override
    public SnackEntity findEntityById(Integer id) {
        return forManagingSnack.findById(id).get();
    }

    @Override
    public List<SnackEntity> findAllEntities() {
        return forManagingSnack.findAll();
    }

    @Override
    public SnackEntity updateEntity(SnackEntity entity) {
        return forManagingSnack.save(entity);
    }

    @Override
    public void deleteEntityById(Integer id) {
        forManagingSnack.deleteById(id);
    }
}
