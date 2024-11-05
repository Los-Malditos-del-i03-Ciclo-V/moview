//package net.entity.idioma;
//
//import jakarta.persistence.*;
//import lombok.AllArgsConstructor;
//import lombok.Builder;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//import net.entity.pelicula.Pelicula;
//
//@Data
//@NoArgsConstructor
//@AllArgsConstructor
//@Builder
//
//@Entity
//public class Idioma {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY) // ID autogenerate
//    @Basic( optional = false )
//    @Column(name = "id")
//    private Integer id;
//
//    @Column(name = "lenguaje")
//    private String lenguaje;
//
//    @OneToOne(mappedBy = "idioma")
//    private Pelicula pelicula;
//
//
//}
