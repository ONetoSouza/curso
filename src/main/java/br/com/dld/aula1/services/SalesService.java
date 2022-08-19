package br.com.dld.aula1.services;

import br.com.dld.aula1.models.entities.Customer;
import br.com.dld.aula1.models.entities.Sales;
import br.com.dld.aula1.models.entities.SalesProduct;
import br.com.dld.aula1.models.forms.SalesForm;
import br.com.dld.aula1.models.forms.SalesProductForm;
import br.com.dld.aula1.repositories.CustomerRepository;
import br.com.dld.aula1.repositories.SalesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.Optional;

@Service
public class SalesService {

    @Autowired
    private SalesRepository salesRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private SalesProductService  salesProductService;

    public Optional<Sales> findById(long id) {
        return salesRepository.findById(id);
    }

//    public List<Sales> findAllByName(String name) {
//        return salesRepository.findAllByNameContains(name);
//
//
//    }

    @PostMapping
    public Sales save(SalesForm salesForm) throws Exception {
        Optional<Customer> customer = customerRepository.findById(salesForm.getCustomer());
        if (!customer.isPresent()){
            throw new Exception();
        }
        Sales sales = new Sales();
        sales.setCustomer(customer.get());

        salesRepository.saveAndFlush(sales);

        for(SalesProductForm salesProduct: salesForm.getProducts()){
            salesProduct.setSales(sales.getId());
            salesProductService.save(salesProduct);
        }
        return sales;
    }

    public void delete(long id) {
        salesRepository.deleteById(id);
    }
}
