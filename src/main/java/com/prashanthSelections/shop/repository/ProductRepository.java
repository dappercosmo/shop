package com.prashanthSelections.shop.repository;

import com.prashanthSelections.shop.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    List<Product> findByIsDeletedFalse();
    Product findByIsDeletedFalse(long id);
}
