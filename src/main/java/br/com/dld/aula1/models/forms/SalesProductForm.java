package br.com.dld.aula1.models.forms;

import br.com.dld.aula1.models.entities.Sales;
import br.com.dld.aula1.models.entities.SalesProduct;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SalesProductForm {

    private long sales;
    private long product;
    private Integer amount;

    private Double price;

    private Double value;

    public SalesProduct convert() {
        SalesProduct salesProduct = new SalesProduct();
        salesProduct.setAmount(amount);
        salesProduct.setPrice(price);
        salesProduct.setValue(value);

        return salesProduct;
    }
}
