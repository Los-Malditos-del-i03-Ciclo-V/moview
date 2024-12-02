package pe.edu.certus.adapter.orden;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.certus.crud.ForCrudMethods;
import pe.edu.certus.model.order.dto.OrderDTO;
import pe.edu.certus.persistence.order.adapters.OrderConvertersAdapter;
import pe.edu.certus.persistence.order.dao.OrderDAO;
import pe.edu.certus.persistence.order.port.ForManagingOrder;

import java.util.List;

@Service
public class OrdenMethodsAdapter implements ForCrudMethods<OrderDTO, Integer> {

    @Autowired
    ForManagingOrder forManagingOrder;

    @Autowired
    OrderConvertersAdapter orderConvertersAdapter;


    @Override
    public OrderDTO createEntity(OrderDTO orderDTO) {
        OrderDAO orderDAO = orderConvertersAdapter.convertToDao(orderDTO);

        OrderDAO savedOrderDAO = forManagingOrder.save(orderDAO);

        return orderConvertersAdapter.convertToDto(savedOrderDAO);
    }

    @Override
    public OrderDTO findEntityById(Integer id) {
        OrderDAO orderDAO = forManagingOrder.findById(id).get();

        return orderConvertersAdapter.convertToDto(orderDAO);
    }

    @Override
    public List<OrderDTO> findAllEntities() {

        List<OrderDAO> orderDAOS = forManagingOrder.findAll();

        return orderDAOS.stream()
               .map(orderConvertersAdapter::convertToDto)
               .toList();

    }

    @Override
    public OrderDTO updateEntity(OrderDTO orderDTO) {

        if (!forManagingOrder.existsById(orderDTO.getId())){
            throw new RuntimeException("Orden con ID " + orderDTO.getId() + " no encontrada.");
        }

        OrderDAO orderDAO = orderConvertersAdapter.convertToDao(orderDTO);

        OrderDAO updatedOrderDAO = forManagingOrder.save(orderDAO);

        return orderConvertersAdapter.convertToDto(updatedOrderDAO);

    }

    @Override
    public void deleteEntityById(Integer id) {

        if (!forManagingOrder.existsById(id)){
            throw new RuntimeException("Orden con ID " + id + " no encontrada.");
        }

        forManagingOrder.deleteById(id);

    }


}
