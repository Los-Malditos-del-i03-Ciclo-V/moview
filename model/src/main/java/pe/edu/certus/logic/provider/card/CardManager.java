package pe.edu.certus.logic.provider.card;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.certus.entities.card.CardEntity;
import pe.edu.certus.logic.contract.ForCrudMethods;
import pe.edu.certus.repository.card.ForManagingCard;

import java.util.List;

@Service
public class CardManager implements ForCrudMethods<CardEntity, Integer> {

    @Autowired
    ForManagingCard forManagingCard;

    @Override
    public CardEntity createEntity(CardEntity entity) {
        return forManagingCard.save(entity);
    }

    @Override
    public CardEntity findEntityById(Integer id) {
        return forManagingCard.findById(id).get();
    }

    @Override
    public List<CardEntity> findAllEntities() {
        return forManagingCard.findAll();
    }

    @Override
    public CardEntity updateEntity(CardEntity entity) {
        return forManagingCard.save(entity);
    }

    @Override
    public void deleteEntityById(Integer id) {
        forManagingCard.deleteById(id);
    }
}
