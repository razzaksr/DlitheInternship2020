<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Enrollment of New Candidate</title>
</head>
<body>
<h3 style="color:blue;">${msg }</h3>
<%@taglib prefix="hai" uri="http://www.springframework.org/tags/form" %>
<hai:errors path="candidates.*"/>
<form action="added" method="post">
<table>
<tr><td><input type="text" name="regno" placeholder="Enter the reg no"></td></tr>
<tr><td><input type="text" name="name" placeholder="Enter the name"></td></tr>
<tr><td>
<select name="department">
<option>Select Any department</option><option>Computers</option><option>Information</option>
<option>Electronics</option><option>Electricals</option><option>Mechanicals</option>
</td></tr>
<tr><td><input type="number" name="cgpa" placeholder="Enter the CGPA"></td></tr>
<tr><td><input type="number" name="hsc" placeholder="Enter the HSC %"></td></tr>
<tr><td><input type="number" name="diploma" placeholder="Enter the diploma %"></td></tr>
<tr><td><input type="number" name="sslc" placeholder="Enter the SSLC %"></td></tr>
<tr><td><input type="text" name="skills" placeholder="Enter the Skill by / if more than one"></td></tr>
<tr><td><input type="text" name="certifications" placeholder="Enter the Certifications done"></td></tr>
<tr>
<td><input type="radio" name="career" value="IT">IT</td>
<td><input type="radio" name="career" value="Core">Core</td>
<td><input type="radio" name="career" value="Higher Studies">Higher Studies</td>
<td><input type="radio" name="career" value="Business">Business</td>
</tr>
<tr><td><input type="text" name="mobile" placeholder="Enter the mobile number"></td></tr>
<tr><td><input type="text" name="email" placeholder="Enter the email"></td></tr>
<tr><td><input type="text" name="status" placeholder="Enter the status"></td></tr>
<tr>
<td><input type="submit" value="Enroll"></td><td><input type="reset" value="Clear"></td>
</tr>
</table>
</form>
</body>
</html>