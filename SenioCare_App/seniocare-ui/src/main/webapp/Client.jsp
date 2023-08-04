
<%@page import="java.net.URLEncoder"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<title></title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<style>
body {
	background-image: url('old.png');
	background-repeat: no-repeat;
	background-size: cover;
}
</style>
</head>
<body>
	<%
		String name = (String) request.getAttribute("Name");
	Integer id = (Integer) request.getAttribute("clientId");
	%>
	<nav class="navbar navbar-inverse">
		<div class="container-fluid">
			<div class="navbar-header">
				<a class="navbar-brand" href="<%=request.getContextPath()%>/Site">Home</a>
			</div>
			<ul class="nav navbar-nav">
				<li><a
					href="<%=request.getContextPath()%>/Site?page=RequestforClients&client=<%=id%>">Requests</a></li>
				<li><a
					href="<%=request.getContextPath()%>/Site?page=NewRequest&client=<%=id%>">New
						Request</a></li>
			</ul>
		</div>
	</nav>
	<div>
		<p class="text-center">
			Welcome
			<%=name%>!
		</p>
	</div>
</body>
</html>
