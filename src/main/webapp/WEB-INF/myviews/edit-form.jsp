
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Adding book....</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.1/css/all.min.css">
</head>
<body>
        <div class="container-fluid bg-success text-white text-center" >
           <h1>Welcome to Indian Library</h1>
	  <h3><i>address:Adilaxmi nagar,Ravulapalem pin:533238 <br>  phno:+91912345610</i></h3>	    
         </div>
         <div class="container"> 
        <form method="post" action="/book/editsavebook">
            <div class="form-group">
                <label>Book ISBN:</label>
                <div class="input-group">
                    <span class="input-group-text"><i class="fas fa-book"></i></span>
                    <input type="text" class="form-control" name="isbn" readonly="readonly" value="${book.isbn}" placeholder="Enter Book ISBN" value="${book.isbn}"/><br>
                    </div>
                    <c:if test="${not empty errors.getFieldError('isbn')}">
                        <div class="text-danger">${errors.getFieldError('isbn').defaultMessage}</div>  
                    </c:if>
            </div>

            <div class="form-group">
                <label>Book Name:</label>
                <div class="input-group">
                    <span class="input-group-text"><i class="fas fa-book"></i></span>
                    <input type="text" class="form-control" name="bookname" value="${book.bookname}" placeholder="Enter Book name" value="${book.bookname}"/><br>
                    </div>
                    <c:if test="${not empty errors.getFieldError('bookname')}">
                        <div class="text-danger">${errors.getFieldError('bookname').defaultMessage}</div>  
                    </c:if>
                 
            </div>

            <div class="form-group">
                <label>Author:</label>
                <div class="input-group">
                    <span class="input-group-text"><i class="fas fa-user"></i></span>
                    <input type="text" class="form-control" name="author" value="${book.author}"placeholder="Enter Author name" value="${book.author}"/><br>
                    </div>
                    <c:if test="${not empty errors.getFieldError('author')}">
                        <div class="text-danger">${errors.getFieldError('author').defaultMessage}</div>  
                    </c:if>
                
            </div>
            <br>
            <button type="submit" class="btn btn-primary">Save Book</button>
       
        </form>  
        </div>
</body>
</html>

 
