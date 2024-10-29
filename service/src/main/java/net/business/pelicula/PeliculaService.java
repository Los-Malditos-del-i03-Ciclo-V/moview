package net.business.pelicula;


import net.entity.pelicula.Pelicula;
import net.persistence.crud.CrudMethods;
import net.persistence.pelicula.PeliculaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import javax.management.RuntimeOperationsException;

/**
 * <strong>Servicio de Película</strong>
 * <br>
 * Esta clase define los servicios relacionados con las películas.
 * Un servicio en Spring es una clase que contiene la lógica de negocio de la
 * aplicación.
 * En este caso, el servicio de películas se encarga de realizar operaciones
 * relacionadas
 * con las películas, como buscar, crear, actualizar y eliminar películas.
 * <br>
 * <br>
 * <strong>Anotación @Service</strong>
 * <br>
 * Indica que esta clase es un componente de Spring y que proporciona servicios
 * relacionados con la lógica de negocio. Spring escanea las clases anotadas con
 * `@Service` para encontrar los métodos que implementan las funcionalidades del
 * sistema.
 */
@Service
public class PeliculaService implements CrudMethods<Pelicula, Integer> {

    @Autowired
    private PeliculaRepository repository;

    /**
     * Esta función crea una nueva película en la base de datos.
     *
     * @param pelicula El objeto película que se va a crear. Debe contener toda la
     *                 información necesaria como título, director, fecha de
     *                 estreno, etc.
     * @return El objeto película recién creado con su identificador único (id)
     *         asignado por la base de datos.
     *
     */


    @Override
    public Pelicula createObject(Pelicula pelicula) {
        return repository.save(pelicula);
    }

    /**
     * Esta función obtiene todas las peliculas desde la base de datos.
     *
     * @return Una lista de todos los objetos de película en la base de datos.
     *         Cada película es representado por un objeto {@link Pelicula}
     *
     */
    @Override
    public List<Pelicula> searchAllObjects() {
        return repository.findAll();
    }

    /**
     * Esta función obtiene una pelicula por su identificador único (id) de la base
     * de datos.
     *
     * @param id El identificador único de la película que se quiere obtener.
     * @return El objeto película correspondiente al identificador proporcionado.
     *
     */

    @Override
    public Pelicula searchObjectById(Integer id) {
        return repository.findById(id).get();
    }

    /**
     * Esta función actualiza una película de la base de datos por su identificador
     * único
     *
     * @param updateMovie Es el objeto película a ser actualizado. Debe contener toda
     *                 la
     *                 información necesaria de película como título, duración,
     *                 clasificación, etc.
     * @return El objeto película ya actualizado con ayuda de su único
     *         identificador.
     *         <br>
     *         La función realiza los siguientes pasos:
     *         <ol>
     *         <li>
     *         Obtiene la película desde la base de datos usando el identificador
     *         del objeto.
     *         </li>
     *         <li>
     *         Se actualiza los atributos del objeto película con los atributos de
     *         película obtenido.
     *         </li>
     *         <li>
     *         Guarda la película actualizada en la base de datos MySQL.
     *         </li>
     *         <li>
     *         Devuelve el objeto película actualizado.
     *         </li>
     *         </ol>
     */
    @Override
    public Pelicula updateObject(Pelicula updateMovie) {
        Pelicula existingMovie = repository.findById(updateMovie.getId()).get();

        existingMovie.setId(existingMovie.getId());
        existingMovie.setTitulo(existingMovie.getTitulo());
        existingMovie.setDuracion(existingMovie.getDuracion());
        existingMovie.setClasificacion(existingMovie.getClasificacion());
        existingMovie.setIdioma(existingMovie.getIdioma());
        existingMovie.setCategoria(existingMovie.getCategoria());
        existingMovie.setFormato(existingMovie.getFormato());
        existingMovie.setTrama(existingMovie.getTrama());
        existingMovie.setDirector(existingMovie.getDirector());

        Pelicula updatedMovie = repository.save(updateMovie);
        return updatedMovie;
    }

    /**
     * Esta función elimina una pelicula de la base de datos por su identificador
     * único
     *
     * @param id El identificador único de la película que se quiere eliminar.
     *
     *
     */
    @Override
    public void deleteObjectById(Integer id) {
        repository.deleteById(id);
    }
}
