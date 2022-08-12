package br.com.dld.aula1.services;

import br.com.dld.aula1.models.entities.Product;
import br.com.dld.aula1.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public Optional<Product> findById(long id) {
        return productRepository.findById(id);
    }

    public List<Product> findAllByName(String name) {
        return productRepository.findAllByNameContains(name);
    }

    public Product save(Product product) {
        return productRepository.save(product);
    }

    public void delete(long id) {
        productRepository.deleteById(id);
    }
}
