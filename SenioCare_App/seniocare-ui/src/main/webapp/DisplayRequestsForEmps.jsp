
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
		int id = Integer.parseInt(request.getParameter("employee"));
	%>
	<nav class="navbar navbar-inverse">
		<div class="container-fluid">
			<div class="navbar-header">
				<a class="navbar-brand" href="<%=request.getContextPath()%>/Site">Home</a>
				</div>
				<ul class="nav navbar-nav">
					<li><a
						href="<%=request.getContextPath()%>/Site?page=RequestforEmployees&employee=<%=id%>">Requests</a></li>
					
				</ul>
				<form method="post"
					action="<%=request.getContextPath()%>/Site?page=Logout&employee=<%=id%>">
					<input type="submit" class="btn btn-success" value="Logout"
						style="margin-top: 8px; margin-left: auto; margin-right: auto; display: block;">
				</form>
			</div>
	</nav>
	<div class="container">
		<table class="table table-striped">
			<thead>
				<tr>
					<th>Serial</th>
					<th colspan="2">Client</th>
					<th>Phone</th>
					<th>Email</th>
					<th>Comments</th>
					<th>Resolve</th>
				</tr>
			</thead>
			<tbody>
				<%
					List<Request> reqs = (List) request.getAttribute("ReqForEmp");
				if (null != reqs) {
					for (int i = 0; i < reqs.size(); i++) {
						out.print("<tr>");
						out.print("<td>" + (i + 1) + "</td>");
						out.print("<td>" + reqs.get(i).getFirstName() + "</td>");
						out.print("<td>" + reqs.get(i).getLastName() + "</td>");
						out.print("<td>" + reqs.get(i).getPhone() + "</td>");
						out.print("<td>" + reqs.get(i).getEmail() + "</td>");
						out.print("<td>" + reqs.get(i).getComments() + "</td>");
						if (reqs.get(i).getType().equals("Unresolved")) {
				%>
				<td><form method="post"
						action="<%=request.getContextPath()%>/Site?page=ResolveRequest&req=<%=reqs.get(i).getId()%>&employee=<%=id%>">
						<input type="submit" class="btn btn-danger" value="Resolve"
							style="margin-left: auto; margin-right: auto; display: block;">
					</form></td>
				<%
					}
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