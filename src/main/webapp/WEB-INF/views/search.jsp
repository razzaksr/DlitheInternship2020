<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Search Candidates</title>
</head>
<body>
<form action="fetch" method="post">
<table>
<tr><td><input type="text" name="regno" placeholder="Enter the regno to fetch"></td></tr>
<tr><td><select name="department">
<option>Select Any Department</option><option>Computers</option><option>Information</option>
<option>Electronics</option><option>Electricals</option><option>Mechanical</option>
</select></td></tr>
<tr><td><select name="career">
<option>Select Any Career</option><option>IT</option><option>Core</option>
<option>Higher Studies</option><option>Entrepreneur</option>
</select></td></tr>
<tr><td><select name="status">
<option>Select Any Status</option>
<option>Placed</option><option>Not Placed</option>
</select></td></tr>
<tr><td><input type="submit" value="Fetch"></td></tr>
</table>
</form>
</body>
</html>