package pe.edu.certus.persistence.projection.dao;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import pe.edu.certus.persistence.movie.dao.MovieDAO;

import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "projection")
public class ProjectionDAO {

    @Id
    @Column(name = "id")
    @Basic( optional = false )
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private LocalDate projectionDate;
    private LocalTime projectionTime;

<<<<<<< Updated upstream
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_movie_id", referencedColumnName = "id")
=======
    @ManyToOne
    @JoinColumn(name = "movie_id")
>>>>>>> Stashed changes
    private MovieDAO movie;

}
