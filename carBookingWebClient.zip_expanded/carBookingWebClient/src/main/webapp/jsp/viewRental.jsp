<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>View</title>
</head>
<body>
	<table>
		<tr>
			<th>Rental ID</th>
			<td>${order.rentalId}</td>

			<th>Car ID</th>
			<th>Customer ID</th>
			<th>Date</th>
			<th>${url}</th>
		</tr>
		
			<tr>
				<td>${Order.rentalId}</td>
				<td>${Order.carId}</td>
				<td>${Order.customerId}</td>
				<td>${Order.date}</td>
			</tr>

<%-- 		<c:forEach items="${orders}" var="order">
			<tr>
				<td>${order.rentalID}</td>
				<td>${order.carId}</td>
				<td>${order.customerId}</td>
				<td>${order.date}</td>
			</tr>
		</c:forEach> --%>
	</table>
</body>
</html>