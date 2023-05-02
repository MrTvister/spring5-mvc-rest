package guru.springfamework.api.v1.model;

import java.util.List;

@lombok.Data
@lombok.AllArgsConstructor
public class CategoiesListDTO {
    List<CategoryDTO> categories;
}
