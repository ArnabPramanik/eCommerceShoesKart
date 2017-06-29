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




<body>

	<div>
		<form:form method = "POST" action = "/ShoesKartFrontend/admin/product/add" modelAttribute = "product">
			
			<div class="form-group">
				 <form:hidden path="prodid"/>
			</div>
			<div class="form-group">
				<label>Product Name:</label>
				 <form:input 
					class="form-control" path="name"/>
			</div>
			<div class="form-group">
				<label>Product Quantity:</label>
				 <form:input
					class="form-control" path="quantity"/>
			</div>
			<div class="form-group">
				<label>Product Price:</label>
				 <form:input
					class="form-control" path="price"/>
			</div>
			<div class="form-group">
				<label>Product Description:</label>
				 <form:input
					class="form-control" path="description"/>
			</div>
			
			<div class="form-group">
				<label>Category List:</label>
				 <form:select path="cat.catid">
						<form:option value="0" label="------Select----" />
						<form:options items="${catList}" itemValue = "catid" itemLabel = "catname"/>
					</form:select>
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
						<th>Description</th>
						<th>Price</th>
						<th>Quantity</th>
						<th>Category</th>
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
							<td><a class="btn btn-warning"
								href="/ShoesKartFrontend/admin/product/update/${prodItem.prodid}">Edit</a></td>
							<td><a class="btn btn-danger"
								href="/ShoesKartFrontend/admin/product/delete/${prodItem.prodid}">Delete</a></td>

						</tr>
					</c:forEach>
				</tbody>
			</table>

		</div>
	</div>
</body>
</html>