package com.spring.mvc.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.spring.mvc.project.exception.DuplicateBookException;
import com.spring.mvc.project.model.Book;
import com.spring.mvc.project.service.BookService;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/book")
public class BookController {
	@Autowired
	BookService bookservice;
    @GetMapping("/viewbook")
	public String getBooks(Model model) {
    List<Book>	books=bookservice.getbooks();
    model.addAttribute("books",books);
		return "book-list";
	}
    @GetMapping("/addbook")
    public String addbook(){
    	return "add-book";
    }
    @PostMapping("/savebook")
    public String savebook(@Valid @ModelAttribute Book book,BindingResult bindingResult,Model model,RedirectAttributes redirectAttributes) throws DuplicateBookException {
    	if(bindingResult.hasErrors()) {
    		model.addAttribute("errors",bindingResult);	
    		return "add-book";
    	}
    	boolean status = bookservice.saveBookData(book);
    	if(status) {
    		redirectAttributes.addFlashAttribute("savemessage",true);
    		
    	}
    	return "redirect:/book/viewbook";
    }
    @GetMapping("/delete/{isbn}")
    public String deleteBook(@PathVariable Integer isbn,RedirectAttributes redirectAttributes)
    {
    	boolean status=bookservice.deleteBookData(isbn);
    	if(status) {
    	redirectAttributes.addFlashAttribute("deletemessage",true);
    	}
    	return "redirect:/book/viewbook";	
    }
    @GetMapping("/edit/{isbn}")
    public String editBook(@PathVariable Integer isbn,Model model) {
    	Book book=bookservice.editBookData(isbn);
    	model.addAttribute("book",book);
  	return "edit-form"; 	
    }
    @PostMapping("/editsavebook")
    public String editboksave(@ModelAttribute Book editbook,RedirectAttributes redirectAttributes) {
       Book book=bookservice.saveEditBook(editbook);
       if(book != null) {
    	   redirectAttributes.addFlashAttribute("editmessage", true);
       }
       
       return "redirect:/book/viewbook";
}
}
