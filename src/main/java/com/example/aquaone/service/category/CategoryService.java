package com.example.aquaone.service.category;

import com.example.aquaone.model.Category;
import com.example.aquaone.repository.category.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    private final CategoryRepository repository;

    @Autowired
    public CategoryService(CategoryRepository repository){
        this.repository = repository;
    }

    public Category get(int id){
        return repository.findById(id).orElse(null);
    }

    public List<Category> getAll(){
        return repository.findAll();
    }

    public Category create(Category category){
        return repository.save(category);
    }

    public void delete(int id){
        repository.deleteById(id);
    }
}
