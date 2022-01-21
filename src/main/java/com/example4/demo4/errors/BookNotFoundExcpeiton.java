package com.example4.demo4.errors;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class BookNotFoundExcpeiton extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2585504537859533069L;

	public BookNotFoundExcpeiton(String message) {
		super(message);
	}

}
