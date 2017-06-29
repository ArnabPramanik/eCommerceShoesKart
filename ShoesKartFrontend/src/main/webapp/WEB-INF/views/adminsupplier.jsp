<%@ page language="java" contentType="text/html"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<head>
<title>Bootstrap Example</title>
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
	<form:form modelAttribute="supplier"
		action="/ShoesKartFrontend/admin/supplier/add" method="post">
		<div class="form-group">
			<form:hidden path="id" class="form-control" />
		</div>
		<div class="form-group">
			<label for="name">Name:</label>
			<form:input path="name" class="form-control" />
		</div>
		<div class="form-group">
			<label for="address">Address:</label>
			<form:input path="address" class="form-control" />
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
						<th>Address</th>
						<th></th>
						<th></th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${supList}" var="supItem">
						<tr>
							<td>${supItem.id}</td>
							<td>${supItem.name }</td>
							<td>${supItem.address }</td>
							<td><a class="btn btn-warning"
								href="/ShoesKartFrontend/admin/supplier/update/${supItem.id}">Edit</a></td>
							<td><a class="btn btn-danger"
								href="/ShoesKartFrontend/admin/supplier/delete/${supItem.id}">Delete</a></td>

						</tr>
					</c:forEach>
				</tbody>
			</table>

		</div>
	</div>
	
	</body>
	