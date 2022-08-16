package br.com.dld.aula1.services;

import br.com.dld.aula1.models.entities.Category;
import br.com.dld.aula1.models.forms.CategoryForm;
import br.com.dld.aula1.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public Optional<Category> findById(long id) {
        return categoryRepository.findById(id);
    }

    public List<Category> findAllByName(String name) {
        return categoryRepository.findAllByNameContains(name);
    }

    public Category save(Category category) {
        return categoryRepository.save(category);
    }

    public void delete(long id) {
        categoryRepository.deleteById(id);
    }

}
