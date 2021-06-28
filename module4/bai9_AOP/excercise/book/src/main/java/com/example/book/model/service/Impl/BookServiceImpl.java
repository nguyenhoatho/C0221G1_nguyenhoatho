package com.example.book.model.service.Impl;


import com.example.book.model.entity.Book;
import com.example.book.model.entity.CodeBorrowBook;
import com.example.book.model.repository.IBookRepository;
import com.example.book.model.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class BookServiceImpl implements IBookService {
    @Autowired
    IBookRepository bookRepository;
    @Override
    public List<Book> findAll() {
        return bookRepository.findAll();
    }


    @Override
    public void createBook(Book book) {
        bookRepository.save(book);
    }

    @Override
    public Book findById(Integer id) {
        return bookRepository.findById(id).orElse(null);
    }

    @Override
    public void updateBook(Book book) {
        bookRepository.save(book);
    }

    @Override
    public void giveBook(CodeBorrowBook codeBorrowBook) {
    }


}
