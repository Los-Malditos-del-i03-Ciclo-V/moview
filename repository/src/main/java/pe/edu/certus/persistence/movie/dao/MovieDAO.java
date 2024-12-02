package pe.edu.certus.persistence.movie.dao;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import pe.edu.certus.persistence.projection.dao.ProjectionDAO;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "movie")
public class
MovieDAO {

    @Id
    @Column(name = "id")
    @Basic(optional = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "title")
    private String title;

    @Column(name = "director")
    private String director;

    @Column(name = "synopsis")
    private String synopsis;

    @Column(name = "image")
    private String image;

    @Column(name = "duration")
    private String duration;

    @Column(name = "description")
    private String description;

    @Column(name = "clasification")
    private String clasification;

    @Column(name = "language")
    private String language;

    @Column(name = "category")
    private String category;

    @Column(name = "format")
    private String format;

    @OneToMany(mappedBy = "movie", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<ProjectionDAO> projections;
}
