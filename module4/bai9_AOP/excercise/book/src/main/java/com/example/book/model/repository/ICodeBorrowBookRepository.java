package com.example.book.model.repository;

import com.example.book.model.entity.CodeBorrowBook;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;

@Repository
public interface ICodeBorrowBookRepository extends JpaRepository<CodeBorrowBook,Long> {
//    @Modifying
//    @
//    void deleteById(Float id);
}
