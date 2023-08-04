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
<%@page import="java.util.List"%>
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
		List<String> category = (List) request.getAttribute("CategoryList");
	List<String> subCategory = (List) request.getAttribute("SubCategoryList");

	String id = (String) request.getParameter("client");
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
</body>
<body>
	<form style="margin-left: 80px; margin-right: 80px; margin-top: 50px"
		name="myform" method="post"
		action="<%=request.getContextPath()%>/SubmitRequest?client=<%=id%>"
		onsubmit="return validateform()">

		<div class="form-group">
			<label for="inputCategories">Categories</label> <select
				class="form-control form-control-lg" name="FormCategory">
				<%
					for (String s : category) {
				%>
				<option><%=s%></option>
				<%
					}
				%>
			</select>
		</div>
		<div class="form-group">
			<label for="inputSubCategories">Sub Categories</label> <select
				class="form-control form-control-lg" name="FormSubCategory">
				<%
					for (String s : subCategory) {
				%>
				<option><%=s%></option>
				<%
					}
				%>
			</select>
		</div>
		<div class="form-group">
			<label for="inputAddress">Comments</label> <input type="text"
				class="form-control" id="Comments" name="Comments"
				placeholder="I want to go to the hospital...">
		</div>
		<input type="submit" class="btn btn-danger" value="Submit"
			style="margin-left: auto; margin-right: auto; display: block;">
	</form>
</body>
</html>