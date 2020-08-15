<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Search Candidates</title>
</head>
<body>
<%response.setHeader("Cache-Control", "no-cache");
response.setHeader("Cache-Control", "no-store");
response.setHeader("Pragma", "no-cache");
response.setDateHeader("Expires", 0); %>
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
<h2><a href="home">Home</a></h2>
<h2><a href="logout">Logout</a></h2>
</body>
</html>