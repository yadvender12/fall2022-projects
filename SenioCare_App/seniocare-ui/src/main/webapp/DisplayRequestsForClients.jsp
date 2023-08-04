
<%@page import="seniocare.demo.Request"%>
<%@page import="seniocare.demo.Request"%>
<%@page import="java.net.URLEncoder"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="java.util.List"%>
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
		Integer id = Integer.parseInt(request.getParameter("client"));
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
	<div class="container">
		<table class="table table-striped">
			<thead>
				<tr>
					<th>Serial</th>
					<th colspan="2">Pending With</th>
					<th>Phone</th>
					<th>Email</th>
					<th>Type</th>
				</tr>
			</thead>
			<tbody>
				<%
					List<Request> reqs = (List) request.getAttribute("ReqForCl");
				if (null != reqs) {
					for (int i = 0; i < reqs.size(); i++) {
						out.print("<tr>");
						out.print("<td>" + (i + 1) + "</td>");
						out.print("<td>" + reqs.get(i).getFirstName() + "</td>");
						out.print("<td>" + reqs.get(i).getLastName() + "</td>");
						out.print("<td>" + reqs.get(i).getPhone() + "</td>");
						out.print("<td>" + reqs.get(i).getEmail() + "</td>");
						out.print("<td>" + reqs.get(i).getType() + "</td>");
						out.print("</tr>");

					}
				} else {
				%>
				<div>
					<p class="text-center">Refresh please!</p>
				</div>
				<%
					}
				%>
			</tbody>
		</table>

	</div>
</body>
</html>