package br.com.dld.aula1.models.forms;

import br.com.dld.aula1.models.entities.Product;
import br.com.dld.aula1.models.enums.UN;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import javax.persistence.*;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProductForm {

    private String name;
    private UN unity;
    private Float preco;
    private int quantidade;

    public Product convert() {
      Product product = new Product();
      product.setName(name);
      product.setUnity(unity);
      product.setPreco(preco);
      product.setQuantidade(quantidade);


      return product;
    }
}
