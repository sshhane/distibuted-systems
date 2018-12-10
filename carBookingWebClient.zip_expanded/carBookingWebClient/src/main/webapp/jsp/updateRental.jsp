<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Car Hire Service - Update Booking</h1>
	<form:form modelAttribute="rental" varStatus="vs">
 		<table>
			<tr>
				<td>Rental ID:</td>
				<td><form:input path="rentals.rentalId"></form:input></td>
			</tr>
			<tr>
				<td>Car ID:</td>
				<td><form:input path="rentals.carId"></form:input></td>
			</tr>
			<tr>
				<td>Customer ID:</td>
				<td><form:input path="rentals.customerId"></form:input></td>
			</tr>
			<tr>
				<td>Hire From (YYYY/mm/DD): </td>
				<td><form:input path="rentals.date"></form:input></td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="submit" value="Create Rental"/>
				</td>
			</tr>
		</table> 
	</form:form>
	<a href="createbooking">Back</a>
</body>

</body>
</html>