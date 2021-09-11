<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
		<!DOCTYPE html>
		<html>

		<head>

			<head>
				<meta charset="utf-8">
				<meta name="viewport" content="width=device-width, initial-scale=1">
				<meta name="description" content="">
				<meta name="author" content="Mark Otto, Jacob Thornton, and Bootstrap contributors">
				<meta name="generator" content="Hugo 0.87.0">
				<title>Edit Book</title>
				<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css" rel="stylesheet"
					integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We" crossorigin="anonymous">
				<link rel="canonical" href="https://getbootstrap.com/docs/5.1/examples/headers/">
				<!-- Custom styles for this template -->
				<link href="css/header.css" rel="stylesheet">
				<link href="css/footer.css" rel="stylesheet">
			</head>
		</head>

		<body>
			<%@include file="components/header.jsp" %>
			<main>
				<div class="container">
					<h1 class="mt-4 mb-4 text-center">Edit Book</h1>
					<form method='post' action='update'>
						<div class="row">
							<div class="col-lg-5 m-auto">
								<c:forEach items="${books}" var="book">
									<div class="mb-3">
										<label for="title" class="form-label">Title</label>
										<input type="text" class="form-control input-sm" name="title" value="${book.title}" />
									</div>
									<div class="mb-3">
										<label for="author" class="form-label">Author</label>
										<input type="text" class="form-control" name="author" value="${book.author}" />
									</div>
									<div class="mb-3">
										<label for="price" class="form-label">Price</label>
										<input type="number" class="form-control" name="price" step=0.01 value="${book.price}" />
									</div>
									<div class="mb-3">
										<label for="description" class="form-label">Description</label>
										<textarea rows="4" cols="50" class="form-control" name="description">${book.description}</textarea>
									</div>
									<div class="mb-3">
										<label for="genre" class="form-label">Genre</label>
										<input type="text" class="form-control" name="genre" value="${book.genre}" />
									</div>
									<div class="mb-3">
										<label for="image" class="form-label">Image Location</label>
										<input type="text" class="form-control" name="image" value="${book.img}" />
									</div>
								</c:forEach>
								<input type="submit" class="btn btn-primary" value="Update">
							</div>
						</div>
					</form>
				</div>
			</main>
				<%@include file="components/footer.html" %>
		</body>

		</html>