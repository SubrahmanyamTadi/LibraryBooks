<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Books list....</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
		<div class="container-fluid bg-success text-white text-center" >
		    <h1>Welcome to the Indian Library</h1>
		   <h3><i>address:Adilaxmi nagar,Ravulapalem pin:533238 <br>  phno:+91912345610</i></h3>	    
		</div>
 
			<div class="text-center"> 
			<a class="link-primary badge bg-warning" href="/book/addbook">click here to add a new Book</a>
		</div>
		 
		<div class="container"> 
		<h1><u class="text-success"><i>List of Books available...</i></u></h1><br>
		<div class="text-center  text-warning">
		 <c:if test="${not empty savemessage}">
		   <div class="text-warning"> <h3><i>Data successfully inserted...</i> </h3></div>
		 </c:if>
		 
		 <c:if test="${not empty deletemessage}">
		     <h3><i>Data deleted successfully... </i> </h3> 
		 </c:if>
		 <c:if test="${not empty editmessage}">
		     <h3><i>Data edited successfully... </i> </h3> 
		 </c:if>
		 
		</div>
		
		
		<table class="table table-striped table-bordered table-hover">
		   <thead class="table table-dark">
		        <tr>
		           <th>ISBN</th>
		           <th>Book Name</th>
		           <th>Author</th>
		           <th>Action</th>
		          
		        </tr>
		   </thead> 
		   <tbody> 
      <c:forEach items="${books}" var="bookItem">
           <tr>
              <td> ${bookItem.isbn} </td>
              <td> ${bookItem.bookname} </td>
              <td>  ${bookItem.author} </td>
              <td><a href="/book/edit/${bookItem.isbn}">Edit</a> 
               <a href="/book/delete/${bookItem.isbn}">Delete</a></td>
           </tr>
         
         
      </c:forEach>
      </tbody>
      </table>
      </div>
</body>
</html>

