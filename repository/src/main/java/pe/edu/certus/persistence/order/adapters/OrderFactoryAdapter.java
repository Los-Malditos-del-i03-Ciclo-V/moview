package pe.edu.certus.persistence.order.adapters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pe.edu.certus.model.order.dto.OrderDTO;
import pe.edu.certus.persistence.essentials.factory.ForFactory;
import pe.edu.certus.persistence.order.dao.OrderDAO;
import pe.edu.certus.persistence.order.port.ForManagingOrder;

@Component
public class OrderFactoryAdapter implements ForFactory<OrderDAO, OrderDTO> {

    @Autowired
    ForManagingOrder forManagingOrder;

    @Autowired
    OrderConvertersAdapter forOrderConvertersAdapter;
    @Override
    public OrderDAO createAndSaveAnyDao(OrderDTO dto) {
        return forManagingOrder.save(forOrderConvertersAdapter.convertToDao(dto));
    }

    @Override
    public void createDefaultEntities() {
        createAndSaveAnyDao(OrderDTO.builder().build());
    }
}
