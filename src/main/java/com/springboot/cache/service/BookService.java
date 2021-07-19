package com.springboot.cache.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.springboot.cache.entity.Book;

@Service
public class BookService {
	static List<Book> bookList ;
	static {
		bookList = new ArrayList<>();//   Arrays.asList(
				bookList.add(new Book(1, "spring with cache", "chandra", "IT", "sekhar", "1st"));
				bookList.add(new Book(2, "spring with microservice", "chandra", "IT", "sekhar", "1st"));
				bookList.add(new Book(3, "spring with security", "chandra", "IT", "sekhar", "1st"));
				bookList.add(new Book(4, "spring with devops", "chandra", "IT", "sekhar", "1st"));
	}
	
//	@Cacheable(cacheNames = "books")
	public List<Book> getAllBooks(){
		System.out.println("getAllBooks method called");
		return bookList;
	}
	
	@Cacheable(cacheNames = "books", key = "#id")
	public Book findBookById(int id) {
		System.out.println("findBookById method called");
		Optional<Book> bookOptional = bookList.stream()
		.filter(book -> book.getId()==id)
		.findAny();
		return bookOptional.orElse(new Book());
	}
	@CacheEvict(cacheNames = "books", key = "#id")
	public void deleteBook(int id) {
		System.out.println("deleteBook method called");		
	//	bookList = bookList.stream().filter(book-> book.getId()!=id).collect(Collectors.toList());
		bookList.removeIf(b->b.getId()==id);
	}
	
	@CachePut(cacheNames = "books", key = "#book.id")
	public Book updateBook(Book book) {
		System.out.println("updateBook method called");		

		bookList = bookList.stream()
			.filter(b-> b.getId()==book.getId())
			.map(b->{
				b.setAuthor(book.getAuthor());
				b.setCategory(book.getCategory());
				return b;
			}).collect(Collectors.toList());
		return book;
	}
}
