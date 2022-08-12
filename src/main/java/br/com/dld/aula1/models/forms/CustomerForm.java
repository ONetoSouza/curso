package br.com.dld.aula1.models.forms;

import br.com.dld.aula1.models.entities.Customer;
import br.com.dld.aula1.models.enums.UF;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

/**
 * @author David Duarte
 * @created 09/08/2022
 * @project aula-1
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CustomerForm {

    private String name;
    private Long cpf;
    private Long rg;
    private Integer zipCode;
    private String district;
    private String publicPlace;
    private String number;
    private String complement;
    private String city;
    private UF state;

    public Customer convert() {
        Customer customer = new Customer();
        customer.setName(name);
        customer.setCpf(cpf);
        customer.setRg(rg);
        customer.setZipCode(zipCode);
        customer.setDistrict(district);
        customer.setPublicPlace(publicPlace);
        customer.setNumber(number);
        customer.setComplement(complement);
        customer.setCity(city);
        customer.setState(state);

        return customer;
    }
}
