<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

<title>Insert title here</title>
</head>
<body>
	<h4 style="color: red;">${requestScope.msg}</h4>
	
 <div style="width:800px;height:800px;
	margin: auto">
<form class="text-center border border-light p-5" method="post">

    <p class="h4 mb-4">Sign in</p>

    <!-- Email -->
    <input type="email" id="email" name="email" class="form-control mb-4" placeholder="E-mail">

    <!-- Password -->
    <input type="password" id="password" name="password" class="form-control mb-4" placeholder="Password">
    
   
    
    <h4>Select Role</h4>
    
    <div class="radio">
  <label><input type="radio" name="role" value="seller" checked>Seller</label>
</div>
<div class="radio">
  <label><input type="radio" name="role" value="buyer">Buyer</label>
</div>
<div class="radio disabled">
  <label><input type="radio" name="role" value="admin" disabled>Admin</label>
</div>

    <!-- Sign in button -->
    <button class="btn btn-info btn-block my-4" type="submit">Sign in</button>


</form>
</div>
</body>
</html>