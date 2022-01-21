package com.example4.demo4.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example4.demo4.dao.BookDaoService;
import com.example4.demo4.errors.BookNotFoundExcpeiton;
import com.example4.demo4.model.Book;
import com.example4.demo4.repository.BookRepositoryService;

@RestController
public class BookJpaController {
	
	@Autowired
	private BookDaoService service;
	
	@Autowired
	BookRepositoryService bookreepositoryservice;
	
	@GetMapping("/jpa/hello-world")
	public String helloWorld() {
		return "Hello World";
	}
	
	@GetMapping("/jpa/book/")
	public Book getBook() {
		return new Book(1, "GoesOnAndOn", "Rams", "25.00");
	}
	
	@GetMapping("/jpa/books/")
	public List<Book> retrieveAllBooks(){
		return bookreepositoryservice.findAll();	
	}
	
	@GetMapping("/jpa/book/{id}")
	public Book findOneBook(@PathVariable Integer id){
		Optional<Book> book =  bookreepositoryservice.findById(id);	
		if(!book.isPresent()) {
			throw new BookNotFoundExcpeiton("id-"+id); 
		}
		return book.get();
	}

	@Transactional(rollbackFor = Exception.class) 
	@PostMapping("/jpa/book")
	public Book addBook(@RequestBody Book book) {
		
		for(int i=0;i<1000;i++) {
			bookreepositoryservice.save(book);
			System.out.println(i);	
			}
		return bookreepositoryservice.save(book);
	}
}
