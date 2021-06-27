package com.example.productmanagementsortingpaging.model.repository;

import com.example.productmanagementsortingpaging.model.entity.Product;
import com.example.productmanagementsortingpaging.model.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface IProductRepository extends JpaRepository<Product,Integer> {
    @Query(value = "select * from product  where name_product like %?1% ",nativeQuery = true)
    Page<Product> findAllByNameSearch(String nameSearch, Pageable pageable);
}
