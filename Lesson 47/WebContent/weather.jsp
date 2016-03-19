<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Weather forecast</title>
<style>
#map {
	width: 500px;
	height: 400px;
}
</style>
</head>
<body>
	<form action="WeatherServlet" method="get">
		<input type="text" name="city" placeholder="Enter a city name">
		<input type="submit" value="Search">
	</form>


	<%
		if (request.getAttribute("city") != null) {
	%>

	City:
	<%=request.getAttribute("city")%>
	<br> Lattitude:
	<%=request.getAttribute("lattitude")%>
	<br> Longtitude:
	<%=request.getAttribute("longtitude")%>
	<br> Clouds:
	<%=request.getAttribute("clouds")%>
	<br> Temperature:
	<%=request.getAttribute("temperature")%>
	<br>

	<%
		}
	%>

	<br>
	<br>

	<div id="map"></div>
	<script>
		function initMap() {
			var mapDiv = document.getElementById('map');
			var map = new google.maps.Map(mapDiv, {
				center : {
					lat : <%=request.getAttribute("lattitude")%>,
					lng : <%=request.getAttribute("longtitude")%>
				},
				zoom : 8
			});
		}
	</script>
	<script src="https://maps.googleapis.com/maps/api/js?callback=initMap" async defer></script>
</body>
</html>