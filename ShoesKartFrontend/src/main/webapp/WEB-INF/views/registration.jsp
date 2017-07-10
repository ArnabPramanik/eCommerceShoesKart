<%@ page language="java" contentType="text/html"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<title>Registration page</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<style>

  
.navbar {
	background-color: #ff0000;
	padding-top: 10px;
	padding-bottom: 10px;
	border: 0;
	border-radius: 0;
	margin-bottom: 0;
	font-size: 12px;
	font-family: Tahoma;
	letter-spacing: 2px;
}

.navbar-nav  li a:hover {
	color: #ffffff !important;
}

.navbar-default .navbar-nav>.active>a {
	background: red;
	color: black;
}

.navbar-default .navbar-nav>.active>a:focus {
	background: black;
	color: yellow;
}

.navbar-default .navbar-nav>.active>a:hover {
	background: red;
	color: white;
}

.navbar-default .navbar-nav>li>a {
	background: red;
	color: black;
}

.navbar-default .navbar-nav>li>a:hover {
	background: red;
	color: white;
}

.navbar-default .navbar-nav>li>a:focus {
	background: black;
	color: yellow;
}

.navbar-default .navbar-header>.navbar-brand {
	color: blue;
}

.navbar-default .navbar-header>.navbar-brand:hover {
	color: white;
}

.navbar-default .navbar-header>.navbar-brand:focus {
	color: black;
}

</style>
<body>
	<div class="container-fluid">
		<nav class="navbar navbar-default">
			<div class="container-fluid">
				<div class="navbar-header">
					<a class="navbar-brand" href="index">ShoesKart</a>
				</div>
				<ul class="nav navbar-nav">
					<li><a href="index">Home</a></li>
					<li><a href="/ShoesKartFrontend/login">Sign In</a></li>
					<li><a href="/ShoesKartFrontend/signup">Sign Up</a></li>
				</ul>
				<ul class="nav navbar-nav navbar-right">
					<li><a href="/ShoesKartFrontend/product"> Products</a></li>
					<li><a href="/ShoesKartFrontend/contactus"> Contact Us</a></li>
					<li><a href="/ShoesKartFrontend/aboutus"> About Us</a></li>
				</ul>

			</div>
		</nav>
	</div>

	<form:form method="POST" action="/ShoesKartFrontend/register"
		modelAttribute="user">
		<div class="form-group" >
			<label>User name</label>
			<form:input class="form-control" path="username" required="required" />
		</div>
		<div class="form-group">
			<label>Password:</label>
			<form:input type="password" class="form-control" path="password" required="required" />
		</div>
		<div class="form-group">
			<label>Email address:</label>
			<form:input type="email" class="form-control" path="email" required="required"/>
		</div>
		<div class="form-group">
			<label>Name</label>
			<form:input type="text" class="form-control" path="custname" required="required"/>
		</div>
		<div class="form-group">
			<label>Role</label>
			<form:select path="role">
				<form:option value="0" label="select" />
				<form:options items="${role_list}" required="required"/>
			</form:select>

		</div>
		<div class="form-group">
			<label>Address</label>
			<form:input type="text" class="form-control" path="address"  required="required"/>
		</div>
		<div class="form-group">
			<label>Mobile</label>
			<form:input type="number" class="form-control" path="mobile" required="required" />
		</div>
		<div class="form-group">
			<form:hidden class="form-control" path="enabled" value="TRUE" />
		</div>
		<button type="submit" class="btn btn-default">Submit</button>
	</form:form>
</body>
</html>