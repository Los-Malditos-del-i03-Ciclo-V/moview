package pe.edu.certus.persistence.projection.adapters;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pe.edu.certus.model.projection.dto.ProjectionDTO;
import pe.edu.certus.persistence.essentials.factory.ForFactory;
import pe.edu.certus.persistence.movie.port.jpa.ForManagingMovie;
import pe.edu.certus.persistence.projection.dao.ProjectionDAO;
import pe.edu.certus.persistence.projection.port.ForManagingProjection;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Component
public class ProjectionFactoryAdapter implements ForFactory<ProjectionDAO, ProjectionDTO> {

    @Autowired
    ForManagingProjection forManagingProjection;

    @Autowired
    ForManagingMovie forManagingMovie;

    @Autowired
    ProjectionConvertersAdapter forProjectionConvertersAdapter;

    @Override
    public ProjectionDAO createAndSaveAnyDao(ProjectionDTO projectionDTO) {
        ProjectionDAO projectionDAO = forProjectionConvertersAdapter.convertToDao(projectionDTO);
        return forManagingProjection.save(projectionDAO);
    }

    @PostConstruct
    public void init() {
        if (forManagingProjection.count() == 0) {
            createDefaultEntities();
        }
    }

    @Override
    public void createDefaultEntities() {
        
        List<Integer> movies = forManagingMovie.findAll().stream()
                .map(movie -> movie.getId())
                .toList();

        createAndSaveAnyDao(ProjectionDTO.builder()
                .projectionDate(LocalDate.of(2024, 1, 3))
                .projectionTime(LocalTime.of(21, 0))
                .movieId(movies.get(0))
                .build());

        createAndSaveAnyDao(ProjectionDTO.builder()
                .projectionDate(LocalDate.of(2024, 1, 4))
                .projectionTime(LocalTime.of(22, 0))
                .movieId(movies.get(1))
                .build());

        createAndSaveAnyDao(ProjectionDTO.builder()
                .projectionDate(LocalDate.of(2024, 1, 5))
                .projectionTime(LocalTime.of(23, 0))
                .movieId(movies.get(2))
                .build());

        createAndSaveAnyDao(ProjectionDTO.builder()
                .projectionDate(LocalDate.of(2024, 1, 6))
                .projectionTime(LocalTime.of(2, 0))
                .movieId(movies.get(3))
                .build());

        createAndSaveAnyDao(ProjectionDTO.builder()
                .projectionDate(LocalDate.of(2024, 1, 7))
                .projectionTime(LocalTime.of(3, 0))
                .movieId(movies.get(4))
                .build());

        createAndSaveAnyDao(ProjectionDTO.builder()
                .projectionDate(LocalDate.of(2024, 1, 8))
                .projectionTime(LocalTime.of(4, 0))
                .movieId(movies.get(5))
                .build());

        createAndSaveAnyDao(ProjectionDTO.builder()
                .projectionDate(LocalDate.of(2024, 1, 9))
                .projectionTime(LocalTime.of(5, 0))
                .movieId(movies.get(6))
                .build());

        createAndSaveAnyDao(ProjectionDTO.builder()
                .projectionDate(LocalDate.of(2024, 1, 10))
                .projectionTime(LocalTime.of(6, 0))
                .movieId(movies.get(7))
                .build());

        createAndSaveAnyDao(ProjectionDTO.builder()
                .projectionDate(LocalDate.of(2024, 1, 11))
                .projectionTime(LocalTime.of(7, 0))
                .movieId(movies.get(8))
                .build());

        createAndSaveAnyDao(ProjectionDTO.builder()
                .projectionDate(LocalDate.of(2024, 1, 12))
                .projectionTime(LocalTime.of(8, 0))
                .movieId(movies.get(9))
                .build());
    }
}
