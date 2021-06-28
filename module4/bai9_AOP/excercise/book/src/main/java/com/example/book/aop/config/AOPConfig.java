package com.example.book.aop.config;


import com.example.book.aop.AopBorrowBook;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Configuration
public class AOPConfig {
    @Bean
    public AopBorrowBook config(){
        return new AopBorrowBook();
    }
}
