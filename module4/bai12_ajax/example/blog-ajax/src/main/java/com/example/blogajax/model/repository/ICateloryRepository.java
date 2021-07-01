package com.example.blogajax.model.repository;

import com.example.blogajax.model.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICateloryRepository extends JpaRepository<Category,Integer> {
}
