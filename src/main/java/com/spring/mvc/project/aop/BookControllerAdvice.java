package com.spring.mvc.project.aop;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.spring.mvc.project.exception.DuplicateBookException;
import com.spring.mvc.project.model.Book;

@ControllerAdvice
public class BookControllerAdvice {
@ExceptionHandler(value=DuplicateBookException.class)
public String duplicateBookException(DuplicateBookException exception,Model model) {
	Book book =exception.getBook();
	model.addAttribute("book",book);
	model.addAttribute("message","ISBN number already exists");
	return "Exception-form";
	
	
}
}
