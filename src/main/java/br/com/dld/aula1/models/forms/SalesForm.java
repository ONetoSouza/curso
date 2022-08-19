package br.com.dld.aula1.models.forms;

import br.com.dld.aula1.models.entities.Sales;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SalesForm {

 private long customer;
 private List<SalesProductForm> products = new ArrayList<>();


}
