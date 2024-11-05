//package net.entity.formato;
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
//public class Formato {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY) // ID autogenerate
//    @Basic( optional = false )
//    @Column(name= "id")
//    private Integer id;
//
//    @Column(name = "tipo")
//    private String tipo;
//
//    @OneToOne(mappedBy = "formato")
//    private Pelicula pelicula;
//
//}
