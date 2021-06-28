package com.example.book.aop;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;

import java.awt.*;
import java.time.LocalDate;
import java.util.Arrays;

@Aspect
public class AopBorrowBook  {
    private static int count = 0;
    @AfterReturning(value = "execution(public * com.example.borrowbook.controller.BookController.showListBook(..))")
    public void afterSignUpController(JoinPoint joinPoint){
        System.err.println("Bạn đã đăng nhập " + ++count+ joinPoint.getSignature().getName());
    }

    @AfterReturning(value = "execution(public * com.example.borrowbook.controller.BookController.*(..))")
    public void logChangeController(JoinPoint joinPoint){
        System.err.println("Sự thay đổi :" +joinPoint.getSignature().getName() + "thời gian" + LocalDate.now());
    }

   @After(value = "execution(public * com.example.borrowbook.controller.BookController.giveBook(..))")
    public void afterBorrow(JoinPoint joinPoint){
        System.err.println("Bạn đã trả sách : " +joinPoint.getSignature().getName());
    }

    @AfterThrowing(pointcut = "execution(public * com.example.borrowbook.controller.BookController.borrowBook(..))",throwing = "e")
    public void borrowBook(JoinPoint joinpoint, Exception e){
        String argName = Arrays.toString(joinpoint.getArgs());
        System.err.printf("Da het sach roi %s",argName);
    }
}
