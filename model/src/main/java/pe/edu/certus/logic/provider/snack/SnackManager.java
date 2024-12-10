package pe.edu.certus.logic.provider.snack;

import org.springframework.beans.factory.annotation.Autowired;
import pe.edu.certus.entities.snack.SnackEntity;
import pe.edu.certus.logic.contract.ForCrudMethods;
import pe.edu.certus.repository.snack.ForManagingSnack;

import java.util.List;

public class SnackManager implements ForCrudMethods<SnackEntity, Integer> {

    @Autowired
    ForManagingSnack snackRepository;

    @Override
    public SnackEntity createEntity(SnackEntity entity) {
        return snackRepository.save(entity);
    }

    @Override
    public SnackEntity findEntityById(Integer id) {
        return snackRepository.findById(id).get();
    }

    @Override
    public List<SnackEntity> findAllEntities() {
        return snackRepository.findAll();
    }

    @Override
    public SnackEntity updateEntity(SnackEntity entity) {
        return snackRepository.save(entity);
    }

    @Override
    public void deleteEntityById(Integer id) {
        snackRepository.deleteById(id);
    }
}
