<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

<title>Insert title here</title>
</head>
<body>
<h3>${requestScope.mesg}</h3>
<pre><h4>Welcome Buyer: ${sessionScope.buyer_dtls.name}</h4>                                                                                                                                                                                          <a class="btn btn-danger" href="<spring:url value='/user/sellerLogout'/>">Log Me Out</a></pre>
	
	<form class="text-center border border-light p-5">
<table class="table">
 <thead class="thead-dark">

		<h3 align="center">Available Properties</h3><br>
		<tr>
		<!-- <th>Property Id:</th> -->
		<th>Property Type:</th>
		<th>Property City:</th>
		<th>Property Address:</th>
		<th>Property Description:</th>
		<th>Property Price:</th>
		<th>Property Status:</th>
		<th>Property Image:</th>
		<th>Book Now:</th>
		</thead>
		<c:forEach var="p" items="${requestScope.property_list}">
			<tr>
			<%-- <td>${p.propertyId}</td> --%>
				<td>${p.propType}</td>
				<td>${p.city}</td>
				<td>${p.address}</td>
				<td>${p.description}</td>
				<td>${p.price}</td>
				<td>${p.status}</td>
				<td><img width="200" height="200" src="/myImage/imageDisplay?id=${p.propertyId}"/></td>
				<td><a class="btn btn-success" href="<spring:url value='/buyer/bookConfirmed?pid=${p.propertyId}&bid= ${sessionScope.buyer_dtls.bid}'/>">Book Now</a></td>
				
				<%-- <td><a href="<spring:url value='/admin/update?vid=${v.id}'/>">Update</a></td>
				<td><a href="<spring:url value='/admin/delete?vid=${v.id}'/>">Delete</a></td> --%>

			</tr>
		</c:forEach>
		
	</table>
	</form>
	
</body>
</html>