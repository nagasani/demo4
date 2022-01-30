package com.example4.demo4.consumer;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example4.demo4.model.Book;

@RestController
public class BookRestTemplate {

	@GetMapping("/rest/book/{id}")
	public Book retrieveAllBooks(@PathVariable Integer id ){
		RestTemplate restTemplate = new RestTemplate();
		Book book = restTemplate.getForObject("http://localhost:8080/book/"+id, Book.class);
		System.out.println(book.toString());
		return book;
	}
}
