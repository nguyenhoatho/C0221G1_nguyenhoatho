package com.example.shopingcart.model.repository;

import com.example.shopingcart.model.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProductRepository extends JpaRepository<Product,Long> {
}
