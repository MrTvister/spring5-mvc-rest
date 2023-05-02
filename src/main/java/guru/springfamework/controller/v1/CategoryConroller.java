package guru.springfamework.controller.v1;

import guru.springfamework.api.v1.model.CategoiesListDTO;
import guru.springfamework.api.v1.model.CategoryDTO;
import guru.springfamework.services.CategoryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/api/v1/categories")
public class CategoryConroller {
    private final CategoryService categoryService;


    public CategoryConroller(guru.springfamework.services.CategoryService categoryService) {
        this.categoryService = categoryService;
    }
    @GetMapping
    public ResponseEntity<CategoiesListDTO> getAllCategories() {
        return new ResponseEntity<CategoiesListDTO>(
                new CategoiesListDTO(categoryService.getAllCategories()), HttpStatus.OK);
    }

    @GetMapping("/{name}")
    public ResponseEntity<CategoryDTO> getByCategoryName(@PathVariable String name) {
        return new ResponseEntity<CategoryDTO>(categoryService.getCategoryByName(name), HttpStatus.OK);
    }
}
