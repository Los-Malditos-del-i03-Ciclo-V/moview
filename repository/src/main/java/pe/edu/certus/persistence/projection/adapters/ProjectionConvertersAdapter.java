package pe.edu.certus.persistence.projection.adapters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pe.edu.certus.model.projection.dto.ProjectionDTO;
import pe.edu.certus.persistence.essentials.converter.ForConvert;
import pe.edu.certus.persistence.movie.port.jpa.ForManagingMovie;
import pe.edu.certus.persistence.projection.dao.ProjectionDAO;

@Component
public class ProjectionConvertersAdapter implements ForConvert<ProjectionDAO, ProjectionDTO> {

    @Autowired
    private ForManagingMovie forManagingMovie;


    @Override
    public ProjectionDAO convertToDao(ProjectionDTO projectionDTO) {

        ProjectionDAO projectionDAO = ProjectionDAO.builder()
                .projectionDate(projectionDTO.getProjectionDate())
                .projectionTime(projectionDTO.getProjectionTime())
                .build();

        if(projectionDTO.getMovieId() != null) {
            projectionDAO.setMovie(forManagingMovie.findById(projectionDTO.getMovieId()).orElse(null));
        }

        return projectionDAO;
    }

    @Override
    public ProjectionDTO convertToDto(ProjectionDAO projectionDAO) {
        return ProjectionDTO.builder()
                .id(projectionDAO.getId())
                .projectionDate(projectionDAO.getProjectionDate())
                .projectionTime(projectionDAO.getProjectionTime())
                .movieId(projectionDAO.getMovie()
                        != null ? projectionDAO.getMovie().getId() : null)
                .build();

    }
}
