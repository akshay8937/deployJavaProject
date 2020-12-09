<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

<title>Insert title here</title>
</head>
<body>
<h3 align="center">Buyer Detail</h3><br>
<form class="text-center border border-light p-5">
<table class="table">
 <thead class="thead-dark">
		<tr>
		<th>Name:</th>
		<th>Address:</th>
		<th>Mobile Number:</th>
		<th>Email Id:</th>
		</thead>
			<tr>
			<td>${requestScope.buyer_dtls.name}</td>
				<td>${requestScope.buyer_dtls.address}</td>
				<td>${requestScope.buyer_dtls.mobNo}</td>
				<td>${requestScope.buyer_dtls.email}</td>

			</tr>
		
	</table>
	</form>
</body>
</html>