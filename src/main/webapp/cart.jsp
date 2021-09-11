<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
					<div class="container">
						<form action="remove-cart" method="post">
						<h2 class="mt-4 mb-4">${user}'s books</h2>
							<c:forEach items="${records}" var="record">
							<div class="mb-3 form-check">
							<input type="checkbox" class="form-check-input" name="record" value="${record.title}" />
							<label class="form-check-label" for="book">${record.title}</label>
							</div>
							</c:forEach>
							<button type="submit" class="btn btn-danger">Remove</button>
							<button type="button" class="btn btn-success">Proceed to payment</button>
					</form>
					</div>
				</main>
				<%@include file="components/footer.html" %>
		</body>

		</html>