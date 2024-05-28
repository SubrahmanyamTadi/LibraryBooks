package com.spring.mvc.project.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.spring.mvc.project.exception.DuplicateBookException;
import com.spring.mvc.project.model.Book;

@Service
public class BookService {

	static List<Book> books = new ArrayList<Book>();
	static {
	    books.add(new Book(1001, "The Power of Positive Thinking"," Norman Vincent Peale"));
	    books.add(new Book(1002, "Think and Grow Rich","Napoleon Hill"));
	    books.add(new Book(1003,"The Alchemist","JPaulo Coelho"));
	    books.add(new Book(1004,"Mindset"," Carol S. Dweck"));
	    books.add(new Book(1005, "To Kill a Mockingbird","Harper Lee"));
	    books.add(new Book(1006,"Flow","Mihaly Csikszentmihalyi"));
	    books.add(new Book(1007,"Dare","Barry McDonagh"));
	    books.add(new Book(1008,"Quiet","Susan Cain"));
	    books.add(new Book(1009,"Start","Jon Acuff"));
	    books.add(new Book(1010,"Enough","Patrick Rhone"));
	    books.add(new Book(1011,"Fearless","Eric Blehm"));
	    books.add(new Book(1012,"Rising Strong", "Brené Brown"));
	    books.add(new Book(1013,"Originals","Adam Grant"));
	    books.add(new Book(1014,"Outliers", "Malcolm Gladwell"));     
	}
	public List<Book> getbooks(){
		return books;
	}
	public boolean saveBookData( Book book) throws DuplicateBookException {
		Optional<Book>	existingbook=books.stream()
		     .filter( b->b.getIsbn().equals(book.getIsbn()))
		     .findFirst();
		if(existingbook.isPresent())  {
			//throw new DuplicateBookException("Book already exists with that isbn number");
			throw new DuplicateBookException(existingbook);
		}
		
		 return books.add(book);
		
	}
	public boolean deleteBookData(Integer isbn) {
		Book book=books.stream()
	         .filter(b->b.getIsbn().equals(isbn))
	         .findFirst()
	         .get();
		return books.remove(book);
	}
	public Book editBookData(Integer isbn) {
		 Book book=books.stream()
				.filter(b->b.getIsbn().equals(isbn))
				.findFirst()
				.get();
		return book; 
		 
	}
	public  Book saveEditBook(Book editbook) {
		 Book book=books.stream()
					.filter(b->b.getIsbn().equals(editbook.getIsbn()))
					.findFirst()
					.get();
		 if(book !=null ) {
			 book.setBookname(editbook.getBookname());
			 book.setAuthor(editbook.getAuthor());
		 }
		 return book;	
	}	 
}
