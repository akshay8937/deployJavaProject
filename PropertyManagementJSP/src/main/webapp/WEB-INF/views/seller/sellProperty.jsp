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
<form method="post" enctype="multipart/form-data" class="text-center border border-light p-5">
<table border="5" align="center" bgcolor="#DAF7A6" class="table" >
<h3 align="center">Sell Your Property</h3><br>
<tr>
<th>Select Property Type</th>
<td><select name="propType">
  <option value="Villa">Villa</option>
  <option value=" Flat 1BHK">Flat 1BHK</option>
  <option value="Flat 2BHK">Flat 2BHK</option>
  <option value="Flat 3BHK">Flat 3BHK</option>
  <option value="Residential Plot">Residential Plot</option>
  <option value="Shop">Shop</option>
  <option value="Building Multistorey">Multistorey Building</option>
  <option value="Warehouse">Warehouse</option>
  </select> </td>
</tr>
<tr>
<th>Enter City:</th>
<td><input type="text" name="city"/></td>
</tr>
<tr>
<th>Enter Address:</th>
<td><input type="text" name="address"/></td>
</tr>
<tr>
<th>Description About Property:</th>
<td><input type="text" name="description"/></td>
</tr>
<tr>
<th>Price:</th>
<td><input type="text" name="price"/></td>
</tr>
<tr>
<th>Upload image</th>
<td><input type="file" name="images"/></td>
</tr>
<tr>
<td colspan="2" align="center"><input type="submit" value="Save My Data"/>
<input type="reset" value="Reset Data"/>
</td>
</tr>
</table>
</form>
<pre>


</pre>
<h3  align="center"><a class="btn btn-danger" href="/seller/sellerDetails">Home</a></h3>

</body>
</html>
