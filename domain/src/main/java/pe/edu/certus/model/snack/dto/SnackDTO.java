package pe.edu.certus.model.snack.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SnackDTO {

    private Integer id;
    private String name;
    private String description;
    private String image;
    private String price;
    private Integer quantity;
    private String category;

}