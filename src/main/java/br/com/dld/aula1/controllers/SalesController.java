package br.com.dld.aula1.controllers;

import br.com.dld.aula1.models.entities.Sales;
import br.com.dld.aula1.models.forms.SalesForm;
import br.com.dld.aula1.services.SalesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/sales")
public class SalesController {

    @Autowired
    private SalesService salesService;

    @GetMapping("/{id}")
    private ResponseEntity<?> findById(@PathVariable long id) {
        Optional<Sales> salesOpt = salesService.findById(id);

        if (salesOpt.isPresent()) {
            return ResponseEntity.ok(salesOpt.get());
        }
        return ResponseEntity.notFound().build();
    }

//    @GetMapping("/all")
//    private ResponseEntity<?> findAllByName(@PathParam("name") String name) {
//        List<Sales> list = salesService.findAllByName(name);
//
//        return ResponseEntity.ok(list);
//    }

    @PostMapping
    private ResponseEntity<?> save(@RequestBody SalesForm form)throws Exception {
        return ResponseEntity.status(HttpStatus.CREATED).body(salesService.save(form));
    }

//    @PutMapping
//    private ResponseEntity<?> update(@RequestBody Sales form) {
//        Sales sales = salesService.save(form);
//
//        return ResponseEntity.ok(sales);
//    }
//
//    @DeleteMapping("/{id}")
//    private ResponseEntity<?> remove(@PathVariable long id) {
//        salesService.delete(id);
//
//        return ResponseEntity.ok().build();
//    }
}
