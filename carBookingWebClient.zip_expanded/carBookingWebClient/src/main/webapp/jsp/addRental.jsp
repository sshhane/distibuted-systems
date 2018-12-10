<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">	
<html>
<head>
<link href="/css/style.css" rel="stylesheet"></link>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Car Hire - Create Booking</title>
</head>
<body>
	<h1>Car Hire Service - Add Booking</h1>
	<form:form modelAttribute="booking" varStatus="vs">
 		<table>
			<tr>
				<td>Account No:</td>
				<td><form:input path="accounts.accNo"></form:input></td>
			</tr>
			<tr>
				<td>Hire From (YYYY/mm/DD): </td>
				<td><form:input path="rentalDate"></form:input></td>
			</tr>
			<tr>
				<td>Return Date (YYYY/mm/DD):</td>
				<td><form:input path="returnDate"></form:input></td>
			</tr>
			<tr>
				<td>Select Car:</td>
				<td><form:input path="cars[0].rentalId"  /></td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="submit" value="Create Booking"/>
				</td>
			</tr>
		</table> 
	</form:form>
	<a href="createbooking">Back</a>
</body>
</html>