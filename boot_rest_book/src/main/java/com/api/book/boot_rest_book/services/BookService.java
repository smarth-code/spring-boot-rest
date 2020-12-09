package com.api.book.boot_rest_book.services;

import java.util.ArrayList;
import java.util.List;

import com.api.book.boot_rest_book.dao.Repo;
import com.api.book.boot_rest_book.entities.Book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {

    
   /* private static List<Book> l = new ArrayList<>();

    static{
    l.add(new Book(11,"ABC","xyz"));
    l.add(new Book(22,"LMN","efg"));
    l.add(new Book(33,"PQR","hij"));
    }*/
    @Autowired
    private Repo r;

    public List<Book> getBooks(){
        //return l;
        List<Book> l=(List<Book>)r.findAll();
        return l;
    }

    public Book getBookById(int id){
      /*  Book b=null;
        for(int i=0;i<l.size();i++){
            if(l.get(i).getId()==id){
                b=l.get(i);
            }
        }
        return b;*/
         return r.findById(id);
    }

    public Book addBook(Book b){
      /*  l.add(b);
        return b;*/
        return r.save(b);
    }

    public void deleteBook(int id){
     /*  Book b=null;
        for(int i=0;i<l.size();i++){
            if(l.get(i).getId()==id){
               b= l.remove(i);
            }
        }
        return b; */
        r.deleteById(id);
    }

    public Book updateBook(Book b,int id){ 
       /* for(int i=0;i<l.size();i++){
            if(l.get(i).getId()==id){
                l.get(i).setAuthor(b.getAuthor());
                l.get(i).setName(b.getName());
            }
        }
        return b;*/
        b.setId(id);
        return r.save(b);
    }
}
