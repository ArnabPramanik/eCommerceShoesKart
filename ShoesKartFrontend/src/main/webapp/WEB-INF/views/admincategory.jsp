<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<head>
<title>HomePage</title>
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

.open .dropdown-toggle {
	color: yellow;
	background-color: black !important;
}

.close .dropdown-toggle {
	color: white;
	background-color: black !important;
}

.dropdown-menu li a {
	color: black !important;
	background-color: white;
}

.dropdown-menu li a:hover {
	background-color: red !important;
}
</style>


<body>
	<div class="container-fluid">
		<nav class="navbar navbar-default">
			<div class="container-fluid">
				<div class="navbar-header">
					<a class="navbar-brand" href="/ShoesKartFrontend/admin/home">ShoesKart</a>
				</div>
				<ul class="nav navbar-nav">
					<li><a href="/ShoesKartFrontend/admin/home">Home</a></li>
					<li><a href="/ShoesKartFrontend/perform_logout">Logout</a></li>
				</ul>
				<ul class="nav navbar-nav navbar-right">
					<li class="dropdown"><a class="dropdown-toggle"
						data-toggle="dropdown" href="#">Admin <span class="caret"></span></a>
						<ul class="dropdown-menu">
							<li><a href="/ShoesKartFrontend/admin/category">category</a></li>
							<li><a href="/ShoesKartFrontend/admin/product">product</a></li>
							<li><a href="/ShoesKartFrontend/admin/supplier">supplier</a></li>
						</ul></li>
					<li><a href="/ShoesKartFrontend/admin/contactus"> Contact Us</a></li>
					<li><a href="/ShoesKartFrontend/admin/aboutus"> About Us</a></li>
				</ul>

			</div>
		</nav>
	</div>


	<div>
		<form:form method="POST" action="/ShoesKartFrontend/admin/add/cat"
			modelAttribute="category">

			<div class="form-group">
				<form:hidden path="catid" />
			</div>
			<div class="form-group">
				<label>Category Name:</label>
				<form:input class="form-control" path="catname" required = "required"/>
			</div>
			<div class="form-group">
				<label>Category Description:</label>
				<form:input class="form-control" path="catdesc" required = "required" />
			</div>

			<button type="submit" class="btn btn-default">Submit</button>
		</form:form>

	</div>


	<div class="container">
		<div class="table-responsive">
			<table class="table">
				<thead>

					<tr>
						<th>Id</th>
						<th>name</th>
						<th>Desc</th>
						<th></th>
						<th></th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${list}" var="cat">
						<tr>
							<td>${cat.catid}</td>
							<td>${cat.catname }</td>
							<td>${cat.catdesc }</td>
							<td><a class="btn btn-warning"
								href="/ShoesKartFrontend/admin/updatecategoryview/${cat.catid}">Edit</a></td>
							<td><a class="btn btn-danger"
								href="/ShoesKartFrontend/admin/deletecategory/${cat.catid}">Delete</a></td>

						</tr>
					</c:forEach>
				</tbody>
			</table>

		</div>
	</div>
</body>
</html>