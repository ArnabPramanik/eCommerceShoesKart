<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html"%>
<html lang="en">
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
ul>li {
	margin-right: 25px;
	font-weight: lighter;
	cursor: pointer
}

li.active {
	border-bottom: 3px solid silver;
}

.item-photo {
	display: flex;
	justify-content: center;
	align-items: center;
	border-right: 1px solid #f6f6f6;
}

.menu-items {
	list-style-type: none;
	font-size: 11px;
	display: inline-flex;
	margin-bottom: 0;
	margin-top: 20px
}

.btn-success {
	width: 100%;
	border-radius: 0;
}

.section {
	width: 100%;
	margin-left: -15px;
	padding: 2px;
	padding-left: 15px;
	padding-right: 15px;
	background: #f8f9f9
}

.title-price {
	margin-top: 30px;
	margin-bottom: 0;
	color: black
}

.title-attr {
	margin-top: 0;
	margin-bottom: 0;
	color: black;
}

.btn-minus {
	cursor: pointer;
	font-size: 7px;
	display: flex;
	align-items: center;
	padding: 5px;
	padding-left: 10px;
	padding-right: 10px;
	border: 1px solid gray;
	border-radius: 2px;
	border-right: 0;
}

.btn-plus {
	cursor: pointer;
	font-size: 7px;
	display: flex;
	align-items: center;
	padding: 5px;
	padding-left: 10px;
	padding-right: 10px;
	border: 1px solid gray;
	border-radius: 2px;
	border-left: 0;
}

div.section>div {
	width: 100%;
	display: inline-flex;
}

div.section>div>input {
	margin: 0;
	padding-left: 5px;
	font-size: 10px;
	padding-right: 5px;
	max-width: 18%;
	text-align: center;
}

.attr, .attr2 {
	cursor: pointer;
	margin-right: 5px;
	height: 20px;
	font-size: 10px;
	padding: 2px;
	border: 1px solid gray;
	border-radius: 2px;
}

.attr.active, .attr2.active {
	border: 1px solid orange;
}

@media ( max-width : 426px) {
	.container {
		margin-top: 0px !important;
	}
	.container>.row {
		padding: 0 !important;
	}
	.container>.row>.col-xs-12.col-sm-5 {
		padding-right: 0;
	}
	.container>.row>.col-xs-12.col-sm-9>div>p {
		padding-left: 0 !important;
		padding-right: 0 !important;
	}
	.container>.row>.col-xs-12.col-sm-9>div>ul {
		padding-left: 10px !important;
	}
	.section {
		width: 104%;
	}
	.menu-items {
		padding-left: 0;
	}
}
</style>
<body>

	<div class="container-fluid">
		<nav class="navbar navbar-default">
			<div class="container-fluid">
				<div class="navbar-header">
					<a class="navbar-brand" href="/ShoesKartFrontend/user/home">ShoesKart</a>
				</div>
				<ul class="nav navbar-nav">
					<li><a href="/ShoesKartFrontend/user/home">Home</a></li>
					<li><a href="/ShoesKartFrontend/perform_logout">Logout</a></li>
				</ul>
				<ul class="nav navbar-nav navbar-right">
					<li><a href="/ShoesKartFrontend/user/product"> Products</a></li>
					<li><a href="/ShoesKartFrontend/user/cart"> Cart</a></li>
					<li><a href="/ShoesKartFrontend/user/contactus"> Contact Us</a></li>
					<li><a href="/ShoesKartFrontend/user/aboutus"> About Us</a></li>
				</ul>

			</div>
		</nav>
	</div>


	<div class="container">
		<div class="row">
			<div class="col-xs-4 item-photo">
				<img style="max-width: 100%;"
					src="<c:url value = "/assets/images/${product.name}.jpg"/>" />
			</div>
			<div class="col-xs-5" style="border: 0px solid gray">
				<!-- Datos del vendedor y titulo del producto -->
				<h3>${product.name}</h3>

				<!-- Precios -->
				<h6 class="title-price">PRICE</h6>
				<h3 style="margin-top: 0px;">${product.price}</h3>
				<h6 class="title-price">Supplier</h6>
				<h3 style="margin-top: 0px;">${product.supplier.name}</h3>
				<h6 class="title-price">Category</h6>
				<h3 style="margin-top: 0px;">${product.cat.catname}</h3>
				<!-- Detalles especificos del producto -->
				<form
					action="/ShoesKartFrontend/user/product/addtocart2/${product.prodid}">
					<div class="section" style="padding-bottom: 20px;">
						<h6 class="title-attr">Quantity</h6>
						<div>

							<input type="number" min = "1" value="1" name="quantity" required = "required" />

						</div>
					</div>

					<!-- Botones de compra -->
					<div class="section" style="padding-bottom: 20px;">
						<button class="btn btn-success" type="submit">
							<span style="margin-right: 20px"
								class="glyphicon glyphicon-shopping-cart" aria-hidden="true"></span>
							Add to Cart
						</button>
					</div>
				</form>
			</div>

			<div class="col-xs-9">
				<ul class="menu-items">
					<li class="active">Product Details</li>
				</ul>
				<div style="width: 100%; border-top: 1px solid silver">
					<p style="padding: 15px;">
						<small> ${product.description} </small>
					</p>
				</div>
			</div>
		</div>
	</div>


</body>
</html>






