package com.example.moview.service;

import com.example.moview.models.Pelicula;
import com.example.moview.repository.PeliculaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PeliculaService {

    @Autowired
    private PeliculaRepository peliculaRepository;
    /**
     * Esta función crea una nueva película en la base de datos.
     *
     * @param pelicula El objeto película que se va a crear. Debe contener toda la información necesaria como título, director, fecha de estreno, etc.
     * @return El objeto película recién creado con su identificador único (id) asignado por la base de datos.
     *
     */

    // ==== Function to create a movie (CREATE) ==== //
    public Pelicula crearPelicula( Pelicula pelicula ){
        return peliculaRepository.save( pelicula );
    }

    /**
     * Esta función obtiene todas las peliculas desde la base de datos.
     * @return Una lista de todos los objetos de película en la base de datos.
     * Cada película es representado por un objeto {@link Pelicula}
     *
     */
    // ==== Function to get all movies (READ) ==== //
        public List<Pelicula> buscarPeliculas() {
        return( List<Pelicula> ) peliculaRepository.findAll();
    }

    /**
     * Esta función obtiene una pelicula por su identificador único (id) de la base de datos.
     * @param id El identificador único de la película que se quiere obtener.
     * @return El objeto película correspondiente al identificador proporcionado.
     *
     */

    // ==== Function to get a movie by id(READ) ==== //
    public Pelicula buscarPeliculaPorId( Integer id ) {
        return peliculaRepository.findById( id ).get();
    }
    /**
     * Esta función actualiza una pelica de la base de datos por su identificador único
     * @param pelicula Es el objeto película a ser actualizado. Debe contener toda la
     * información necesaria de película como título, duración, clasificación, etc.
     * @return El objeto película ya actualizado con ayuda de su único identificador.
     *  <br>
     * La función realiza los siguientes pasos:
     * <ol>
     *     <li>
     *         Obtiene la película desde la base de datos usando el identificador del objeto.
     *     </li>
     *     <li>
     *         Se actualiza los atributos del objeto película con los atributos de película obtenido.
     *     </li>
     *     <li>
     *         Guarda la película actualizada en la base de datos MySQL.
     *     </li>
     *     <li>
     *         Devuelve el objeto película actualizado.
     *     </li>
     * </ol>
     */
    // ==== Function to update a movie by id (UPDATE) ==== //
    public Pelicula actualizarPelicula ( Pelicula pelicula ){
        Pelicula peliculaSeleccionada = peliculaRepository.findById(pelicula.getId()).get();

        peliculaSeleccionada.setId(peliculaSeleccionada.getId());
        peliculaSeleccionada.setTitulo(pelicula.getTitulo());
        peliculaSeleccionada.setDuracion(pelicula.getDuracion());
        peliculaSeleccionada.setClasificacion(pelicula.getClasificacion());
        peliculaSeleccionada.setIdioma(pelicula.getIdioma());
        peliculaSeleccionada.setCategoria(pelicula.getCategoria());
        peliculaSeleccionada.setFormato(pelicula.getFormato());
        peliculaSeleccionada.setTrama(pelicula.getTrama());
        peliculaSeleccionada.setDirector(pelicula.getDirector());

        Pelicula peliculaActualizada = peliculaRepository.save(pelicula);
        return peliculaActualizada;
    }

    /**
     * Esta función elimina una pelicula de la base de datos por su identificador único
     * @param id El identificador único de la película que se quiere eliminar.
     *
     *
     */
    // ==== Function to delete a movie by id (DELETE) ==== //
    public void eliminarPeliculaPorId( Integer id ){
        peliculaRepository.deleteById(id);
    }
}
