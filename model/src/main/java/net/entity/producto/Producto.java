package net.entity.producto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Producto {

    private Integer id;
    private String nombre;
    private String descripcion;
    private Double precio;
    private Integer cantidad;
    private String imagen;

}
