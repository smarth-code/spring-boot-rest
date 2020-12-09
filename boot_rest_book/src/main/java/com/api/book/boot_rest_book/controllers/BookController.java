package com.api.book.boot_rest_book.controllers;

import java.util.List;
import java.util.Optional;

import com.api.book.boot_rest_book.entities.Book;
import com.api.book.boot_rest_book.services.BookService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookController {
   
    @Autowired
    private BookService bookService;
    
    @GetMapping("/book")
    public ResponseEntity<List<Book>> getData(){
        List<Book> list=bookService.getBooks(); 
        if(list.size()<=0){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.of(Optional.of(list));
    }

    @GetMapping("/book/{id}")
    public ResponseEntity<Book> getDataById(@PathVariable("id") int id){
        Book book = bookService.getBookById(id);
        if(book==null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.of(Optional.of(book));
    }

    @PostMapping("/book")
    public ResponseEntity<Book> addData(@RequestBody Book book){
        Book b=null;
        try{
           b= bookService.addBook(book);
           System.out.println("CREATED");
           return ResponseEntity.status(HttpStatus.CREATED).build();
        }catch(Exception e){
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
        
    }

    @DeleteMapping("/book/{id}")
    public ResponseEntity<Void> delData(@PathVariable("id") int id){
        try{
            bookService.deleteBook(id);
            return ResponseEntity.ok().build();
        }catch(Exception e){
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PutMapping("/book/{id}")
    public ResponseEntity<Book> updateData(@RequestBody Book book,@PathVariable("id") int id){
        try{
            Book bbb= bookService.updateBook(book,id);
            System.out.println(bbb);
            return ResponseEntity.ok().build();
        }catch(Exception e){
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }  
    }
}

