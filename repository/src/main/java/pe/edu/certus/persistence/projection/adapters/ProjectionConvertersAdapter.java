package pe.edu.certus.persistence.projection.adapters;

import org.springframework.stereotype.Component;
import pe.edu.certus.model.projection.dto.ProjectionDTO;
import pe.edu.certus.persistence.essentials.converter.ForConvert;
import pe.edu.certus.persistence.projection.dao.ProjectionDAO;

@Component
public class ProjectionConvertersAdapter implements ForConvert<ProjectionDAO, ProjectionDTO> {

    @Override
    public ProjectionDAO convertToDao(ProjectionDTO dto) {
        return ProjectionDAO.builder()
                .date(dto.getDate())
                .time(dto.getTime())
                .build();

    }

    @Override
    public ProjectionDTO convertToDto(ProjectionDAO dao) {
        return ProjectionDTO.builder()
                .id(dao.getId())
                .date(dao.getDate())
                .time(dao.getTime())
                .movieId(dao.getMovieId())
                .build();
    }
}
