//package net.business.producto;
//
//import net.entity.producto.Producto;
//import net.persistence.crud.CrudMethods;
//import net.persistence.pelicula.PeliculaRepository;
//import net.persistence.producto.ProductoRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//
//import java.util.List;
//
//public class ProductoService implements CrudMethods<Producto, Integer> {
//    @Autowired
//    private ProductoRepository repository;
//
//    @Override
//    public Producto createObject(Producto producto) {
//        return repository.save(producto);
//    }
//
//    @Override
//    public Producto searchObjectById(Integer id) {
//        return repository.findById(id).get();
//    }
//
//    @Override
//    public List<Producto> searchAllObjects() {
//        return repository.findAll();
//    }
//
//    @Override
//    public Producto updateObject(Producto producto) {
//
//        Producto existingProducto = repository.findById(producto.getId()).get();
//        existingProducto.setNombre(producto.getNombre());
//        existingProducto.setDescripcion(producto.getDescripcion());
//        existingProducto.setPrecio(producto.getPrecio());
//        existingProducto.setCantidad(producto.getCantidad());
//        existingProducto.setImagen(producto.getImagen());
//
//        Producto updatedProducto = repository.save(existingProducto);
//        return updatedProducto;
//    }
//
//    @Override
//    public void deleteObjectById(Integer id) {
//        repository.deleteById(id);
//    }
//}
