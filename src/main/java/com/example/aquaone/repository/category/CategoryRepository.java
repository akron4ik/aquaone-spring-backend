package com.example.aquaone.repository.category;

import com.example.aquaone.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


@Repository
@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
public interface CategoryRepository extends JpaRepository<Category, Integer> {
}
