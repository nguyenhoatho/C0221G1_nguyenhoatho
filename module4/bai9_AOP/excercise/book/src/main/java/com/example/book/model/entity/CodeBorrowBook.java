package com.example.book.model.entity;

import javax.persistence.*;

@Entity
@Table(name = "code_book")
public class CodeBorrowBook {
    @Id
    private Long id;
    @ManyToOne
    @JoinColumn(name = "book_id",referencedColumnName = "id")
    private Book book;

    public CodeBorrowBook(Long id, Book book) {
        this.id = id;
        this.book = book;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public CodeBorrowBook() {
    }



    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }
}
