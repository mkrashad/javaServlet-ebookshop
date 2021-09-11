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
				<title>Books</title>
				<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css" rel="stylesheet"
					integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We" crossorigin="anonymous">
				<!-- Custom styles for this template -->
				<link href="css/header.css" rel="stylesheet">
				<link href="css/footer.css" rel="stylesheet">
				<link href="css/blog.css" rel="stylesheet">
			</head>

			<body>
					<%@include file="components/header.jsp" %>
				<main>
						<form method="post" action="add-cart">
							<div class="container mt-4">
									<% if(session.getAttribute("role") ==null) { %>
									Please login to buy books
									<% } %>
								<h1 class="mt-4 mb-5">Welcome to the Ebook-shop</h1>
								<div class="row mb-2">
									<c:forEach items="${books}" var="book">
										<div class="col-md-6">
											<div
												class="row g-0 border rounded overflow-hidden flex-md-row mb-4 shadow-sm h-md-280 position-relative">
												<div class="col p-4 d-flex flex-column position-static">
													<strong class="d-inline-block mb-2 text-primary">${book.genre}</strong>
													<h3 class="mb-0">${book.title}</h3>
													<div class="mb-1 text-muted">Price: $${book.price}</div>
													<p class="card-text mb-auto">${book.description}</p>
													<div class="mb-3 form-check">
														<% if(session.getAttribute("role")==null) { %>
															<label class="form-check-label" for="book">Check out</label>
															<input type="checkbox" class="form-check-input" name="book" value="${book.title}"
																disabled>
															<% } else { %>
																<label class="form-check-label" for="book">Check out</label>
																<input type="checkbox" class="form-check-input" name="book" value="${book.title}">
																<% } %>
													</div>
												</div>
												<div class="col-auto d-none d-lg-block">
													<img src="img/${book.img}" width="200" height="280" alt="${book.img}">
												</div>
											</div>
										</div>
									</c:forEach>
								</div>
								<div class="row mb-2">
									<div class="col-md-3">
										<% if(session.getAttribute("role") !=null) { %>
											<input class="btn btn-success mt-1" type="submit" value="ADD TO CART" />
												<% } %>
									</div>
								</div>
							</div>
						</form>
				</main>
				<%@include file="components/footer.html" %>
			</body>

			</html>