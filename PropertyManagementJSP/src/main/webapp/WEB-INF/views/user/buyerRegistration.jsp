<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

<title>Insert title here</title>
</head>
<body>
<h2 align="center">Buyer Registration</h2>

	<sf:form method="post" modelAttribute="buyer" class="text-center border border-light p-5">

		<table border="5" align="center" style="background-color: #DAF7A6;">
			<tr>
				<td>Enter User Email</td>
				<td><sf:input path="email" /></td>
				<td><sf:errors path="email" /></td>
			</tr>
			<tr>
				<td>Enter User Name</td>
				<td><sf:input path="name" /></td>
				<td><sf:errors path="name" /></td>
			</tr>
			<tr>
				<td>Enter Password</td>
				<td><sf:password path="password" /></td>
				<td><sf:errors path="password" /></td>
			</tr>
			
			
			<tr>
				<td>Enter Address</td>
				<td><sf:input path="address" /></td>
				<td><sf:errors path="address" /></td>
			</tr>
			<tr>
				<td>Enter Mobile No</td>
				<td><sf:input path="mobNo" /></td>
				<td><sf:errors path="mobNo" /></td>
			</tr>

			<tr>
				<td><input type="submit" value="Register New Buyer" /></td>


			</tr>
		</table>
	</sf:form>


</body>
</html>

