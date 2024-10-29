package net.entity.pelicula.factory;

import net.entity.pelicula.Pelicula;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class PeliculaFactory {
    public static List<Pelicula> listaDePeliculas = new ArrayList<>();

    static SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");

    public static void crearPelicula(int id,
                                    String titulo,
                                    Integer duracion,
                                    String clasificacion,
                                    String idioma,
                                    String categoria,
                                    String formato,
                                    String trama,
                                    String director,
                                    String imagen) {
        try {

            Pelicula pelicula = Pelicula.builder()
                    .id(id)
                    .titulo(titulo)
                    .duracion(duracion)
                    .clasificacion(clasificacion)
                    .idioma(idioma)
                    .categoria(categoria)
                    .formato(formato)
                    .trama(trama)
                    .director(director)
                    .imagen(imagen)
                    .build();

            listaDePeliculas.add(pelicula);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

//    static {
//        crearPelicula(
//                11,
//                "Titanic",
//                1997,
//                "Drama",
//                "Inglés",
//                "Drama",
//                "DVD",
//                "Una historia de amor y desafío en el mar",
//                "Christopher Nolan",
//                "pelicula-1.png"
//        );
//        crearPelicula(
//                12,
//                "Avengers: Endgame",
//                2019,
//                "Acción",
//                "Inglés",
//                "Acción",
//                "Blu-ray",
//                "Una historia de superhéroes que se une para salvar al mundo",
//                "Christopher Nolan",
//                "pelicula-2.png"
//        );
//        crearPelicula(
//                13,
//                "Joker",
//                2019,
//                "Drama",
//                "Inglés",
//                "Drama",
//                "DVD",
//                "Una historia de un joker que se enfrenta a su propio destino",
//                "Christopher Nolan",
//                "pelicula-3.png"
//        );
//        crearPelicula(
//                14,
//                "La La Land",
//                2016,
//                "Drama",
//                "Inglés",
//                "Drama",
//                "DVD",
//                "Una historia de un marido y una mujer que se enfrentan a su propio destino",
//                "Christopher Nolan",
//                "pelicula-4.png"
//        );
//    }
}
