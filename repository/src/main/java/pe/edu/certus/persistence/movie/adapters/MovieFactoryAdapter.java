package pe.edu.certus.persistence.movie.adapters;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pe.edu.certus.model.movie.dto.MovieDTO;
import pe.edu.certus.persistence.essentials.factory.ForFactory;
import pe.edu.certus.persistence.movie.dao.MovieDAO;
import pe.edu.certus.persistence.movie.port.jpa.ForManagingMovie;

@Component
public class MovieFactoryAdapter implements ForFactory<MovieDAO, MovieDTO> {

    @Autowired
    ForManagingMovie forManagingMovie;

    @Autowired
    MovieConvertersAdapter forMovieConvertersAdapter;
    @Override
    public MovieDAO createAndSaveAnyDao(MovieDTO movieDTO) {
        MovieDAO movieDAO = forMovieConvertersAdapter.convertToDao(movieDTO);
        return forManagingMovie.save(movieDAO);
    }

    @PostConstruct
    public void init() {
        if (forManagingMovie.count() == 0) {
            createDefaultEntities();
        }
    }

    @Override
    public void createDefaultEntities() {
        createAndSaveAnyDao(MovieDTO.builder()
                .title("El Señor de los Anillos: La Comunidad del Anillo")
                .director("Peter Jackson")
                .synopsis("Una épica aventura en la Tierra Media...")
                .image("pelicula-1.png")
                .duration("178")
                .description("Una épica aventura en la Tierra Media...")
                .clasification("PG-13")
                .language("Inglés")
                .category("Fantasía")
                .format("HD")
                .build());
        createAndSaveAnyDao(MovieDTO.builder()
                .title("Amores Perros")
                .director("Alejandro González Iñárritu")
                .synopsis("Tres historias entrelazadas...")
                .image("pelicula-2.png")
                .duration("154")
                .description("Tres historias entrelazadas...")
                .clasification("R")
                .language("Español")
                .category("Drama")
                .format("3D")
                .build());
        createAndSaveAnyDao(MovieDTO.builder()
                .title("El Laberinto del Fauno")
                .director("Guillermo del Toro")
                .synopsis("Una niña en la Guerra Civil Española...")
                .image("pelicula-3.png")
                .duration("118")
                .description("Una niña en la Guerra Civil Española...")
                .clasification("PG-13")
                .language("Español")
                .category("Fantasía")
                .format("HD")
                .build());
        createAndSaveAnyDao(MovieDTO.builder()
                .title("El Padrino")
                .director("Francis Ford Coppola")
                .synopsis("Una saga familiar mafiosa...")
                .image("pelicula-4.png")
                .duration("175")
                .description("Una saga familiar mafiosa...")
                .clasification("R")
                .language("Inglés")
                .category("Crimen")
                .format("HD")
                .build());
        createAndSaveAnyDao(MovieDTO.builder()
                .title("Volver al Futuro")
                .director("Robert Zemeckis")
                .synopsis("Viajes en el tiempo...")
                .image("pelicula-5.png")
                .duration("108")
                .description("Viajes en el tiempo...")
                .clasification("PG")
                .language("Inglés")
                .category("Ciencia Ficción")
                .format("HD")
                .build());
        createAndSaveAnyDao(MovieDTO.builder()
                .title("La Vida es Bella")
                .director("Roberto Benigni")
                .synopsis("Un padre protege a su hijo en el Holocausto...")
                .image("pelicula-6.png")
                .duration("124")
                .description("Un padre protege a su hijo en el Holocausto...")
                .clasification("PG-13")
                .language("Italiano")
                .category("Drama")
                .format("HD")
                .build());
        createAndSaveAnyDao(MovieDTO.builder()
                .title("El Pianista")
                .director("Roman Polanski")
                .synopsis("Un pianista polaco en el gueto de Varsovia...")
                .image("pelicula-7.png")
                .duration("150")
                .description("Un pianista polaco en el gueto de Varsovia...")
                .clasification("R")
                .language("Inglés")
                .category("Drama")
                .format("HD")
                .build());
        createAndSaveAnyDao(MovieDTO.builder()
                .title("El Gran Dictador")
                .director("Charles Chaplin")
                .synopsis("Una sátira sobre el fascismo...")
                .image("pelicula-8.png")
                .duration("125")
                .description("Una sátira sobre el fascismo...")
                .clasification("PG")
                .language("Inglés")
                .category("Comedia")
                .format("HD")
                .build());
        createAndSaveAnyDao(MovieDTO.builder()
                .title("Ciudad de Dios")
                .director("Fernando Meirelles, Kátia Lund")
                .synopsis("La vida en las favelas de Río...")
                .image("pelicula-9.png")
                .duration("106")
                .description("La vida en las favelas de Río...")
                .clasification("R")
                .language("Portugués")
                .category("Drama")
                .format("HD")
                .build());
        createAndSaveAnyDao(MovieDTO.builder()
                .title("Parasite")
                .director("Bong Joon-ho")
                .synopsis("Una familia pobre se infiltra en una rica...")
                .image("pelicula-10.png")
                .duration("132")
                .description("Una familia pobre se infiltra en una rica...")
                .clasification("R")
                .language("Coreano")
                .category("Thriller")
                .format("HD")
                .build());

    }
}
