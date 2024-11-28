package pe.edu.certus.persistence.projection.adapters;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pe.edu.certus.model.projection.dto.ProjectionDTO;
import pe.edu.certus.persistence.essentials.factory.ForFactory;
import pe.edu.certus.persistence.projection.dao.ProjectionDAO;
import pe.edu.certus.persistence.projection.port.ForManagingProjection;

import java.time.LocalDate;
import java.time.LocalTime;

@Component
public class ProjectionFactoryAdapter implements ForFactory<ProjectionDAO, ProjectionDTO> {

    @Autowired
    ForManagingProjection forManagingProjection;

    @Autowired
    ProjectionConvertersAdapter forProjectionConvertersAdapter;

    @Override
    public ProjectionDAO createAndSaveAnyDao(ProjectionDTO projectionDTO) {
        return forManagingProjection.save(forProjectionConvertersAdapter.convertToDao(projectionDTO));
    }

    @PostConstruct
    public void init() {
        if (forManagingProjection.count() == 0) {
            createDefaultEntities();
        }
    }

    @Override
    public void createDefaultEntities() {
        createAndSaveAnyDao(ProjectionDTO.builder()
                .date(LocalDate.of(2024, 1, 5))
                .time(LocalTime.of(18, 30))
                .build());
        createAndSaveAnyDao(ProjectionDTO.builder()
                .date(LocalDate.of(2024, 1, 6))
                .time(LocalTime.of(20, 0))
                .build());
        createAndSaveAnyDao(ProjectionDTO.builder()
                .date(LocalDate.of(2024, 1, 7))
                .time(LocalTime.of(21, 0))
                .build());
        createAndSaveAnyDao(ProjectionDTO.builder()
                .date(LocalDate.of(2024, 1, 8))
                .time(LocalTime.of(22, 0))
                .build());
        createAndSaveAnyDao(ProjectionDTO.builder()
                .date(LocalDate.of(2024, 1, 9))
                .time(LocalTime.of(23, 0))
                .build());
        createAndSaveAnyDao(ProjectionDTO.builder()
                .date(LocalDate.of(2024, 1, 10))
                .time(LocalTime.of(0, 0))
                .build());
        createAndSaveAnyDao(ProjectionDTO.builder()
                .date(LocalDate.of(2024, 1, 11))
                .time(LocalTime.of(1, 0))
                .build());
        createAndSaveAnyDao(ProjectionDTO.builder()
                .date(LocalDate.of(2024, 1, 12))
                .time(LocalTime.of(2, 0))
                .build());
        createAndSaveAnyDao(ProjectionDTO.builder()
                .date(LocalDate.of(2024, 1, 13))
                .time(LocalTime.of(3, 0))
                .build());
        createAndSaveAnyDao(ProjectionDTO.builder()
                .date(LocalDate.of(2024, 1, 14))
                .time(LocalTime.of(4, 0))
                .build());

    }
}
