package com.springboot.cache.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.cache.entity.Book;
import com.springboot.cache.service.BookService;

@RestController
public class BookController {
	
	@Autowired
	BookService service;
	
	@GetMapping("/books")
	public List<Book> getBooks(){
		return service.getAllBooks();
	}
	
	@GetMapping("/books/{id}")
	public Book getBooks(@PathVariable Integer id){
		return service.findBookById(id);
	}
	
	@DeleteMapping("/books/{id}")
	public void deleteBook(@PathVariable Integer id){
		service.deleteBook(id);
	}
	@PutMapping("/books")
	public Book updateeBook(@RequestBody Book book){
		return service.updateBook(book);
	}

}
