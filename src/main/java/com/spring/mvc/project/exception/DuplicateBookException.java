package com.spring.mvc.project.exception;

import java.util.Optional;

import com.spring.mvc.project.model.Book;

public class DuplicateBookException extends Exception {
		
	Book book;
	public DuplicateBookException(String msg) {
		super(msg);
	}

	public DuplicateBookException(Optional<Book> existingbook) {
		  book = existingbook.get();
	}
	public Book getBook() {
		return book;
	}
	

}
