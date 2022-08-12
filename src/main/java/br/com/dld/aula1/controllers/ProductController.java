package br.com.dld.aula1.controllers;

import br.com.dld.aula1.models.entities.Product;
import br.com.dld.aula1.models.forms.ProductForm;
import br.com.dld.aula1.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/product")
public class ProductController {


    @Autowired
    private ProductService productService;

    @GetMapping("/{id}")
    private ResponseEntity<?> findById(@PathVariable long id) {
        Optional<Product> customerOpt = productService.findById(id);

        if (customerOpt.isPresent()) {
            return ResponseEntity.ok(customerOpt.get());
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/all")
    private ResponseEntity<?> findAllByName(@PathParam("name") String name) {
        List<Product> list = productService.findAllByName(name);

        return ResponseEntity.ok(list);
    }

    @PostMapping
    private ResponseEntity<?> save(@RequestBody ProductForm form) {
        Product product = productService.save(form.convert());

        return  ResponseEntity.ok(product);
    }

    @PutMapping
    private ResponseEntity<?> update(@RequestBody Product form) {
        Product product = productService.save(form);

        return ResponseEntity.ok(product);
    }

    @DeleteMapping("/{id}")
    private ResponseEntity<?> remove(@PathVariable long id) {
        productService.delete(id);

        return ResponseEntity.ok().build();
    }
}
