package com.example.aquaone.web.controller.products;

import com.example.aquaone.model.Product;
import com.example.aquaone.service.category.CategoryService;
import com.example.aquaone.service.product.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static com.example.aquaone.util.ValidationUtil.assureIdConsistent;
import static com.example.aquaone.util.ValidationUtil.checkNew;


public class AbstractProductController {
    private final Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    ProductService service;

    @Autowired
    CategoryService categoryService;

    public Product get(int id) {
        log.info("get product with id {}", id);
        return service.get(id);
    }

    public void delete(int id) {
        log.info("delete product with id {}", id);
        service.delete(id);
    }

    public List<Product> getAll() {
        log.info("getAll");
       return service.getAll();
    }

    public Product create(Product product) {
        checkNew(product);
        log.info("create {} ", product);
        return service.create(product);
    }

    public void update(Product product, int id) {
        assureIdConsistent(product, id);
        log.info("update {}", product);
        service.update(product);
    }



}
