package com.api.book.boot_rest_book.dao;

import com.api.book.boot_rest_book.entities.Book;

import org.springframework.data.repository.CrudRepository;

public interface Repo extends CrudRepository<Book,Integer>{
    public Book findById(int id);
}
