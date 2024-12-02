package pe.edu.certus.adapter.snack;

import org.springframework.beans.factory.annotation.Autowired;
import pe.edu.certus.crud.ForCrudMethods;
import pe.edu.certus.model.snack.dto.SnackDTO;
import pe.edu.certus.persistence.snack.adapters.SnackConvertersAdapter;
import pe.edu.certus.persistence.snack.dao.SnackDAO;
import pe.edu.certus.persistence.snack.port.ForManagingSnack;

import java.util.List;

public class SnackMethodsAdapter implements ForCrudMethods<SnackDTO, Integer> {

    @Autowired
    ForManagingSnack forManagingSnack;

    @Autowired
    SnackConvertersAdapter snackConvertersAdapter;

    @Override
    public SnackDTO createEntity(SnackDTO snackDTO) {
        SnackDAO snackDAO = snackConvertersAdapter.convertToDao(snackDTO);

        SnackDAO savedSnackDAO = forManagingSnack.save(snackDAO);

        return snackConvertersAdapter.convertToDto(savedSnackDAO);
    }

    @Override
    public SnackDTO findEntityById(Integer id) {
        SnackDAO snackDAO = forManagingSnack.findById(id).get();

        return snackConvertersAdapter.convertToDto(snackDAO);
    }

    @Override
    public List<SnackDTO> findAllEntities() {
        List<SnackDAO> snackDAOS = forManagingSnack.findAll();

        return snackDAOS.stream()
               .map(snackConvertersAdapter::convertToDto)
               .toList();
    }

    @Override
    public SnackDTO updateEntity(SnackDTO snackDTO) {
        if(!forManagingSnack.existsById(snackDTO.getId())){
            throw new RuntimeException("Snack con ID " + snackDTO.getId() + " no encontrado.");
        }

        SnackDAO snackDAO = snackConvertersAdapter.convertToDao(snackDTO);

        SnackDAO updatedSnackDAO = forManagingSnack.save(snackDAO);

        return snackConvertersAdapter.convertToDto(updatedSnackDAO);
    }

    @Override
    public void deleteEntityById(Integer id) {

        if(!forManagingSnack.existsById(id)){
            throw new RuntimeException("Snack con ID " + id + " no encontrado.");
        }

        forManagingSnack.deleteById(id);

    }
}
