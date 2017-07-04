<%@ page language="java" contentType="text/html"%>



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


<body>
	<form method = "POST" action = "/ShoesKartFrontend/login">
		<div class="form-group">
			<label>User name</label> <input class="form-control"
				name="username"/>
		</div>
		
		<div class="form-group">
			<label>Password:</label> <input type="password" class="form-control"
				name="password"/>
		</div>
		<button type="submit" class="btn btn-default">Submit</button>
	</form>
</body>
</html>