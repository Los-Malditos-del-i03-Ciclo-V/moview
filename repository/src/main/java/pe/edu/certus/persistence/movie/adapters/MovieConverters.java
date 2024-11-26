package pe.edu.certus.persistence.movie.adapters;

import org.springframework.stereotype.Component;
import pe.edu.certus.model.movie.dto.MovieDTO;
import pe.edu.certus.persistence.movie.dao.MovieDAO;
import pe.edu.certus.persistence.movie.port.converter.ForConvert;

@Component
public class MovieConverters implements ForConvert<MovieDAO, MovieDTO> {
    @Override
    public MovieDAO convertToDao(MovieDTO dto) {
        return MovieDAO.builder()
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
                .build();
    }

    @Override
    public MovieDTO convertToDto(MovieDAO dao) {
        return MovieDTO.builder()
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
                .build();
    }
}
