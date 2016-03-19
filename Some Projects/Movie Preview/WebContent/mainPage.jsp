<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Movie gadget</title>
</head>
<body>
	<c:remove var="error" scope="session" />
	
	<table>
		<c:forEach items="${applicationScope.movies}" var="movie">
			<form action="MovieDetailsServlet" method="post">
				<tr>
					<td>
						<c:out value="${movie.title}"></c:out>
						<input type="hidden" value="${movie.title}" name="title">
					</td>
					<td>
						<c:out value="${movie.year}"></c:out>
						<input type="hidden" value="${movie.year}" name="year">
					</td>
					<td>
						<input type="submit" value="view">
					</td>
				</tr>
			</form>
		</c:forEach>
	</table>
</body>
</html>