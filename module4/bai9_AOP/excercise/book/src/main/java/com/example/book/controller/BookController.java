package com.example.book.controller;


import com.example.book.exception.BookBorrowException;
import com.example.book.exception.NoCodeBorrowBook;
import com.example.book.model.entity.Book;
import com.example.book.model.entity.CodeBorrowBook;
import com.example.book.model.service.IBookService;
import com.example.book.model.service.ICodeBorrowBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class BookController {
    @Autowired
    private IBookService bookService;
    @Autowired
    private ICodeBorrowBookService codeBorrowBookService;

    @GetMapping(value = "/")
    public String showHome(){
        return "home";
    }

    @GetMapping(value = "/list-book")
    public ModelAndView showListBook(){
        return new ModelAndView("list_book","listBook",bookService.findAll());
    }
    @GetMapping(value = "/borrow-book")
    public String goViewBook(@RequestParam(value = "id") int id,Model model){
        model.addAttribute("book",this.bookService.findById(id));
        return "view-book";
    }
    @GetMapping(value = "/create-book")
    public String showCreateBook(Model model){
        model.addAttribute("book",new Book());
        return "create_book";
    }
    @PostMapping(value = "/create-book/create")
    public String createBook(@ModelAttribute("book") Book book, RedirectAttributes redirect){
        this.bookService.createBook(book);
        redirect.addFlashAttribute("message","Create succesfull");
        return "redirect:/";
    }
    @PostMapping(value = "/borrow-book/book")
    public String borrowBook(@ModelAttribute("book") Book book,Model model) throws Exception {
        if(book.getQuantity() == 0){
            throw new BookBorrowException();
        }
        Integer quantity = book.getQuantity() - 1;
        book.setQuantity(quantity);
        this.bookService.updateBook(book);
        Long idCode = Math.round(Math.random() * 10000);
        this.codeBorrowBookService.create(new CodeBorrowBook(idCode,book));
        model.addAttribute("idcode",idCode);
        return "home";
    }
    @PostMapping (value = "/give-book/give")
    public String giveBook(@RequestParam("id") Long id,Model model) throws NoCodeBorrowBook {
        CodeBorrowBook codeBorrowBook = this.codeBorrowBookService.findById(id);
        if(codeBorrowBook == null){
            throw new NoCodeBorrowBook();
        }
        this.codeBorrowBookService.deleteById(id);
        Book book = this.bookService.findById(codeBorrowBook.getBook().getId());
        book.setQuantity(book.getQuantity() + 1);
        this.bookService.updateBook(book);
        model.addAttribute("message","Done give book");
        return "home";
    }
    @GetMapping(value = "/borrow-book-list")
    public String showBorrowBook(Model model){
        model.addAttribute("listBorrow",this.codeBorrowBookService.findAll());
        return "borrow_book_list";
    }
    @GetMapping(value = "/give-book")
    public String showGiveBook(){
        return "give_book";
    }

    @ExceptionHandler(BookBorrowException.class)
    public String showErrorPage(){
        return "error";
    }

    @ExceptionHandler(NoCodeBorrowBook.class)
    public String showNoCode(){
        return "error_no_code";
    }
}
