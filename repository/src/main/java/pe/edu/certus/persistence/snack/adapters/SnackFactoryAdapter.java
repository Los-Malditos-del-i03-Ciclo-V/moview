package pe.edu.certus.persistence.snack.adapters;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pe.edu.certus.model.snack.dto.SnackDTO;
import pe.edu.certus.persistence.essentials.factory.ForFactory;
import pe.edu.certus.persistence.snack.dao.SnackDAO;
import pe.edu.certus.persistence.snack.port.ForManagingSnack;

@Component
public class SnackFactoryAdapter implements ForFactory<SnackDAO, SnackDTO> {

    @Autowired
    ForManagingSnack forManagingSnack;

    @Autowired
    SnackConvertersAdapter forSnackConvertersAdapter;


    @Override
    public SnackDAO createAndSaveAnyDao(SnackDTO snackDTO) {
        SnackDAO snackDAO = forSnackConvertersAdapter.convertToDao(snackDTO);
        return forManagingSnack.save(snackDAO);
    }

    @PostConstruct
    public void init() {
        if (forManagingSnack.count() == 0) {
            createDefaultEntities();
        }
    }
    @Override
    public void createDefaultEntities() {
        createAndSaveAnyDao(SnackDTO.builder()
                .name("Chocolate")
                .description("Chocolate is a sweet, creamy, and slightly bitter confectionery product composed of milk, sugar, and cocoa butter.")
                .image("pelicula-1.png")
                .price("1.00")
                .quantity(1)
                .category("Snack")
                .build());
        createAndSaveAnyDao(SnackDTO.builder()
                .name("Chips")
                .description("Chips are a snack food made from a mixture of potatoes, flour, salt, and fat, and typically served with dipping sauces.")
                .image("pelicula-2.png")
                .price("1.00")
                .quantity(1)
                .category("Snack")
                .build());
        createAndSaveAnyDao(SnackDTO.builder()
                .name("Cookies")
                .description("Cookies are small, flat, and round cakes that are usually made of flour, sugar, eggs, and butter.")
                .image("pelicula-3.png")
                .price("1.00")
                .quantity(1)
                .category("Snack")
                .build());
        createAndSaveAnyDao(SnackDTO.builder()
                .name("Donuts")
                .description("Donuts are a type of sweet, fried doughnut that is typically served as a dessert.")
                .image("pelicula-4.png")
                .price("1.00")
                .quantity(1)
                .category("Snack")
                .build());
        createAndSaveAnyDao(SnackDTO.builder()
                .name("Ice Cream")
                .description("Ice cream is a frozen dessert that is typically flavored with fruit, cream, and sugar.")
                .image("pelicula-5.png")
                .price("1.00")
                .quantity(1)
                .category("Snack")
                .build());
        createAndSaveAnyDao(SnackDTO.builder()
                .name("Pizza")
                .description("Pizza is a dish of Italian origin that typically consists of a base of leavened wheat-based dough, topped with tomato sauce, cheese, and various toppings.")
                .image("pelicula-6.png")
                .price("1.00")
                .quantity(1)
                .category("Snack")
                .build());
        createAndSaveAnyDao(SnackDTO.builder()
                .name("Popcorn")
                .description("Popcorn is a snack food that is typically made from popcorn kernels, oil, and spices.")
                .image("pelicula-7.png")
                .price("1.00")
                .quantity(1)
                .category("Snack")
                .build());
        createAndSaveAnyDao(SnackDTO.builder()
                .name("Potato Chips")
                .description("Potato chips are a snack food made from potatoes, flour, salt, and fat, and typically served with dipping sauces.")
                .image("pelicula-8.png")
                .price("1.00")
                .quantity(1)
                .category("Snack")
                .build());
        createAndSaveAnyDao(SnackDTO.builder()
                .name("Pretzels")
                .description("Pretzels are a type of snack food that is typically made from a mixture of flour, sugar, and salt.")
                .image("pelicula-9.png")
                .price("1.00")
                .quantity(1)
                .category("Snack")
                .build());
        createAndSaveAnyDao(SnackDTO.builder()
                .name("Sandwich")
                .description("Sandwich is a type of food that is typically made from a combination of bread, meat, cheese, and condiments.")
                .image("pelicula-10.png")
                .price("1.00")
                .quantity(1)
                .category("Snack")
                .build());
    }
}
