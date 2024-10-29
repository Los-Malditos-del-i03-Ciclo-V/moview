package net.entity.pelicula;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor


@SuppressWarnings("serial")
@Table(name = "pelicula")
@NamedQueries({
        @NamedQuery(name = "Pelicula.findAll", query = "SELECT p FROM Pelicula p"),
        @NamedQuery(name = "Pelicula.findById", query = "SELECT p FROM Pelicula p WHERE p.id = :id"),
        @NamedQuery(name = "Pelicula.findByTitulo", query = "SELECT p FROM Pelicula p WHERE p.titulo = :titulo"),
        @NamedQuery(name = "Pelicula.findByDuracion", query = "SELECT p FROM Pelicula p WHERE p.duracion = :duracion"),
        @NamedQuery(name = "Pelicula.findByClasificacion", query = "SELECT p FROM Pelicula p WHERE p.clasificacion = :clasificacion"),
        @NamedQuery(name = "Pelicula.findByIdioma", query = "SELECT p FROM Pelicula p WHERE p.idioma = :idioma"),
        @NamedQuery(name = "Pelicula.findByCategoria", query = "SELECT p FROM Pelicula p WHERE p.categoria = :categoria"),
        @NamedQuery(name = "Pelicula.findByFormato", query = "SELECT p FROM Pelicula p WHERE p.formato = :formato"),
        @NamedQuery(name = "Pelicula.findByTrama", query = "SELECT p FROM Pelicula p WHERE p.trama = :trama"),
        @NamedQuery(name = "Pelicula.findByDirector", query = "SELECT p FROM Pelicula p WHERE p.director = :director")
})

@Entity
public class Pelicula {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // ID autogenerate
    @Basic( optional = false ) // Required field
    @Column( name = "id")
    Integer id;

    @Column( name = "titulo" )
    String titulo;

    @Column( name = "duracion" )
    Integer duracion;

    @Column( name = "clasificacion" )
    String clasificacion;

    @Column( name = "idioma" )
    String idioma;

    @Column( name = "categoria" )
    String categoria;

    @Column( name = "formato" )
    String formato;

    @Column( name = "trama" )
    String trama;

    @Column( name = "director" )
    String director;

    @Column( name = "imagen" )
    String imagen;
}
