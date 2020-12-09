<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

<title>Insert title here</title>
</head>
<body>
<h3>${requestScope.msg}</h3>

	<h4>Welcome Seller : ${sessionScope.seller_dtls.name}</h4>
	<hr size="10"></hr>
	<h3 align="center"><pre><a  class="btn btn-outline-primary" role="botton "href="<spring:url  value='/seller/sellProperty?sid=${sessionScope.seller_dtls.sid}'/>">Sell Property </a> | <a class="btn btn-outline-primary" role="botton" href="<spring:url value='/seller/showProperty?sid=${sessionScope.seller_dtls.sid}'/>">See Uploaded Properties</a> | <a class="btn btn-outline-primary" role="botton" href="<spring:url value='/seller/deleteProperty'/>">Delete Property</a> | <a  class="btn btn-outline-primary" role="botton "href="<spring:url  value='/seller/bookedProperty?sid=${sessionScope.seller_dtls.sid}'/>">See Booked Properties </a> </pre></h3>
	<br>
	<pre>
	
	
	
	</pre>
	<h4 align="center">
		<a class="btn btn-danger" href="<spring:url value='/user/sellerLogout'/>">Log Me Out</a>
	</h4>
</body>
</html>