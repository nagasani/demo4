package com.example4.demo4.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example4.demo4.errors.BookNotFoundExcpeiton;
import com.example4.demo4.dao.BookDaoService;
import com.example4.demo4.model.Book;

@RestController
public class BookController {
	
	@Autowired
	private BookDaoService service;
	
	@GetMapping("/hello-world")
	public String helloWorld() {
		return "Hello World";
	}
	
	@GetMapping("/book/")
	public Book getBook() {
		return new Book(1, "GoesOnAndOn", "Rams", "25.00");
	}
	
	@GetMapping("/books/")
	public List<Book> retrieveAllBooks(){
		return service.findAll();	
	}
	
	@GetMapping("/book/{id}")
	public Book findOneBook(@PathVariable Integer id){
		Book book =  service.findBook(id);	
		if(book == null) {
			throw new BookNotFoundExcpeiton("id-"+id); 
		}
		return book;
	}

	@PostMapping("/book")
	public Book addBook(@RequestBody Book book) {
		return service.save(book);
	}
}
