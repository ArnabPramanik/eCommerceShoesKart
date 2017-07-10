<!DOCTYPE html>
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

.bg {
	height: 250px;
}

.bg-2 {
	background: green;
	color: white;
	font-family: tahoma;
}

.bg-3 {
	background: black;
	color: white;
}

.bg-4 {
	background-color: #5555ff;
	color: #fff;
	font-family: tahoma;
}

.bg-5 {
	background-color: black;
	margin: 0 auto;
}

.bg-5>img {
	margin: 0 auto;
}

.carousel-inner>.item>img {
	margin: 0 auto;
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
      background-color:white;
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
	<!--Carousel -->
	<div class="container-fluid">
		<div id="Carousel" class="carousel slide" data-ride="carousel">

			<ol class="carousel-indicators">
				<li data-target="#Carousel" data-slide-to="0" class="active"></li>
				<li data-target="#Carousel" data-slide-to="1"></li>
				<li data-target="#Carousel" data-slide-to="2"></li>
				<li data-target="#Carousel" data-slide-to="3"></li>
				<li data-target="#Carousel" data-slide-to="4"></li>

			</ol>

			<div class="carousel-inner bg">
				<div class="item active">
					<img src="assets/images/shoesRack.jpg" alt="Option 1"
						style="width: 40%; height: 50%">
				</div>
				<div class="item">
					<img src="assets/images/10-percent-off.jpg" alt="Option 2"
						style="width: 50%; height: 50%">
				</div>
				<div class="item">
					<img src="assets/images/shoesonBench.jpg" alt="Option 3"
						style="width: 35%; height: 50%">
				</div>
				<div class="item">
					<img src="assets/images/shoes4.jpg" alt="Option 4"
						style="width: 20%; height: 50%">
				</div>
				<div class="item">
					<img src="assets/images/shoesonleg.jpg" alt="Option 5"
						style="width: 20%; height: 50%">
				</div>

			</div>

			<a class="left carousel-control" href="#Carousel" data-slide="prev">
				<span class="glyphicon glyphicon-chevron-left"></span> <span
				class="sr-only">Previous</span>
			</a> <a class="right carousel-control" href="#Carousel" data-slide="next">
				<span class="glyphicon glyphicon-chevron-right"></span> <span
				class="sr-only">Next</span>
			</a>
		</div>
	</div>

	<div class="container-fluid bg-5">
		<img src="assets/images/welcome2.png" class="img-responsive margin"
			style="width: 50%; height: 10%" alt="Image">

	</div>

	<!-- Third Container -->
	<div class="container-fluid bg-2 text-center">
		<h3 class="margin">ABOUT</h3>
		<p>This is an online marketplace where you can find low cost high
			quality products</p>

	</div>

	<div class="container-fluid bg-4 text-center">
		<div class="row">
			<div class="col-sm-6">
				<h3 class="margin">DISCOUNT</h3>

			</div>

			<div class="col-sm-6">
				<img src="assets/images/10-percent-off2.png" style="width: 40%" />
			</div>
		</div>
	</div>


	<div class="container-fluid text-center">

		<div class="row">
			<div class="col-sm-3">

				<img src="assets/images/cleat1.jpg" class="img-responsive margin"
					style="width: 60%" alt="Image">
			</div>
			<div class="col-sm-3">

				<img src="assets/images/shoes6.jpg" class="img-responsive margin"
					style="width: 60%" alt="Image">
			</div>
			<div class="col-sm-3">

				<img src="assets/images/shoes3.jpg" class="img-responsive margin"
					style="width: 60%" alt="Image">
			</div>
			<div class="col-sm-3">

				<img src="assets/images/shoes4.jpg" class="img-responsive margin"
					style="width: 60%" alt="Image">
			</div>



		</div>
	</div>
	<footer class="container-fluid bg-3 text-center">
		<p>Bootstrap theme made by Arnab.</p>
	</footer>

</body>
</html>





