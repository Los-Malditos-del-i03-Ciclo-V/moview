package pe.edu.certus.crud;

import java.util.List;

public interface ForCrudMethods<T,ID>{

    T createEntity (T entity);

    T findEntityById (ID id);

    List<T> findAllEntities();

    T updateEntity(T entity);

    void deleteEntityById(ID id);

}
