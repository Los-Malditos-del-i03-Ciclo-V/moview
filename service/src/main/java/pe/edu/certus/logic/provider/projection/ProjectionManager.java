package pe.edu.certus.logic.provider.projection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.certus.entities.projection.ProjectionEntity;
import pe.edu.certus.logic.contract.ForCrudMethods;
import pe.edu.certus.repository.projection.ForManagingProjection;

import java.util.List;

@Service
public class ProjectionManager implements ForCrudMethods<ProjectionEntity,Integer> {

    @Autowired
    ForManagingProjection forManagingProjection;

    @Override
    public ProjectionEntity createEntity(ProjectionEntity entity) {
        return forManagingProjection.save(entity);
    }

    @Override
    public ProjectionEntity findEntityById(Integer id) {
        return forManagingProjection.findById(id).get();
    }

    @Override
    public List<ProjectionEntity> findAllEntities() {
        return forManagingProjection.findAll();
    }

    @Override
    public ProjectionEntity updateEntity(ProjectionEntity entity) {
        return forManagingProjection.save(entity);
    }

    @Override
    public void deleteEntityById(Integer id) {
        forManagingProjection.deleteById(id);
    }
}
