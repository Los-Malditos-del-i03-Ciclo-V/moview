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
    public ProjectionDAO convertToDao(ProjectionDTO dto) {
        ProjectionDAO projectionDAO = ProjectionDAO.builder()
                .id(dto.getId())
                .projectionDate(dto.getProjectionDate())
                .projectionTime(dto.getProjectionTime())
                .build();
        
        if (dto.getMovieId() != null) {
            projectionDAO.setMovie(forManagingMovie.findById(dto.getMovieId()).orElse(null));
        }
        
        return projectionDAO;
    }
    
    @Override
    public ProjectionDTO convertToDto(ProjectionDAO dao) {
        return ProjectionDTO.builder()
                .id(dao.getId())
                .projectionDate(dao.getProjectionDate())
                .projectionTime(dao.getProjectionTime())
                .movieId(dao.getMovie() != null ? dao.getMovie().getId() : null)
                .build();
    }
}
