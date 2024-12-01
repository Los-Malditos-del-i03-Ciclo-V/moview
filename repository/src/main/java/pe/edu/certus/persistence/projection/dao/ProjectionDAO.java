package pe.edu.certus.persistence.projection.dao;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import pe.edu.certus.persistence.movie.dao.MovieDAO;

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
    @Basic(optional = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "projection_date")
    private LocalDate projectionDate;

    @Column(name = "projection_time")
    private LocalTime projectionTime;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "movie_id")
    private MovieDAO movie;
}
