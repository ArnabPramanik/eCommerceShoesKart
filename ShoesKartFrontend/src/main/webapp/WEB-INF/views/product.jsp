<%@ page language="java" contentType="text/html" %>

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

	
	
	<div class="container">
		<div class="table-responsive">
			<table class="table">
				<thead>

					<tr>
						<th>Id</th>
						<th>name</th>
						<th>Description</th>
						<th>Price</th>
						<th>Quantity</th>
						<th>Category</th>
						<th>Supplier</th>
						<th></th>
						<th></th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${prodList}" var="prodItem">
						<tr>
							<td>${prodItem.prodid}</td>
							<td>${prodItem.name }</td>
							<td>${prodItem.description }</td>
							<td>${prodItem.price }</td>
							<td>${prodItem.quantity}</td>
							<td>${prodItem.cat.catname}</td>
							<td>${prodItem.supplier.name}</td>
							<td><img src = "<c:url value = "/assets/images/${prodItem.name}.jpg"/>" height="50px" width="50px"/></td>
							<td><a class="btn btn-warning"
								href="/ShoesKartFrontend/product/view/${prodItem.prodid}">View</a></td>
							<td><a class="btn btn-danger"
								href="/ShoesKartFrontend/user/product/addtocart/${prodItem.prodid}">Add to Cart</a></td>

						</tr>
					</c:forEach>
				</tbody>
			</table>

		</div>
	</div>
</body>
</html>