package pe.edu.certus.persistence.essentials.converter;

public interface ForConvert <E, P>{

    E convertToDao(P dto);
    P convertToDto(E dao);

}
