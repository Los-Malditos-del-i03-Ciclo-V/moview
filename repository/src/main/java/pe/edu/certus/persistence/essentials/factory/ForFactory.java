package pe.edu.certus.persistence.essentials.factory;

public interface ForFactory <T, D>{

    T createAndSaveAnyDao(D dto);
    void createDefaultEntities();

}
