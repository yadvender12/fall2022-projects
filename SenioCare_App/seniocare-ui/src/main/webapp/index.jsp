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
  background-image:url('old.png');
  background-repeat:no-repeat;
 background-size: cover;
}
</style>
</head>

<body >
	<nav class="navbar navbar-inverse">
		<div class="container-fluid">
			<div class="navbar-header">
				<a class="navbar-brand" href="#">SenioCare</a>
			</div>
		</div>
	</nav>
	<form style="margin-left: 80px; margin-right: 80px; margin-top: 50px"
		name="myform" method="post"
		action="<%=request.getContextPath()%>/InitialLogin"
		onsubmit="return validateform()">
		<div class="form-group">
			<label for="Name">Person Id</label> <input type="text"
				class="form-control" name="Id" id="Id"
				placeholder="Enter your person id">
		</div>
		<input type="submit" class="btn btn-danger" value="Submit"
			style="margin-left: auto; margin-right: auto; display: block;">
	</form>
	</body>
</html>