//package net.entity.categoria;
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
//public class Categoria {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY) // ID autogenerate
//    @Basic( optional = false )
//    @Column(name = "id")
//    private Integer id;
//
//    @Column(name = "genero")
//    private String genero;
//
//    @OneToOne(mappedBy = "categoria")
//    private Pelicula pelicula;
//}
