package com.example.aquaone.repository.product;

import com.example.aquaone.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
public interface ProductRepository extends JpaRepository<Product, Integer> {

    @Transactional
    int deleteProductById(int id);

    List<Product> getProductsByCategoryId(int id);

}
