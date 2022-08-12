package br.com.dld.aula1.controllers;


import br.com.dld.aula1.models.entities.Customer;
import br.com.dld.aula1.models.forms.CustomerForm;
import br.com.dld.aula1.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;
import java.util.Optional;

/**
 * @author David Duarte
 * @created 09/08/2022
 * @project aula-1
 */
@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping("/{id}")
    private ResponseEntity<?> findById(@PathVariable long id) {
        Optional<Customer> customerOpt = customerService.findById(id);

        if (customerOpt.isPresent()) {
            return ResponseEntity.ok(customerOpt.get());
        }

        return ResponseEntity.notFound().build();
    }

    @GetMapping("/all")
    private ResponseEntity<?> findAllByName(@PathParam("name") String name) {
        List<Customer> list = customerService.findAllByName(name);

        return ResponseEntity.ok(list);
    }

    @PostMapping
    private ResponseEntity<?> save(@RequestBody CustomerForm form) {
        Customer customer = customerService.save(form.convert());

        return ResponseEntity.ok(customer);
    }

    @PutMapping
    private ResponseEntity<?> update(@RequestBody Customer form) {
        Customer customer = customerService.save(form);

        return ResponseEntity.ok(customer);
    }

    @DeleteMapping("/{id}")
    private ResponseEntity<?> remove(@PathVariable long id) {
        customerService.delete(id);

        return ResponseEntity.ok().build();
    }
}
