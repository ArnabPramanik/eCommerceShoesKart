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


<div class="container">
	<div class="table-responsive">
		<table class="table">
			<thead>

				<tr>
					<th></th>
					<th>cartItemId</th>
					<th>productId</th>
					<th>Name</th>
					<th>Price</th>
					<th>Quantity</th>
					<th></th>
					<th></th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${cartList}" var="cartItem">
					<tr>
						<td><img src = "<c:url value = "/assets/images/${cartItem.prodname}.jpg"/>" height="50px" width="50px"/></td>
						<td>${cartItem.cartitemid}</td>
						<td>${cartItem.prodid}</td>
						<td>${cartItem.prodname }</td>
						<td>${cartItem.price*cartItem.quantity}</td>
						
						<td><form action = "/ShoesKartFrontend/user/update/${cartItem.cartitemid}"><input type="text" value="${cartItem.quantity}" name="quantity"/><input type="submit" value="update"></form></td>
						
			
							<td><a class="btn btn-danger"
							href="/ShoesKartFrontend/user/delete/${cartItem.cartitemid}">Delete</a></td>
						

					</tr>
				</c:forEach>
			</tbody>
		</table>

	</div>
</div>
<a class="btn btn-danger" href = "/ShoesKartFrontend/user/home">Continue Shopping</a>
<a class = "btn btn-danger" href = "/ShoesKartFrontend/user/checkout">Purchase</a>
</body>
</html>