package br.com.dld.aula1.models.forms;

import br.com.dld.aula1.models.entities.Category;
import br.com.dld.aula1.models.entities.Product;
import br.com.dld.aula1.models.enums.UN;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProductForm {

    private String name;
    private String unity;
    private Integer amount;
    private Double price;


    public Product convert() {
      Product product = new Product();
      product.setName(name);
      product.setUnity(unity);
      product.setAmount(amount);
      product.setPrice(price);

      return product;
    }



}
