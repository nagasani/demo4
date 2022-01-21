package com.example4.demo4.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Book {
	
	@Id
	@GeneratedValue
	private Integer id;
	
	private String title;
	
	private String author;
	
	private String price;
	
	protected Book() {	
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}
	
	@Override
	public String toString() {
		return "Book [id=" + id + ", title=" + title + ", author=" + author + ", price=" + price + "]";
	}

	public Book(Integer id, String title, String author, String price) {
		super();
		this.id = id;
		this.title = title;
		this.author = author;
		this.price = price;
	}
	
	/*
	 CREATE TABLE BOOK(
   id INT NOT NULL,
   title VARCHAR(50) NOT NULL,
   author VARCHAR(20) NOT NULL,
   price VARCHAR(20) NOT NULL
);

INSERT INTO BOOK VALUES (1, 'Ram',  'Nani', '10'); 
INSERT INTO BOOK VALUES (2, 'Swapna',  'Sappu', '10'); 
INSERT INTO BOOK VALUES (3, 'Aashritha',  'Aashu', '100'); 
INSERT INTO BOOK VALUES (4, 'Rishi',  'Raja', '1250'); 
	 */

}
