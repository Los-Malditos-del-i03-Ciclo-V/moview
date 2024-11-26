package pe.edu.certus.persistence.movie.port.converter;

public interface ForConvert <E, P>{

    E convertToDao(P dto);
    P convertToDto(E dao);

}
