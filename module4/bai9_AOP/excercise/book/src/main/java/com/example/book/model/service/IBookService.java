package com.example.book.model.service;



import com.example.book.model.entity.Book;
import com.example.book.model.entity.CodeBorrowBook;

import java.util.List;

public interface IBookService {
    List<Book> findAll();
    void createBook(Book book);
    Book findById(Integer id);
    void updateBook(Book book);
    void giveBook(CodeBorrowBook codeBorrowBook);

}
