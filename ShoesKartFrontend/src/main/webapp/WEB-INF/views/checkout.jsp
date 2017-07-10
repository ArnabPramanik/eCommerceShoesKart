<%@ page language="java" contentType="text/html"%>

  <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<html>
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
<div class="container">
	<div class="table-responsive">
		<table class="table">
			<thead>

				<tr>
					<th></th>
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
						<td>${cartItem.prodid}</td>
						<td>${cartItem.prodname }</td>
						<td>${cartItem.price*cartItem.quantity}</td>
						<td>${cartItem.quantity}</td>
						

					</tr>
				</c:forEach>
			</tbody>
		</table>

	</div>
</div>
<br/>
GrandTotal = ${grandtotal}
<br/>
<form action="/ShoesKartFrontend/user/payment" method="POST">
payment type <div class="radio" >
  <label><input type="radio" name="optradio">Cash</label>
</div>
<div class="radio">
  <label><input type="radio" name="optradio">Credit Card</label>
</div>
shipping address<input type="text" name="shipping" required/>



<input type="submit" value="payment "name="submit"/>
</form>
</body>
</html>