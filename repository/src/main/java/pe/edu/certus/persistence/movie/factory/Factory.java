package pe.edu.certus.persistence.movie.factory;

public interface Factory <T, D>{

    T factoryToCreateEntity(D dto);
    void createDefaultEntities();
    void init();

}
