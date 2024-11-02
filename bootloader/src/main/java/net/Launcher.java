package net;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Clase principal de la aplicación Moview.
 * <p>
 * Inicia la aplicación Spring Boot para el trabajo de la renegona.
 * </p>
 *
 * @author Moview Company
 * @version 1.0.3
 * @since 2024
 */
@SpringBootApplication
public class Launcher {

    /**
     * Método principal que inicia la aplicación Moview.
     * <p>
     *     Este método ejecuta el servidor y permite acceder a las funcionalidades (Peliculas).
     * </p>
     * <p>
     *     Para revisar el servidor, dirígete al siguiente enlace:
     *     <a href="http://localhost:8001/home">Moview - Peliculas</a>.
     * </p>
     *
     * @param args
     * Este método inicia la aplicación. No necesitas pasar instrucciones a menos que quieras
     *             realizar mejoras de rendimiento.
     */
    public static void main(String[] args) {
        SpringApplication.run(Launcher.class, args);
    }
}