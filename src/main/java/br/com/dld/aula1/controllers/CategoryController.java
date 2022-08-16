package br.com.dld.aula1.controllers;

import br.com.dld.aula1.models.entities.Category;
import br.com.dld.aula1.models.forms.CategoryForm;
import br.com.dld.aula1.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/{id}")
    private ResponseEntity<?> findById(@PathVariable long id) {
        Optional<Category> categoryOpt = categoryService.findById(id);

        if (categoryOpt.isPresent()) {
            return ResponseEntity.ok(categoryOpt.get());
        }

        return  ResponseEntity.notFound().build();
    }

    @GetMapping("/all")
    private ResponseEntity<?> findAllByName(@PathVariable("name") String name) {
        List<Category> list = categoryService.findAllByName(name);

        return ResponseEntity.ok(list);
    }

    @PostMapping
    private ResponseEntity<?> save(@RequestBody CategoryForm form) {
        Category category = categoryService.save(form.convert());

        return ResponseEntity.ok(category);
    }

    @PutMapping
    private ResponseEntity<?> update(@RequestBody Category form) {
        Category category = categoryService.save(form);

        return ResponseEntity.ok(category);
    }

    @DeleteMapping("/{id}")
    private ResponseEntity<?> remove(@PathVariable long id) {
        categoryService.delete(id);

        return ResponseEntity.ok().build();
    }
}