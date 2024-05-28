package com.spring.mvc.project.model;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Book {
	
   @NotNull(message="isbn number is required")
	private Integer isbn;
   @jakarta.validation.constraints.NotBlank(message="Book Name  is required")
	private String bookname; 
    @jakarta.validation.constraints.NotBlank(message="author name is required")
	private String author;	
	
}
