package com.example.aquaone.service.product;

import com.example.aquaone.model.Product;
import com.example.aquaone.repository.product.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;

import static com.example.aquaone.util.ValidationUtil.checkNotFoundWithId;


@Service
public class ProductService {
    private final ProductRepository repository;

    @Autowired
    public ProductService(ProductRepository repository){
        this.repository = repository;
    }

    public Product get(int id){
        return checkNotFoundWithId(repository.findById(id).orElse(null), id);
    }

    public List<Product> getByCategoryId(int id){
        return repository.getProductsByCategoryId(id);
    }

    public void delete(int id){
        checkNotFoundWithId(repository.deleteProductById(id), id);
    }

    public Product create(Product product){
        Assert.notNull(product, "product must not be null");
        return repository.save(product);
    }

    public void update(Product product){
        Assert.notNull(product, "product must not be null");
        repository.save(product);
    }

    public List<Product> getAll(){
        return repository.findAll();
    }
}
