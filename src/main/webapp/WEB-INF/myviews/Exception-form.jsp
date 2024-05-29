<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Adding book....</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.1/css/all.min.css">
</head>
<body>
   <div class="container text-white bg-success text-center">
       <h1>Welcome to Indian Library</h1>
		   <h3><i>address:Adilaxmi nagar,Ravulapalem pin:533238 <br>  phno:+91912345610</i></h3>	    
   </div>
   <div class="container text-white text-center bg-danger">
   Book ISBN:${book.isbn}<br>
   Book Name:${book.bookname} <br>
   Author:${book.author}<br>
   Message:${message}    
   </div>
</body>
</html>
