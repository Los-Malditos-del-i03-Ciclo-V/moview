package pe.edu.certus.persistence.movie.dao;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "movie")
public class MovieDAO {

    @Id
    @Column(name = "id")
    @Basic( optional = false )
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

<<<<<<< Updated upstream
=======
    @OneToMany(cascade = CascadeType.PERSIST, mappedBy = "movie", fetch = FetchType.LAZY)
    private List<ProjectionDAO> projections;
>>>>>>> Stashed changes
}
