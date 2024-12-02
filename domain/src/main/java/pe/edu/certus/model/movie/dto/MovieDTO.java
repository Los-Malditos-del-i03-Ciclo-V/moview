package pe.edu.certus.model.movie.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MovieDTO {

    private Integer id;
    private String title;
    private String director;
    private String synopsis;
    private String image;
    private String duration;
    private String description;
    private String clasification;
    private String language;
    private String category;
    private String format;

}