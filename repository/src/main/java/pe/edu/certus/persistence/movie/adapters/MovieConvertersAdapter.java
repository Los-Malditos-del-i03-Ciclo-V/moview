package pe.edu.certus.persistence.movie.adapters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pe.edu.certus.model.movie.dto.MovieDTO;
import pe.edu.certus.persistence.movie.dao.MovieDAO;
import pe.edu.certus.persistence.essentials.converter.ForConvert;
import pe.edu.certus.persistence.projection.adapters.ProjectionConvertersAdapter;

import java.util.ArrayList;
import java.util.stream.Collectors;

@Component
public class MovieConvertersAdapter implements ForConvert<MovieDAO, MovieDTO> {
    
    @Autowired
    private ProjectionConvertersAdapter projectionConvertersAdapter;

    @Override
    public MovieDAO convertToDao(MovieDTO dto) {
        MovieDAO movieDAO = MovieDAO.builder()
                .id(dto.getId())
                .title(dto.getTitle())
                .director(dto.getDirector())
                .synopsis(dto.getSynopsis())
                .image(dto.getImage())
                .duration(dto.getDuration())
                .description(dto.getDescription())
                .clasification(dto.getClasification())
                .language(dto.getLanguage())
                .category(dto.getCategory())
                .format(dto.getFormat())
                .projections(new ArrayList<>())
                .build();
        return movieDAO;
    }

    @Override
    public MovieDTO convertToDto(MovieDAO dao) {
        return MovieDTO.builder()
                .id(dao.getId())
                .title(dao.getTitle())
                .director(dao.getDirector())
                .synopsis(dao.getSynopsis())
                .image(dao.getImage())
                .duration(dao.getDuration())
                .description(dao.getDescription())
                .clasification(dao.getClasification())
                .language(dao.getLanguage())
                .category(dao.getCategory())
                .format(dao.getFormat())
                .projections(dao.getProjections() != null ? 
                    dao.getProjections().stream()
                        .map(projectionConvertersAdapter::convertToDto)
                        .collect(Collectors.toList()) : 
                    new ArrayList<>())
                .build();
    }
}
