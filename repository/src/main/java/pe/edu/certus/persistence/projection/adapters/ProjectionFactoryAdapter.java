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
    private ForManagingProjection forManagingProjection;

    @Autowired
    private ForManagingMovie forManagingMovie;

    @Autowired
    private ProjectionConvertersAdapter forProjectionConvertersAdapter;

    @PostConstruct
    public void init() {
        if (forManagingProjection.count() == 0) {
            createDefaultEntities();
        }
    }

    @Override
    public ProjectionDAO createAndSaveAnyDao(ProjectionDTO projectionDTO) {
        ProjectionDAO projectionDAO = forProjectionConvertersAdapter.convertToDao(projectionDTO);
        return forManagingProjection.save(projectionDAO);
    }

    @Override
    public void createDefaultEntities() {
        List<Integer> movies = forManagingMovie.findAll().stream()
                .map(movie -> movie.getId())
                .toList();

        // Crear 10 proyecciones base que se repetirán para cada película
        LocalDate startDate = LocalDate.of(2024, 1, 3);
        LocalTime[] times = {
            LocalTime.of(10, 0),  // 10:00 AM
            LocalTime.of(12, 30), // 12:30 PM
            LocalTime.of(15, 0),  // 3:00 PM
            LocalTime.of(17, 30), // 5:30 PM
            LocalTime.of(20, 0),  // 8:00 PM
            LocalTime.of(22, 30), // 10:30 PM
            LocalTime.of(13, 0),  // 1:00 PM
            LocalTime.of(16, 0),  // 4:00 PM
            LocalTime.of(18, 30), // 6:30 PM
            LocalTime.of(21, 0)   // 9:00 PM
        };

        for (Integer movieId : movies) {
            for (int i = 0; i < 10; i++) {
                createAndSaveAnyDao(ProjectionDTO.builder()
                        .projectionDate(startDate.plusDays(i))
                        .projectionTime(times[i])
                        .movieId(movieId)
                        .build());
            }
        }
    }
}
