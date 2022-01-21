package com.example4.demo4.dao;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;
import com.example4.demo4.model.Book;

@Component
public class BookDaoService {
	
	private static List<Book> books = new ArrayList<Book>();
	
	private static Integer booksCount = 3;
	
	static {
		books.add(new Book(1, "GoesOnAndOn", "Rams", "25.00"));
		books.add(new Book(2, "GoesOnAndOnAgain", "Raju", "25.00"));
		books.add(new Book(3, "GoesOnAndOnAgainAndAgain", "Nagasani", "25.00"));
	}
	
	public List<Book> findAll(){
		return books;
	}

	public Book save(Book book) {
		if(book.getId() == null) {
			book.setId(++booksCount);
		}
		books.add(book);
		return book;
	}
	
	public Book findBook(Integer id) {
		
		for(Book book:books) {
			if(book.getId() == id) {
				return book;
			}
		}
		return null;
	}
}
		