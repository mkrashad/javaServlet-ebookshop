<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
	<%@ page import="javax.servlet.http.HttpSession" %>
		<!DOCTYPE html>
		<html>

		<head>
			<meta charset="utf-8">
			<meta name="viewport" content="width=device-width, initial-scale=1">
			<meta name="description" content="">
			<meta name="author" content="Mark Otto, Jacob Thornton, and Bootstrap contributors">
			<meta name="generator" content="Hugo 0.87.0">
			<title>Admin Panel</title>
			<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css" rel="stylesheet"
				integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We" crossorigin="anonymous">
			<link rel="canonical" href="https://getbootstrap.com/docs/5.1/examples/headers/">
			<!-- Custom styles for this template -->
			<link href="css/header.css" rel="stylesheet">
			<link href="css/footer.css" rel="stylesheet">
		</head>

		<body>
				<%@include file="components/header.jsp" %>
				<main>
					<form method="post" action="remove">
						<div class="container">
							<h2 class="mt-4 mb-4 text-center">Remove Books</h2>
								<table class="table table-striped table-hover table-bordered">
									<tr>
										<th></th>
										<th>Title</th>
										<th>Author</th>
										<th>Price</th>
										<th>Genre</th>
										<th>Description</th>
										<th>Image Location</th>
									</tr>
									<c:forEach items="${books}" var="book">
										<tr>
											<td><input type="checkbox" class="form-check-input" name="book" value="${book.id}" /></td>
											<td>${book.title}</td>
											<td>${book.author}</td>
											<td>$${book.price}</td>
											<td>${book.genre}</td>
											<td>${book.description}</td>
											<td>${book.img}</td>
										</tr>
									</c:forEach>
								</table>
								<input class="btn btn-danger" type='submit' value='Remove' />
						</div>
					</form>
					<div class="container">
						<div class="row">
							<div class="col">
								<h2 class="mt-4">Add Books</h2>
								<form method='post' action='add'>
									<div class="mb-3">
										<label for="title" class="form-label">Title</label>
										<input type="text" class="form-control" name="title" />
									</div>
									<div class="mb-3">
										<label for="author" class="form-label">Author</label>
										<input type="text" class="form-control" name="author" />
									</div>
									<div class="mb-3">
										<label for="price" class="form-label">Price</label>
										<input type="number" class="form-control" name="price" step=0.01 />
									</div>
									<div class="mb-3">
										<label for="description" class="form-label">Description</label>
										<textarea rows="4" cols="50" class="form-control" name="description"></textarea>
									</div>
									<div class="mb-3">
										<label for="genre" class="form-label">Genre</label>
										<input type="text" class="form-control" name="genre" />
									</div>
									<div class="mb-3">
										<label for="img" class="form-label">Img Location</label>
										<input type="text" class="form-control" name="img" />
									</div>
									<input type="submit" class="btn btn-success" value="Add">
								</form>
							</div>
							<div class="col">
								<form method="post" action="edit">
									<h2 class="mt-4">Edit book</h2>
									<label for="title" class="form-label">Title</label>
									<select class="form-select" name="book">
										<c:forEach items="${books}" var="book">
											<option value="${book.title}">${book.title}</option>
										</c:forEach>
									</select><br />
									<input class="btn btn-secondary" type="submit" value="Edit">
								</form>
							</div>

						</div>
					</div>

				</main>
				<%@include file="components/footer.html" %>
		</body>

		</html>