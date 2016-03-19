<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Movie</title>
</head>
<body>
	<table>
		<tr>
			<img src="${movie.poster}" style="width:600px;height:800px;">
		</tr>
		<tr>
			<tr>
				<td>
					<h2>Title:</h2>
				</td>
				<td>
					<c:out value="${movie.title}"></c:out>
				</td>
			</tr>
			<tr>
				<td>
					<h2>Year:</h2>
				</td>
				<td>
					<c:out value="${movie.year}"></c:out>
				</td>
			</tr>
			<tr>
				<td>
					<h2>Actors:</h2>
				</td>
				<td>
					<c:out value="${movie.actors}"></c:out>
				</td>
			</tr>
			<tr>
				<td>
					<h2>Awards:</h2>
				</td>
				<td>
					<c:out value="${movie.awards}"></c:out>
				</td>
			</tr>
		</tr>
	</table>
</body>
</html>