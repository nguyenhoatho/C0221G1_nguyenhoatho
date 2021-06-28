package com.example.book.model.service.Impl;

import com.example.book.model.entity.CodeBorrowBook;
import com.example.book.model.repository.ICodeBorrowBookRepository;
import com.example.book.model.service.ICodeBorrowBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CodeBorrowBookServiceImpl implements ICodeBorrowBookService {
    @Autowired
    ICodeBorrowBookRepository codeBorrowBookRepository;
    @Override
    public List<CodeBorrowBook> findAll() {
        return codeBorrowBookRepository.findAll();
    }

    @Override
    public void deleteById(Long id) {
        codeBorrowBookRepository.deleteById(id);
    }

    @Override
    public void create(CodeBorrowBook codeBorrowBook) {
        codeBorrowBookRepository.save(codeBorrowBook);
    }

    @Override
    public CodeBorrowBook findById(Long id) {
        return codeBorrowBookRepository.findById(id).orElse(null);
    }
}
