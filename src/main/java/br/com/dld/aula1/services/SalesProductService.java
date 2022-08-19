package br.com.dld.aula1.services;


import br.com.dld.aula1.models.entities.Product;
import br.com.dld.aula1.models.entities.Sales;
import br.com.dld.aula1.models.entities.SalesProduct;
import br.com.dld.aula1.models.forms.SalesProductForm;
import br.com.dld.aula1.repositories.ProductRepository;
import br.com.dld.aula1.repositories.SalesProductRepository;
import br.com.dld.aula1.repositories.SalesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SalesProductService {

    @Autowired
    private SalesProductRepository salesProductRepository;
    @Autowired
    private SalesRepository salesRepository;
    @Autowired
    private ProductRepository productRepository;


    public SalesProduct save(SalesProductForm salesProductForm) throws Exception {

        Optional<Sales> sales = salesRepository.findById(salesProductForm.getSales());
        if(!sales.isPresent()){
            throw new Exception();
        }

        Optional<Product> product = productRepository.findById(salesProductForm.getProduct());
        if(!product.isPresent()){
            throw new Exception();
        }

        SalesProduct salesProduct = new SalesProduct();
        salesProduct.setSales(sales.get());
        salesProduct.setProduct(product.get());
        salesProduct.setValue(salesProductForm.getValue());
        salesProduct.setPrice(salesProductForm.getPrice());
        salesProduct.setAmount(salesProductForm.getAmount());

        return salesProductRepository.save(salesProduct);
    }

    public Optional<Sales> findById(long id) {

        return salesRepository.findById(id);


    }
}
