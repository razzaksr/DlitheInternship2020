<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Letting to Update</title>
</head>
<body>
<%response.setHeader("Cache-Control", "no-cache");
response.setHeader("Cache-Control", "no-store");
response.setHeader("Pragma", "no-cache");
response.setDateHeader("Expires", 0); %>
<form action="alter" method="post">
<table>
<tr><td><input type="text" name="regno" value="${fetched.regno }"></td></tr>
<tr><td><input type="text" name="name" value="${fetched.name }"></td></tr>
<tr><td><input type="text" name="department" value="${fetched.department }"></td></tr>
<tr><td><input type="text" name="cgpa" value="${fetched.cgpa }"></td></tr>
<tr><td><input type="text" name="hsc" value="${fetched.hsc }"></td></tr>
<tr><td><input type="text" name="diploma" value="${fetched.diploma }"></td></tr>
<tr><td><input type="text" name="sslc" value="${fetched.sslc }"></td></tr>
<tr><td><input type="text" name="skills" value="${fetched.skills }"></td></tr>
<tr><td><input type="text" name="certifications" value="${fetched.certifications }"></td></tr>
<tr><td><input type="text" name="career" value="${fetched.career }"></td></tr>
<tr><td><input type="text" name="mobile" value="${fetched.mobile }"></td></tr>
<tr><td><input type="text" name="email" value="${fetched.email }"></td></tr>
<tr><td><input type="text" name="status" value="${fetched.status }"></td></tr>
<tr><td><input type="submit" value="Update"></td></tr>
</table>
</form>
<h2><a href="home">Home</a></h2>
<h2><a href="logout">Logout</a></h2>
</body>
</html>