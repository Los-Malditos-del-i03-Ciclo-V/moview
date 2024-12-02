package pe.edu.certus.adapter.projection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.certus.crud.ForCrudMethods;
import pe.edu.certus.model.projection.dto.ProjectionDTO;
import pe.edu.certus.persistence.projection.adapters.ProjectionConvertersAdapter;
import pe.edu.certus.persistence.projection.dao.ProjectionDAO;
import pe.edu.certus.persistence.projection.port.ForManagingProjection;

import java.util.List;

@Service
public class ProjectionMethodsAdapter implements ForCrudMethods<ProjectionDTO, Integer> {

    @Autowired
    ForManagingProjection forManagingProjection;
    
    @Autowired
    ProjectionConvertersAdapter projectionConvertersAdapter;

    @Override
    public ProjectionDTO createEntity(ProjectionDTO projectionDTO) {
        ProjectionDAO projectionDAO = projectionConvertersAdapter.convertToDao(projectionDTO);

        ProjectionDAO savedProjectionDAO = forManagingProjection.save(projectionDAO);

        return projectionConvertersAdapter.convertToDto(savedProjectionDAO);
    }

    @Override
    public ProjectionDTO findEntityById(Integer id) {
        ProjectionDAO projectionDAO = forManagingProjection.findById(id).get();

        return projectionConvertersAdapter.convertToDto(projectionDAO);
    }

    @Override
    public List<ProjectionDTO> findAllEntities() {
        List<ProjectionDAO> projectionDAOs = forManagingProjection.findAll();

        return projectionDAOs.stream()
                .map(projectionConvertersAdapter::convertToDto)
                .toList();
    }

    @Override
    public ProjectionDTO updateEntity(ProjectionDTO projectionDTO) {
        if (!forManagingProjection.existsById(projectionDTO.getId())) {
            throw new RuntimeException("Projection not found");
        }

        ProjectionDAO projectionDAO = projectionConvertersAdapter.convertToDao(projectionDTO);

        ProjectionDAO updatedProjectionDAO = forManagingProjection.save(projectionDAO);

        return projectionConvertersAdapter.convertToDto(updatedProjectionDAO);
    }

    @Override
    public void deleteEntityById(Integer id) {
        if (!forManagingProjection.existsById(id)) {
            throw new RuntimeException("Projection not found");
        }

        forManagingProjection.deleteById(id);

    }
}