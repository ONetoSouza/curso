package br.com.dld.aula1.models.forms;

import br.com.dld.aula1.models.entities.Category;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CategoryForm {
    private String name;

    public Category convert() {
        Category category = new Category();
        category.setName(name);

        return category;
    }
}
