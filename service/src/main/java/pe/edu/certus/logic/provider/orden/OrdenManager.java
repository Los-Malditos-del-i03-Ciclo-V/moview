package pe.edu.certus.logic.provider.orden;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.certus.entities.orden.OrdenEntity;
import pe.edu.certus.logic.contract.ForCrudMethods;
import pe.edu.certus.repository.orden.ForManagingOrden;

import java.util.List;

@Service
public class OrdenManager implements ForCrudMethods<OrdenEntity, Integer> {

    @Autowired
    ForManagingOrden forManagingOrden;

    @Override
    public OrdenEntity createEntity(OrdenEntity entity) {
        return forManagingOrden.save(entity);
    }

    @Override
    public OrdenEntity findEntityById(Integer id) {
        return forManagingOrden.findById(id).get();
    }

    @Override
    public List<OrdenEntity> findAllEntities() {
        return forManagingOrden.findAll();
    }

    @Override
    public OrdenEntity updateEntity(OrdenEntity entity) {
        return forManagingOrden.save(entity);
    }

    @Override
    public void deleteEntityById(Integer id) {
        forManagingOrden.deleteById(id);
    }
}
