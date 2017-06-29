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




<body>

	<div>
		<form:form method = "POST" action = "/ShoesKartFrontend/admin/add/cat" modelAttribute = "category">
			
			<div class="form-group">
				 <form:hidden path="catid"/>
			</div>
			<div class="form-group">
				<label>Category Name:</label>
				 <form:input 
					class="form-control" path="catname"/>
			</div>
			<div class="form-group">
				<label>Category Description:</label>
				 <form:input
					class="form-control" path="catdesc"/>
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